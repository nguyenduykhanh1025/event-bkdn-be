package com.onlinehotelreservations.services;

import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.repositories.EventRepository;
import com.onlinehotelreservations.repositories.UserRepository;
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

  public EventEntity create(EventEntity eventEntity) {
    return this.eventRepository.save(eventEntity);
  }

  public EventEntity getByTitle(String title) {
    return this.eventRepository.findByTitle(title).orElse(null);
  }

  public Page<EventEntity> paginate(int page, int limit) {
    List<EventEntity> eventEntities = new ArrayList<>();
    Pageable firstPageWithTwoElements = PageRequest.of(page, limit);

    return this.eventRepository.findAll(firstPageWithTwoElements);

//    pageEventEntities.get().forEach(eventEntity -> {
//      System.out.println(eventEntity.getTitle());
//    });
  }
}
