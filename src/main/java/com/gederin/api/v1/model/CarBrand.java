package com.gederin.api.v1.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carBrand")
    private Set<CarModel> carModels = new HashSet<>();

    public CarBrand addCarModel(CarModel carModel) {
        carModel.setCarBrand(this);
        carModels.add(carModel);

        return this;
    }
}
