package com.tkach.md.service.impl;

import com.tkach.md.dto.series.SeriesRequestDto;
import com.tkach.md.dto.series.SeriesResponseDto;
import com.tkach.md.mappers.DeviceSeriesMapper;
import com.tkach.md.model.Brand;
import com.tkach.md.model.DeviceSeries;
import com.tkach.md.repository.BrandRepository;
import com.tkach.md.repository.DeviceSeriesRepository;
import com.tkach.md.service.BrandService;
import com.tkach.md.service.DeviceSeriesService;
import com.tkach.md.service.validation.DeviceValidationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class DeviceSeriesServiceImpl implements DeviceSeriesService {
    @Autowired
    private BrandService brandService;
    @Autowired
    private DeviceSeriesRepository deviceSeriesRepository;
    @Autowired
    private DeviceSeriesMapper deviceSeriesMapper;
    @Autowired
    private DeviceValidationService deviceValidationService;

    @Override
    public DeviceSeries create(SeriesRequestDto dto) {
        DeviceSeries deviceSeries = deviceSeriesMapper.toDeviceSeries(dto);
        deviceValidationService.validate(deviceSeries);
        return deviceSeriesRepository.save(deviceSeries);
    }

    @Override
    public SeriesResponseDto createAndReturnDto(SeriesRequestDto dto) {
        DeviceSeries deviceSeries = create(dto);
        return deviceSeriesMapper.toSeriesResponseDto(deviceSeries);
    }

    @Override
    public List<SeriesResponseDto> findAllByBrandId(Long brandId) {
        log.debug("Call find all series by brandId, id is {}", brandId);

        Brand brand = brandService.getById(brandId);
        Example<DeviceSeries> example = Example.of(new DeviceSeries(null,null,brand));

        return deviceSeriesRepository.findAll(example)
                .stream()
                .map(deviceSeriesMapper::toSeriesResponseDto)
                .toList();
    }

    @Override
    public List<SeriesResponseDto> findAll() {
        log.debug("Call find all series");
        return deviceSeriesRepository.findAll()
                .stream()
                .map(deviceSeriesMapper::toSeriesResponseDto)
                .toList();
    }

    @Override
    public Optional<DeviceSeries> findByNameAndBrand(String name, Brand brand) {
        log.debug("Call find series by name and brand, brand is {}, name is {}", brand, name);

        Example<DeviceSeries> example = Example.of(new DeviceSeries(null,name,brand));
        return deviceSeriesRepository.findOne(example);
    }
}
