package com.onlinehotelreservations.controller;

import com.onlinehotelreservations.DTOs.event.EventResponseDTO;
import com.onlinehotelreservations.DTOs.news.NewsResponseDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationResponseDTO;
import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.entities.NewsEntity;
import com.onlinehotelreservations.mapper.EventMapper;
import com.onlinehotelreservations.mapper.NewsMapper;
import com.onlinehotelreservations.mapper.PaginationMapper;
import com.onlinehotelreservations.services.EventService;
import com.onlinehotelreservations.services.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;
    private final NewsMapper newsMapper;
    private final PaginationMapper paginationMapper;

    @GetMapping("/paginate-events-incoming")
    public PaginationResponseDTO paginateEventsIncoming(@RequestParam int page, @RequestParam int limit) {
        Page<NewsEntity> newsEntitiesPage = this.newsService.paginate(page, limit);

        List<NewsResponseDTO> newsResponseDTOS = this.newsMapper.toNewsResponseDTOs(
                newsEntitiesPage.get().collect(Collectors.toList())
        );
        return this.paginationMapper.toPaginationResponseDTO(newsResponseDTOS, page, newsEntitiesPage.getTotalElements(), limit);
    }
}
