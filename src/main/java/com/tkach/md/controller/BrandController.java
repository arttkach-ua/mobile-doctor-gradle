package com.tkach.md.controller;

import com.tkach.md.dto.brand.BrandRequestDto;
import com.tkach.md.dto.brand.BrandResponseDto;
import com.tkach.md.service.BrandService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponseDto createBrand(@Valid @RequestBody BrandRequestDto dto){
        return brandService.createAndReturnDto(dto);
    }
    @GetMapping
    public List<BrandResponseDto> getBrands(){
        return brandService.findAllDto();
    }
    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable @NotNull Long id){
        brandService.delete(id);
    }
}
