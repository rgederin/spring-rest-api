package com.gederin.api.v1.controller;


import com.gederin.api.v1.TestHelper;
import com.gederin.api.v1.service.CarBrandService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CarBrandControllerTest {

    @Mock
    private CarBrandService carBrandService;

    @InjectMocks
    private CarBrandController carBrandController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(carBrandController)
                .build();
    }

    @Test
    public void shouldReturnOkResponseForBrandsEndpoint() throws Exception {
        when(carBrandService.getAllCarBrands()).thenReturn(TestHelper.buildCarBrandListDtoTestObject());

        mockMvc.perform(get("/api/v1/brands")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkResponseForBrandByIdEndpoint() throws Exception {
        when(carBrandService.getCarBrandById(1L)).thenReturn(TestHelper.buildCarBrandDtoTestObject());

        mockMvc.perform(get("/api/v1/brand/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkResponseForDeleteBrandByIdEndpoint() throws Exception {
        mockMvc.perform(delete("/api/v1/brand/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}