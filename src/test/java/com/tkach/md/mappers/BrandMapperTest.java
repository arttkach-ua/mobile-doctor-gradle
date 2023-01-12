package com.tkach.md.mappers;

import com.tkach.md.dto.brand.BrandRequestDto;
import com.tkach.md.model.Brand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BrandMapperTest {

    @Test
    void toBrand() {
        //given
        BrandRequestDto dto = BrandRequestDto.builder()
                .name("test name")
                .build();
        //when
        Brand brand = BrandMapper.INSTANCE.toBrand(dto);

        //then
        assertEquals("test name", brand.getName());
        assertNull(brand.getId());
    }
}