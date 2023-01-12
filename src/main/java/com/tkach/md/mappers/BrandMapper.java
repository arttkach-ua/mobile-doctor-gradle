package com.tkach.md.mappers;

import com.tkach.md.dto.brand.BrandRequestDto;
import com.tkach.md.dto.brand.BrandResponseDto;
import com.tkach.md.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper( BrandMapper.class );
    @Mapping(target = "id", ignore = true)
    Brand toBrand(BrandRequestDto dto);
    BrandResponseDto toBrandResponseDto(Brand brand);
}
