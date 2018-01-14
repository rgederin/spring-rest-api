package com.gederin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModelDto {
    private String name;
    private String type;

    @JsonIgnore
    private CarBrandDto carBrandDto;
}
