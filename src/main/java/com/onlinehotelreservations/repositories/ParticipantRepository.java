package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Integer> {
}
