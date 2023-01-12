package com.tkach.md.service;

import com.tkach.md.dto.series.SeriesRequestDto;
import com.tkach.md.dto.series.SeriesResponseDto;
import com.tkach.md.model.Brand;
import com.tkach.md.model.DeviceSeries;

import java.util.List;
import java.util.Optional;

public interface DeviceSeriesService {
    DeviceSeries create(SeriesRequestDto dto);

    SeriesResponseDto createAndReturnDto(SeriesRequestDto dto);

    List<SeriesResponseDto> findAllByBrandId(Long brandId);

    List<SeriesResponseDto> findAll();

    Optional<DeviceSeries> findByNameAndBrand(String name, Brand brand);
}
