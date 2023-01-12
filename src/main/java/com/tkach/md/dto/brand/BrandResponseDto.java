package com.tkach.md.dto.brand;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandResponseDto {
    private Long id;
    private String name;
}
