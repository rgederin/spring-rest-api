package com.gederin.api.v1.controller;

import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.dto.CarBrandDto;
import com.gederin.api.v1.service.CarBrandService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarBrandController {

    private final CarBrandService carBrandService;

    @GetMapping("/brands")
    @ResponseStatus(HttpStatus.OK)
    public List<CarBrandDto> getAllCarBrandsWithCarModels() {
        return carBrandService.getAllCarBrands();
    }

    @GetMapping("/brand/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarBrandDto getCarBrandById(@PathVariable Long id) {
        return carBrandService.getCarBrandById(id);
    }

    @PostMapping("/brand")
    @ResponseStatus(HttpStatus.CREATED)
    public CarBrandDto createNewCarBrand(@RequestBody CarBrandDto carBrandDto) {
        return carBrandService.createNewCarBrand(carBrandDto);
    }

    @PatchMapping ("brand/{id}/add/model")
    public CarBrandDto addCarModelToBrand(@PathVariable Long id, @RequestBody CarModelDto carModelDto) {
        return carBrandService.addCarModelToBrand(id, carModelDto);
    }
}
