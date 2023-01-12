package com.tkach.md.controller;

import com.tkach.md.dto.series.SeriesRequestDto;
import com.tkach.md.dto.series.SeriesResponseDto;
import com.tkach.md.service.DeviceSeriesService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@CrossOrigin
@RequestMapping
public class SeriesController {
    @Autowired
    private DeviceSeriesService deviceSeriesService;

    @PostMapping("/series")
    public SeriesResponseDto createSeries(@Valid @RequestBody SeriesRequestDto dto){

        return deviceSeriesService.createAndReturnDto(dto);
    }

    @GetMapping("/series")
    public List<SeriesResponseDto> getAll(){
        return deviceSeriesService.findAll();
    }
    @GetMapping("brands/{brandId}/series")
    public List<SeriesResponseDto> getSeriesByBrandId(@PathVariable("brandId") Long brandId){
        return deviceSeriesService.findAllByBrandId(brandId);
    }


}
