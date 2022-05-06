package com.onlinehotelreservations.DTOs.event;

import com.onlinehotelreservations.shared.enums.EventStatus;
import com.onlinehotelreservations.shared.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponseDTO {
  private int id;

  private String title;

  private EventType type;

  private int countNeedParticipate;

  private int countParticipated;

  private int countRegistered;

  private Date startAt;

  private Date endAt;

  private String address;

  private String description;

  private String descriptionParticipant;

  private String descriptionRequired;

  private String imagesStr;

  private String status;

  protected String createdBy;

  protected String updatedBy;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updatedAt;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createdAt;
}
