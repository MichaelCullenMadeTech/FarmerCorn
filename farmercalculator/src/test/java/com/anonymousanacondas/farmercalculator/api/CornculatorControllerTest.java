package com.anonymousanacondas.farmercalculator.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import com.anonymousanacondas.farmercalculator.dto.CornBags;
import com.anonymousanacondas.farmercalculator.service.CornculatorService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CornculatorController.class)
public class CornculatorControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    private final String cornculatorApi = "/api/v1/cornculate";
    private CornBags cornBagsDto;
    String cornBagsJson;


    @MockBean
    private CornculatorService cornculatorService;

    public CornculatorControllerTest() {
        cornBagsDto = new CornBags();
    }
    
    @Test
    public void cornculate() throws Exception {  
        // arrange
        cornBagsDto.setAmount(10);
        cornBagsJson = new ObjectMapper().writeValueAsString(cornBagsDto);
        Mockito
            .when(cornculatorService.calculateTripPrice(anyInt()))
            .thenReturn(0.0);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
            .content(cornBagsJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        // assert
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void whenCornculateWithoutBagsOfCorn_thenNoBagsOfCornValidationMessage() throws Exception {
        // arrange
        cornBagsDto.setAmount(0);
        cornBagsJson = new ObjectMapper().writeValueAsString(cornBagsDto);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
            .content(cornBagsJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        MockHttpServletResponse response = result.getResponse();

        // assert
        assertEquals(400, response.getStatus());
        assertThat(response.getContentAsString(), containsString("Needs bags of corn!"));
    }
}
