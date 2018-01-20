package com.gederin.api.v1.service;

import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.mapper.CarModelMapper;
import com.gederin.api.v1.model.CarBrand;
import com.gederin.api.v1.model.CarModel;
import com.gederin.api.v1.repository.CarBrandRepository;
import com.gederin.api.v1.dto.CarBrandDto;
import com.gederin.api.v1.mapper.CarBrandMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBrandService {
    private final CarBrandMapper carBrandMapper;

    private final CarModelMapper carModelMapper;

    private final CarBrandRepository carBrandRepository;

    public List<CarBrandDto> getAllCarBrands() {
        return carBrandRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public CarBrandDto getCarBrandById(Long id) {
        return carBrandRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(RuntimeException::new);
    }

    public CarBrandDto createNewCarBrand(CarBrandDto carBrandDto) {
        CarBrand carBrand = carBrandMapper.mapToCarBrand(carBrandDto);

        return Optional.of(carBrandRepository.save(carBrand))
                .map(this::mapToDto)
                .orElseThrow(RuntimeException::new);
    }

    public CarBrandDto addCarModelToBrand(Long carBrandId, CarModelDto carModelDto) {
        return carBrandRepository.findById(carBrandId).map(carBrand -> {
            CarModel carModel = carModelMapper.mapToCarModel(carModelDto);

            carBrand.addCarModel(carModel);

            return Optional.of(carBrandRepository.save(carBrand))
                    .map(this::mapToDto)
                    .orElseThrow(RuntimeException::new);

        }).orElseThrow(RuntimeException::new);
    }

    public void deleteCarBrandById(Long id) {
        carBrandRepository.deleteById(id);
    }

    private CarBrandDto mapToDto(CarBrand carBrand) {
        CarBrandDto carBrandDto = carBrandMapper.mapToCarBrandDto(carBrand);
        carBrandDto.setUri("api/v1/brand/" + carBrand.getId());

        return carBrandDto;
    }
}
