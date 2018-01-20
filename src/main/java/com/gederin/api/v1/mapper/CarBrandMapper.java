package com.gederin.api.v1.mapper;

import com.gederin.api.v1.model.CarBrand;
import com.gederin.api.v1.dto.CarBrandDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarBrandMapper {

    CarBrandDto mapToCarBrandDto(CarBrand carBrand);

    CarBrand mapToCarBrand(CarBrandDto carBrandDto);
}
