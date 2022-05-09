package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.shared.enums.EventStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    Optional<EventEntity> findByTitle(String title);

    Page<EventEntity> findByStatusAndIsActive(EventStatus status, Boolean isActive, Pageable pageable);
}
