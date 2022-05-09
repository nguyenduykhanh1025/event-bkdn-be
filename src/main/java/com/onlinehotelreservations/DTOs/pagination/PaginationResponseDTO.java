package com.onlinehotelreservations.DTOs.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponseDTO {
  private List<?> items;
  private int metaCurrentPage;
  private Long metaTotal;
  private int metaPerPage;
}
