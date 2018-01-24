package com.gederin.api.v1.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gederin.api.v1.TestHelper;
import com.gederin.api.v1.dto.CarModelDto;
import com.gederin.api.v1.service.CarModelService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CarModelControllerTest {

    @Mock
    private CarModelService carModelService;

    @InjectMocks
    private CarModelController carModelController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carModelController)
                .build();
    }

    @Test
    public void shouldReturnOkResponseForModelsEndpoint() throws Exception {
        when(carModelService.getCarModelsByCarBrandId(1L)).thenReturn(Arrays.asList(new CarModelDto()));

        mockMvc.perform(get("/api/v1/brand/1/cars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkResponseForModellByIdEndpoint() throws Exception {
        when(carModelService.getCarModelsByCarBrandName(any())).thenReturn(Arrays.asList(new CarModelDto()));

        mockMvc.perform(get("/api/v1/brand/name/honda/cars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkResponseUpdateModelByIdEndpoint() throws Exception {
        when(carModelService.updateCarModelById(anyLong(), any(CarModelDto.class))).thenReturn(new CarModelDto());

        mockMvc.perform(put("/api/v1/car/1")
                .content(asJsonString(TestHelper.buildCarModelDtoTestObject()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkResponseForDeleteModelByIdEndpoint() throws Exception {
        mockMvc.perform(delete("/api/v1/brand/1/car")
                .contentType(MediaType.APPLICATION_JSON));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}