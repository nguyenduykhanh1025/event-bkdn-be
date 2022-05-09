package com.onlinehotelreservations.services;

import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.repositories.EventRepository;
import com.onlinehotelreservations.repositories.UserRepository;
import com.onlinehotelreservations.shared.enums.EventStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventRepository eventRepository;

    public EventEntity getByTitle(String title) {
        return this.eventRepository.findByTitle(title).orElse(null);
    }

    public Page<EventEntity> paginateEventIncoming(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
        return this.eventRepository.findByStatusAndIsActive(EventStatus.INCOMING, true, pageableRequest);
    }

    public Page<EventEntity> paginateEventsHappening(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
        return this.eventRepository.findByStatusAndIsActive(EventStatus.HAPPENING, true, pageableRequest);
    }

    public Page<EventEntity> paginateEventsOver(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
        return this.eventRepository.findByStatusAndIsActive(EventStatus.OVER, true, pageableRequest);
    }

    public EventEntity create(EventEntity eventEntity) {
        eventEntity.setStatus(EventStatus.INCOMING);
        eventEntity.setCreatedBy("ADMIN");

        eventEntity = this.eventRepository.save(eventEntity);
        return eventEntity;
    }

    public EventEntity update(EventEntity eventEntity) {
        return this.eventRepository.save(eventEntity);
    }

    public EventEntity findById(int id) {
        return this.eventRepository.findById(id).orElse(null);
    }
}
