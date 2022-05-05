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
@Table(name = "question_select_options")
public class QuestionSelectOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int questionFiledId;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String value;
}
