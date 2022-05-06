package com.onlinehotelreservations.mapper;

import com.onlinehotelreservations.DTOs.event.EventResponseDTO;
import com.onlinehotelreservations.DTOs.pagination.PaginationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PaginationMapper {
  public PaginationResponseDTO toPaginationResponseDTO(List<?> items, int metaCurrentPage, int metaTotal, int metaPerPage) {
    return PaginationResponseDTO.builder()
            .items(items)
            .metaPerPage(metaPerPage)
            .metaTotal(metaTotal)
            .metaCurrentPage(metaCurrentPage).build();
  }
}
