package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.entities.NewsEntity;
import com.onlinehotelreservations.shared.enums.EventStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
    Page<NewsEntity> findByIsActive(Boolean isActive, Pageable pageable);
    Optional<NewsEntity> findByTitle(String title);
}
