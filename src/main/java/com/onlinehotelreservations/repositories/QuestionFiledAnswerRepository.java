package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.QuestionFiledAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionFiledAnswerRepository extends JpaRepository<QuestionFiledAnswerEntity, Integer> {
}
