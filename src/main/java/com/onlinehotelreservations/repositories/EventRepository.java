package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
  Optional<EventEntity> findByTitle(String title);
}
