package com.onlinehotelreservations.controller;

import com.onlinehotelreservations.DTOs.authentication.AuthTokenDTO;
import com.onlinehotelreservations.DTOs.authentication.LoginDTO;
import com.onlinehotelreservations.DTOs.event.EventResponseDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationResponseDTO;
import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.exceptions.authentication.PasswordLoginFailedException;
import com.onlinehotelreservations.mapper.EventMapper;
import com.onlinehotelreservations.mapper.PaginationMapper;
import com.onlinehotelreservations.services.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {

  private final EventService eventService;
  private final EventMapper eventMapper;
  private final PaginationMapper paginationMapper;

  @GetMapping("/paginate-events-incoming")
  public PaginationResponseDTO paginateEventsIncoming(@RequestParam int page, @RequestParam int limit) {
    Page<EventEntity> eventEntitiesPage = this.eventService.paginate(page, limit);
    eventEntitiesPage.get().forEach(item -> {
      System.out.println(item.getStatus());
    });
    List<EventResponseDTO> eventResponseDTOs = this.eventMapper.toEventResponseDTOs(
            eventEntitiesPage.get().collect(Collectors.toList())
    );
    return this.paginationMapper.toPaginationResponseDTO(eventResponseDTOs, page, eventEntitiesPage.getTotalPages(), limit);
  }
}
