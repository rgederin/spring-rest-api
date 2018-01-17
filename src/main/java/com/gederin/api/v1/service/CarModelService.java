package com.gederin.api.v1.service;

import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.mapper.CarModelMapper;
import com.gederin.api.v1.repository.CarModelRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CarModelService {
    private final CarModelRepository carModelRepository;

    private final CarModelMapper carModelMapper;

    public List<CarModelDto> getCarModelsByCarBrandId(Long id) {
        return carModelRepository.findByCarBrandId(id)
                .stream()
                .map(carModelMapper::carModelToCarModelDto)
                .collect(toList());
    }

    public List<CarModelDto> getCarModelsByCarBrandName(String name) {
        return carModelRepository.findByCarBrandName(name)
                .stream()
                .map(carModelMapper::carModelToCarModelDto)
                .collect(toList());
    }
}
