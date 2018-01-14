package com.gederin.api.v1;

import com.gederin.dto.CarBrandDto;
import com.gederin.service.CarBrandService;

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

    private final CarBrandService carBrandService;

    @GetMapping("/brands")
    @ResponseStatus(HttpStatus.OK)
    public List<CarBrandDto> getAllCarBrandsWithCarModels(){
        return carBrandService.getAllCarBrands();
    }
}
