package com.tkach.md.service.impl;

import com.tkach.md.dto.brand.BrandRequestDto;
import com.tkach.md.dto.brand.BrandResponseDto;
import com.tkach.md.mappers.BrandMapper;
import com.tkach.md.model.Brand;
import com.tkach.md.repository.BrandRepository;
import com.tkach.md.service.BrandService;
import com.tkach.md.service.validation.BrandValidationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.tkach.md.util.ErrorMessages.BRAND_NOT_FOUND_BY_ID;
import static java.lang.String.format;

@Service
@Log4j2
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandValidationService brandValidationService;
    private BrandMapper brandMapper = BrandMapper.INSTANCE;

    @Override
    public Brand create(BrandRequestDto dto) {
        log.debug("Brand create call. dto is {}", dto);
        Brand brand = brandMapper.toBrand(dto);
        brandValidationService.validate(brand);
        return brandRepository.save(brand);
    }

    @Override
    public BrandResponseDto createAndReturnDto(BrandRequestDto dto) {
        log.debug("Brand create and return dto call. dto is {}", dto);
        return brandMapper.toBrandResponseDto(create(dto));
    }

    @Override
    public Optional<Brand> findByName(String name) {
        log.debug("Brand find by name call. name is {}", name);

        Example<Brand> example = Example.of(new Brand(null,name));
        return brandRepository.findOne(example);
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete brand call. id is {}", id);
        Brand brand = getById(id);
        brandRepository.delete(brand);
    }

    @Override
    public Optional<Brand> findById(Long id) {
        log.debug("Find brand by id call. Id is {}", id);
        return brandRepository.findById(id);
    }

    @Override
    public Brand getById(Long id) {
        log.debug("Get brand by id call. Id is {}", id);
        return findById(id)
                .orElseThrow(()->new EntityNotFoundException(format(BRAND_NOT_FOUND_BY_ID, id)));
    }

    @Override
    public List<BrandResponseDto> findAllDto() {
        log.debug("Find all brands(Response dto) call");
        return findAll().stream()
                .map(brand ->brandMapper.toBrandResponseDto(brand))
                .toList();
    }

    @Override
    public List<Brand> findAll() {
        log.debug("Find all brands call");
        return brandRepository.findAll();
    }
}
