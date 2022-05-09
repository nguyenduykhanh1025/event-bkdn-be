package com.onlinehotelreservations.DTOs.event;

import com.onlinehotelreservations.shared.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventNeedUpdateDTO {
    private int id;

    private String title;

    private EventType type;

    private int countNeedParticipate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endAt;

    private String address;

    private String description;

    private String descriptionParticipant;

    private String descriptionRequired;

    private String imagesStr;
}
