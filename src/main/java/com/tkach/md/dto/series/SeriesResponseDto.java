package com.tkach.md.dto.series;

import com.tkach.md.dto.brand.BrandResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesResponseDto {
    Long id;
    BrandResponseDto brand;
    String name;
}
