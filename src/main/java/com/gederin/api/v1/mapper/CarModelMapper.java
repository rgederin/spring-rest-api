package com.gederin.api.v1.mapper;

import com.gederin.api.v1.model.CarModel;
import com.gederin.api.v1.dto.CarModelDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarModelMapper {

    //CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    CarModelDto carModelToCarModelDto(CarModel carModel);

    CarModel carModelDtoToCarModel(CarModelDto carModelDto);
}
