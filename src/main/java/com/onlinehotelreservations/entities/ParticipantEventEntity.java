package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.ParticipantEventStatus;
import com.onlinehotelreservations.shared.enums.QuestionFiledType;
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
@Table(name = "participant_events")
public class ParticipantEventEntity extends BaseAuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private int eventId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipantEventStatus status;

    @Column(nullable = false)
    private String reasonReject;

    @Column(nullable = false)
    protected String createdBy;

    @Column(nullable = false)
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
