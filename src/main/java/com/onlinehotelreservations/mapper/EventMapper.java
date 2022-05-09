package com.onlinehotelreservations.mapper;

import com.onlinehotelreservations.DTOs.event.EventNeedUpdateDTO;
import com.onlinehotelreservations.DTOs.event.EventResponseDTO;
import com.onlinehotelreservations.DTOs.event.NewEventDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationResponseDTO;
import com.onlinehotelreservations.entities.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EventMapper {

  @Mapping(source = "status", target = "status")
  public abstract EventResponseDTO toEventResponseDTO(EventEntity eventEntity);

  public abstract EventEntity toEventEntity(NewEventDTO newEventDTO);

  public abstract EventEntity toEventEntity(EventNeedUpdateDTO eventNeedUpdateDTO);

  public List<EventResponseDTO> toEventResponseDTOs(List<EventEntity> eventEntities) {
    return eventEntities.parallelStream().map(this::toEventResponseDTO).collect(Collectors.toList());
  }
}
