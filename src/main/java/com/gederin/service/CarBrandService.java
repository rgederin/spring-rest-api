package com.gederin.service;

import com.gederin.dto.CarBrandDto;
import com.gederin.mapper.CarBrandMapper;
import com.gederin.repository.CarBrandRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBrandService {
    private final CarBrandMapper carBrandMapper;
    private final CarBrandRepository carBrandRepository;

    public List<CarBrandDto> getAllCarBrands() {
        return carBrandRepository.findAll()
                .stream()
                .map(carBrandMapper::carBrandToCarBrandDto)
                .collect(Collectors.toList());
    }
}
