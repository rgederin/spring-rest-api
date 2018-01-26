package com.gederin.api.v1.controller;

import com.gederin.api.v1.dto.CarBrandDto;
import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.service.CarBrandService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(description = "Car Brand Endpoint")
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarBrandController {

    private final CarBrandService carBrandService;

    @ApiOperation("This call will return list with car brands and car models which are belongs to them")
    @GetMapping("/brands")
    @ResponseStatus(HttpStatus.OK)
    public List<CarBrandDto> getAllCarBrandsWithCarModels() {
        return carBrandService.getAllCarBrands();
    }

    @ApiOperation("This call will return car brand and car models which are belongs to given brand")
    @GetMapping("/brand/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarBrandDto getCarBrandById(@PathVariable Long id) {
        return carBrandService.getCarBrandById(id);
    }

    @ApiOperation("This call will add new car brand and return it")
    @PostMapping("/brand")
    @ResponseStatus(HttpStatus.CREATED)
    public CarBrandDto createNewCarBrand(@RequestBody CarBrandDto carBrandDto) {
        return carBrandService.createNewCarBrand(carBrandDto);
    }

    @ApiOperation("This call will add new car brand and return it")
    @PatchMapping("brand/{id}/add/model")
    @ResponseStatus(HttpStatus.OK)
    public CarBrandDto addCarModelToBrand(@PathVariable Long id, @RequestBody CarModelDto carModelDto) {
        return carBrandService.addCarModelToBrand(id, carModelDto);
    }

    @ApiOperation("This call will delete given car brand")
    @DeleteMapping("/brand/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCarModelById(@PathVariable Long id) {
        carBrandService.deleteCarBrandById(id);
    }
}
