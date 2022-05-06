package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.EventStatus;
import com.onlinehotelreservations.shared.enums.EventType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class EventEntity extends BaseAuthEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String title;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EventType type;

  @Column(nullable = false)
  private int countNeedParticipate;

  @Column(nullable = false)
  private int countParticipated;

  @Column(nullable = false)
  private int countRegistered;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date startAt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date endAt;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String descriptionParticipant;

  @Column(nullable = false)
  private String descriptionRequired;

  @Column(nullable = false)
  private String imagesStr;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  @Builder.Default
  private EventStatus status = EventStatus.INCOMING;

  @Column(nullable = true)
  protected String createdBy;

  @Column(nullable = true)
  protected String updatedBy;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  @Builder.Default
  protected Date updatedAt = new Date();

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  @Builder.Default
  protected Date createdAt = new Date();
}
