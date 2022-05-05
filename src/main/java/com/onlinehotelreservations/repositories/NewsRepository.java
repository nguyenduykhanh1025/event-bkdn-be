package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
}
