package com.onlinehotelreservations.DTOs.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationDTO {
  @NotNull
  private int limit;

  @NotNull
  private int page;

  private String sortColumn;

  private String sortType;

  private String filterColumn;

  private String filterData;

  private  String searchData;
}
