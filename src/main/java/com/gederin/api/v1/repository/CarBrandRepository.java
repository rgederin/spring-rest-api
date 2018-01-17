package com.gederin.api.v1.repository;

import com.gederin.api.v1.model.CarBrand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long>{
}
