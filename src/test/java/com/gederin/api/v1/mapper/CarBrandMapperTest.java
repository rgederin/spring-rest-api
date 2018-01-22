package com.gederin.api.v1.mapper;

import com.gederin.api.v1.dto.CarBrandDto;
import com.gederin.api.v1.model.CarBrand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarBrandMapperTest {

    private static final String NAME = "Audi";
    private static final String COUNTRY = "Germany";
    private static final String DESCRIPTION = "description";

    @Autowired
    private CarBrandMapper carBrandMapper;

    @Test
    public void shouldMapToDto() {
        CarBrandDto carBrandDto = carBrandMapper.mapToCarBrandDto(buildCarBrandTestObject());

        assertThat(carBrandDto, notNullValue());
        assertThat(carBrandDto.getName(), is(NAME));
        assertThat(carBrandDto.getCountry(), is(COUNTRY));
        assertThat(carBrandDto.getDescription(), is(DESCRIPTION));
    }

    @Test
    public void shouldMapToModel() {
        CarBrand carBrand = carBrandMapper.mapToCarBrand(buildCarBrandDtoTestObject());

        assertThat(carBrand, notNullValue());
        assertThat(carBrand.getName(), is(NAME));
        assertThat(carBrand.getCountry(), is(COUNTRY));
        assertThat(carBrand.getDescription(), is(DESCRIPTION));
    }

    private CarBrand buildCarBrandTestObject() {
        CarBrand carBrand = new CarBrand();

        carBrand.setName(NAME);
        carBrand.setCountry(COUNTRY);
        carBrand.setDescription(DESCRIPTION);

        return carBrand;
    }

    private CarBrandDto buildCarBrandDtoTestObject() {
        CarBrandDto carBrandDto = new CarBrandDto();

        carBrandDto.setName(NAME);
        carBrandDto.setCountry(COUNTRY);
        carBrandDto.setDescription(DESCRIPTION);

        return carBrandDto;
    }
}