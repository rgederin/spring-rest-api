package com.gederin.api.v1.model;


import org.junit.Test;

import static com.gederin.api.v1.TestHelper.buildCarBrandTestObject;
import static com.gederin.api.v1.TestHelper.buildCarModelTestObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarBrandTest {

    @Test
    public void shouldAddModelToBrand() {
        CarModel carModel = buildCarModelTestObject();
        CarBrand carBrand = buildCarBrandTestObject();

        carBrand.addCarModel(carModel);

        assertThat(carBrand.getCarModels(), notNullValue());
        assertThat(carBrand.getCarModels().size(), is(1));
    }
}