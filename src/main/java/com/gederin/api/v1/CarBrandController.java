package com.gederin.api.v1;

import com.gederin.model.CarBrand;
import com.gederin.service.CarModelService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarBrandController {

    private final CarModelService carModelService;

    @GetMapping("/brands")
    @ResponseStatus(HttpStatus.OK)
    public List<CarBrand> getAllCarBrandsWithCarModels(){
        return carModelService.getAllCarModels();
    }
}
