package com.onlinehotelreservations.entities;

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
@Table(name = "questions_filed_answers")
public class QuestionFiledAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int participantEventId;

    private int questionFiledId;

    private int eventId;

    private int participantId;

    @Column(nullable = false)
    private String answers;
}
