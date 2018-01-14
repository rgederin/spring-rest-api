package com.gederin.mapper;

import com.gederin.dto.CarModelDto;
import com.gederin.model.CarModel;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarModelMapper {

    //CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    CarModelDto carModelToCarModelDto(CarModel carModel);

    CarModel carModelDtoToCarModel(CarModelDto carModelDto);
}
