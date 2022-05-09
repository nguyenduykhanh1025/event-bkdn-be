package com.onlinehotelreservations.mapper;

import com.onlinehotelreservations.DTOs.event.EventResponseDTO;
import com.onlinehotelreservations.DTOs.news.NewsResponseDTO;
import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.entities.NewsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class NewsMapper {
    public abstract NewsResponseDTO toNewsResponseDTO(NewsEntity newsEntity);

    public List<NewsResponseDTO> toNewsResponseDTOs(List<NewsEntity> newsEntities) {
        return newsEntities.parallelStream().map(this::toNewsResponseDTO).collect(Collectors.toList());
    }
}
