package com.onlinehotelreservations.services;

import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.entities.NewsEntity;
import com.onlinehotelreservations.repositories.NewsRepository;
import com.onlinehotelreservations.shared.enums.EventStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {
    private final NewsRepository newsRepository;

    public Page<NewsEntity> paginate(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
        return this.newsRepository.findByIsActive(true, pageableRequest);
    }

    public NewsEntity getByTitle(String title) {
        return this.newsRepository.findByTitle(title).orElse(null);
    }

    public NewsEntity create(NewsEntity newsEntity) {
        newsEntity.setCreatedBy("ADMIN");

        newsEntity = this.newsRepository.save(newsEntity);
        return newsEntity;
    }
}
