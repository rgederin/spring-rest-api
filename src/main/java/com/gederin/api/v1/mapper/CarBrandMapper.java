package com.gederin.api.v1.mapper;

import com.gederin.api.v1.model.CarBrand;
import com.gederin.api.v1.dto.CarBrandDto;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CarBrandMapper {
    //CarBrandMapper INSTANCE = Mappers.getMapper(CarBrandMapper.class);

    CarBrandDto carBrandToCarBrandDto(CarBrand carBrand);

    CarBrand carBrandDtoToCarBrand(CarBrandDto carBrandDto);

}
