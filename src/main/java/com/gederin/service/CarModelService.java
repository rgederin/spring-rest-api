package com.gederin.service;

import com.gederin.model.CarBrand;
import com.gederin.repository.CarBrandRepository;
import com.gederin.repository.CarModelRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarModelService {

    private final CarModelRepository carModelRepository;
    private final CarBrandRepository carBrandRepository;

    public List<CarBrand> getAllCarModels(){
        return carBrandRepository.findAll();
    }
}
