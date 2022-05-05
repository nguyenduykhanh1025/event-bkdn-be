package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
}
