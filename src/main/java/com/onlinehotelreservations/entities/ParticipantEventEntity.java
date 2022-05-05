package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.ParticipantEventStatus;
import com.onlinehotelreservations.shared.enums.QuestionFiledType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participant_events")
public class ParticipantEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int participantId;

    private int eventId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipantEventStatus status;

    @Column(nullable = false)
    private String reasonReject;
}
