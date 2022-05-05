package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.QuestionFiledType;
import com.onlinehotelreservations.shared.enums.SexType;
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
@Table(name = "questions_filed")
public class QuestionFiledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int eventId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionFiledType type;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private String answersCorrect;
}
