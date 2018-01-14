package com.gederin.mapper;

import com.gederin.dto.CarBrandDto;
import com.gederin.model.CarBrand;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CarBrandMapper {
    //CarBrandMapper INSTANCE = Mappers.getMapper(CarBrandMapper.class);

    CarBrandDto carBrandToCarBrandDto(CarBrand carBrand);

    CarBrand carBrandDtoToCarBrand(CarBrandDto carBrandDto);

}
