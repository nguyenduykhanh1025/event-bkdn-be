package com.onlinehotelreservations.controller;

import com.onlinehotelreservations.DTOs.authentication.AuthTokenDTO;
import com.onlinehotelreservations.DTOs.authentication.LoginDTO;
import com.onlinehotelreservations.DTOs.event.EventNeedUpdateDTO;
import com.onlinehotelreservations.DTOs.event.EventResponseDTO;
import com.onlinehotelreservations.DTOs.event.NewEventDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationResponseDTO;
import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.exceptions.authentication.PasswordLoginFailedException;
import com.onlinehotelreservations.exceptions.event.CreateEventFailed;
import com.onlinehotelreservations.exceptions.event.EventDoesNotExist;
import com.onlinehotelreservations.exceptions.event.UpdateEventFailed;
import com.onlinehotelreservations.mapper.EventMapper;
import com.onlinehotelreservations.mapper.PaginationMapper;
import com.onlinehotelreservations.services.EventService;
import com.onlinehotelreservations.shared.helper.DatetimeHelper;
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
        Page<EventEntity> eventEntitiesPage = this.eventService.paginateEventIncoming(page, limit);
        List<EventResponseDTO> eventResponseDTOs = this.eventMapper.toEventResponseDTOs(
                eventEntitiesPage.get().collect(Collectors.toList())
        );
        return this.paginationMapper.toPaginationResponseDTO(eventResponseDTOs, page, eventEntitiesPage.getTotalElements(), limit);
    }

    @GetMapping("/paginate-events-happening")
    public PaginationResponseDTO paginateEventsHappening(@RequestParam int page, @RequestParam int limit) {
        Page<EventEntity> eventEntitiesPage = this.eventService.paginateEventsHappening(page, limit);
        List<EventResponseDTO> eventResponseDTOs = this.eventMapper.toEventResponseDTOs(
                eventEntitiesPage.get().collect(Collectors.toList())
        );
        return this.paginationMapper.toPaginationResponseDTO(eventResponseDTOs, page, eventEntitiesPage.getTotalElements(), limit);
    }

    @GetMapping("/paginate-events-over")
    public PaginationResponseDTO paginateEventsOver(@RequestParam int page, @RequestParam int limit) {
        Page<EventEntity> eventEntitiesPage = this.eventService.paginateEventsOver(page, limit);
        List<EventResponseDTO> eventResponseDTOs = this.eventMapper.toEventResponseDTOs(
                eventEntitiesPage.get().collect(Collectors.toList())
        );
        return this.paginationMapper.toPaginationResponseDTO(eventResponseDTOs, page, eventEntitiesPage.getTotalElements(), limit);
    }

    @PostMapping("/create")
    public EventResponseDTO create(@RequestBody NewEventDTO newEventDTO) {
        EventEntity eventEntityNeedCreate = this.eventMapper.toEventEntity(newEventDTO);
        try {
            eventEntityNeedCreate = this.eventService.create(eventEntityNeedCreate);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new CreateEventFailed();
        }
        return this.eventMapper.toEventResponseDTO(eventEntityNeedCreate);
    }

    @PutMapping("/update")
    public EventResponseDTO update(@RequestBody EventNeedUpdateDTO eventNeedUpdateDTO) {
        EventEntity eventEntityNeedUpdate = this.eventMapper.toEventEntity(eventNeedUpdateDTO);
        if (this.eventService.findById(eventEntityNeedUpdate.getId()) == null) {
            throw new EventDoesNotExist();
        }

        try {
            eventEntityNeedUpdate = this.eventService.update(eventEntityNeedUpdate);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new UpdateEventFailed();
        }
        return this.eventMapper.toEventResponseDTO(eventEntityNeedUpdate);
    }

    @PatchMapping("/disable/{id}")
    public EventResponseDTO update(@PathVariable("id") int id) {
        EventEntity eventEntityFromDB = this.eventService.findById(id);
        if (eventEntityFromDB == null) {
            throw new EventDoesNotExist();
        }
        eventEntityFromDB.setIsActive(false);

        try {
            return this.eventMapper.toEventResponseDTO(this.eventService.update(eventEntityFromDB));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new UpdateEventFailed();
        }
    }
}
