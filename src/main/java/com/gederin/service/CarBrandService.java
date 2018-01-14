package com.gederin.service;

import com.gederin.dto.CarBrandDto;
import com.gederin.mapper.CarBrandMapper;
import com.gederin.model.CarBrand;
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
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public CarBrandDto getCarBrandById(Long id) {
        return carBrandRepository.findById(id)
                .map(carBrandMapper::carBrandToCarBrandDto)
                .orElseThrow(RuntimeException::new);
    }

    private CarBrandDto mapToDto(CarBrand carBrand) {
        CarBrandDto carBrandDto = carBrandMapper.carBrandToCarBrandDto(carBrand);
        carBrandDto.setUri("api/v1/brand/" + carBrand.getId());

        return carBrandDto;
    }
}
