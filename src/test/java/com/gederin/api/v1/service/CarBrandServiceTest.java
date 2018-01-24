package com.gederin.api.v1.service;

import com.gederin.api.v1.dto.CarBrandDto;
import com.gederin.api.v1.mapper.CarBrandMapper;
import com.gederin.api.v1.mapper.CarModelMapper;
import com.gederin.api.v1.model.CarBrand;
import com.gederin.api.v1.repository.CarBrandRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.gederin.api.v1.TestHelper.COUNTRY;
import static com.gederin.api.v1.TestHelper.DESCRIPTION;
import static com.gederin.api.v1.TestHelper.NAME;
import static com.gederin.api.v1.TestHelper.buildCarBrandDtoTestObject;
import static com.gederin.api.v1.TestHelper.buildCarBrandListTestObject;
import static com.gederin.api.v1.TestHelper.buildCarBrandTestObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarBrandServiceTest {

    private final CarBrandMapper carBrandMapper = Mappers.getMapper(CarBrandMapper.class);

    private final CarModelMapper carModelMapper = Mappers.getMapper(CarModelMapper.class);

    @Mock
    private CarBrandRepository carBrandRepository;

    private CarBrandService carBrandService;

    @Before
    public void setUp() {
        carBrandService = new CarBrandService(carBrandMapper, carModelMapper, carBrandRepository);
    }

    @Test
    public void shouldReturnListOfCarBrandsDto() {
        when(carBrandRepository.findAll()).thenReturn(buildCarBrandListTestObject());

        assertThat(carBrandService.getAllCarBrands(), notNullValue());
        assertThat(carBrandService.getAllCarBrands().size(), is(2));
    }

    @Test
    public void shouldReturnCarBrandDtoById() {
        when(carBrandRepository.findById(1L)).thenReturn(Optional.of(buildCarBrandTestObject()));

        CarBrandDto carBrandDto = carBrandService.getCarBrandById(1L);

        assertCarBrandDto(carBrandDto);
    }

    @Test
    public void shouldSaveCarBrand() {
        when(carBrandRepository.save(any(CarBrand.class))).thenReturn(buildCarBrandTestObject());

        CarBrandDto carBrandDto = carBrandService.createNewCarBrand(buildCarBrandDtoTestObject());

        assertCarBrandDto(carBrandDto);
    }

    @Test
    public void shouldDeleteCarBrandById() {
        carBrandRepository.deleteById(1L);

        verify(carBrandRepository, times(1)).deleteById(1L);
    }

    private void assertCarBrandDto(CarBrandDto carBrandDto) {
        assertThat(carBrandDto, notNullValue());
        assertThat(carBrandDto.getName(), is(NAME));
        assertThat(carBrandDto.getCountry(), is(COUNTRY));
        assertThat(carBrandDto.getDescription(), is(DESCRIPTION));
    }
}