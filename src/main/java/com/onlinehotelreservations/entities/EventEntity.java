package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.EventStatus;
import com.onlinehotelreservations.shared.enums.EventType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
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

    @Column(nullable = true)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private EventType type;

    @Column(nullable = true)
    private int countNeedParticipate;

    @Column(nullable = true)
    private int countParticipated;

    @Column(nullable = true)
    private int countRegistered;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date startAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endAt;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String descriptionParticipant;

    @Column(nullable = false)
    private String descriptionRequired;

    @Column(nullable = false)
    private String imagesStr;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private EventStatus status = EventStatus.INCOMING;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(nullable = true, updatable = false)
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
    @Column(updatable = false)
    protected Date createdAt = new Date();
}
