package com.tkach.md.mappers;

import com.tkach.md.dto.series.SeriesRequestDto;
import com.tkach.md.dto.series.SeriesResponseDto;
import com.tkach.md.model.DeviceSeries;
import com.tkach.md.service.BrandService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {BrandMapper.class, BrandService.class})
public interface DeviceSeriesMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "brandId", target = "brand")
    DeviceSeries toDeviceSeries(SeriesRequestDto dto);

    SeriesResponseDto toSeriesResponseDto(DeviceSeries deviceSeries);
}
