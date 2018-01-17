package com.gederin.api.v1.repository;

import com.gederin.api.v1.model.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findByCarBrandId(Long id);

    List<CarModel> findByCarBrandName(String carBrandName);
}
