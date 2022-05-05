package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.ParticipantEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantEventRepository extends JpaRepository<ParticipantEventEntity, Integer> {
}
