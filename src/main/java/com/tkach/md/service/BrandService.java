package com.tkach.md.service;

import com.tkach.md.dto.brand.BrandRequestDto;
import com.tkach.md.dto.brand.BrandResponseDto;
import com.tkach.md.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Brand create(BrandRequestDto dto);
    BrandResponseDto createAndReturnDto(BrandRequestDto dto);
    Optional<Brand> findByName(String name);
    void delete(Long id);
    Optional<Brand> findById(Long id);
    Brand getById(Long id);
    List<BrandResponseDto> findAllDto();
    List<Brand> findAll();
}
