package com.gederin.api.v1.service;

import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.mapper.CarModelMapper;
import com.gederin.api.v1.repository.CarModelRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.gederin.api.v1.TestHelper.COUNTRY;
import static com.gederin.api.v1.TestHelper.NAME;
import static com.gederin.api.v1.TestHelper.buildCarModelDtoTestObject;
import static com.gederin.api.v1.TestHelper.buildCarModelListTestObject;
import static com.gederin.api.v1.TestHelper.buildCarModelTestObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarModelServiceTest {
    private final CarModelMapper carModelMapper = Mappers.getMapper(CarModelMapper.class);

    @Mock
    private CarModelRepository carModelRepository;

    private CarModelService carModelService;

    @Before
    public void setUp() {
        carModelService = new CarModelService(carModelRepository, carModelMapper);
    }

    @Test
    public void shouldReturnCarModelsListById() {
        when(carModelRepository.findByCarBrandId(anyLong())).thenReturn(buildCarModelListTestObject());

        assertThat(carModelService.getCarModelsByCarBrandId(1L), notNullValue());
        assertCarModelDto(carModelService.getCarModelsByCarBrandId(1L).get(0));
    }

    @Test
    public void shouldReturnCarModelsListByName() {
        when(carModelRepository.findByCarBrandName(anyString())).thenReturn(buildCarModelListTestObject());

        assertThat(carModelService.getCarModelsByCarBrandName("honda"), notNullValue());
        assertCarModelDto(carModelService.getCarModelsByCarBrandName("honda").get(0));
    }

    @Test
    public void shouldDeleteCarBrandById() {
        carModelRepository.deleteById(1L);

        verify(carModelRepository, times(1)).deleteById(1L);
    }

    @Test
    public void shouldUpdateCarModel() {
        when(carModelRepository.save(any())).thenReturn(buildCarModelTestObject());

        CarModelDto carModelDto = carModelService.updateCarModelById(1L, buildCarModelDtoTestObject());
        assertCarModelDto(carModelDto);

        verify(carModelRepository, times(1)).save(any());
    }

    private void assertCarModelDto(CarModelDto carModelDto) {
        assertThat(carModelDto, notNullValue());
        assertThat(carModelDto.getName(), is(NAME));
        assertThat(carModelDto.getType(), is(COUNTRY));
    }
}