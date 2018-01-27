package com.gederin.api.v1.integration;

import com.gederin.api.v1.bootstrap.Bootstrap;
import com.gederin.api.v1.dto.CarBrandDto;
import com.gederin.api.v1.mapper.CarBrandMapper;
import com.gederin.api.v1.mapper.CarModelMapper;
import com.gederin.api.v1.repository.CarBrandRepository;
import com.gederin.api.v1.service.CarBrandService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarBrandServiceIntegrationTest {

    private final CarBrandMapper carBrandMapper = Mappers.getMapper(CarBrandMapper.class);

    private final CarModelMapper carModelMapper = Mappers.getMapper(CarModelMapper.class);

    @Autowired
    private CarBrandRepository carBrandRepository;

    private CarBrandService carBrandService;

    @Before
    public void setUp() throws Exception {
        //setup data for testing
        Bootstrap bootstrap = new Bootstrap(carBrandRepository);
        bootstrap.run(); //load data

        carBrandService = new CarBrandService(carBrandMapper, carModelMapper, carBrandRepository);
    }

    @Test
    public void shouldGetListOfCarBrandsFromDb() {
        List<CarBrandDto> carBrandDtos = carBrandService.getAllCarBrands();

        assertThat(carBrandDtos, notNullValue());
        assertThat(carBrandDtos.size(), is(2));
    }

    @Test
    public void shouldGetCarBrandByIdFromDb() {
        CarBrandDto carBrandDto = carBrandService.getCarBrandById(getCarBrandId());

        assertThat(carBrandDto, notNullValue());
        assertThat(carBrandDto.getName(), is("Honda"));
        assertThat(carBrandDto.getCountry(), is("Japan"));
    }

    private Long getCarBrandId() {
        return carBrandRepository.findAll().get(0).getId();
    }
}
