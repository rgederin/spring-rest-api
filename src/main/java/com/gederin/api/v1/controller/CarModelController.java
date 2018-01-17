package com.gederin.api.v1.controller;

import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.service.CarModelService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarModelController {
    private final CarModelService carModelService;

    @GetMapping("/brand/{id}/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<CarModelDto> getCarModelsByCarBrandId(@PathVariable Long id) {
        return carModelService.getCarModelsByCarBrandId(id);
    }

    @GetMapping("/brand/name/{name}/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<CarModelDto> getCarModelsByCarBrandName(@PathVariable String name) {
        return carModelService.getCarModelsByCarBrandName(name);
    }
}
