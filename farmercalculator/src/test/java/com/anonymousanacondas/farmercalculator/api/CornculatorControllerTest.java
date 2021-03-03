package com.anonymousanacondas.farmercalculator.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import com.anonymousanacondas.farmercalculator.dto.FerrymanTrip;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CornculatorController.class)
public class CornculatorControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    private final String cornculatorApi = "/api/v1/cornculate";
    private FerrymanTrip ferrymansTripDto;
    String ferrymansTripJson;

    public CornculatorControllerTest() {
        ferrymansTripDto = new FerrymanTrip();
    }
    
    @Test
    public void cornculate() throws Exception {  
        // arrange
        ferrymansTripDto.setAmount(10);
        ferrymansTripDto.setPricePerTrip(.25);
        ferrymansTripJson = new ObjectMapper().writeValueAsString(ferrymansTripDto);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
            .content(ferrymansTripJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        // assert
        assertEquals(200, result.getResponse().getStatus());
        assertThat(result.getResponse().getContentAsString(), containsString("5.25"));
    }

    @Test
    public void whenCornculateWithoutBagsOfCorn_thenNoBagsOfCornValidationMessage() throws Exception {
        // arrange
        ferrymansTripDto.setAmount(0);
        ferrymansTripDto.setPricePerTrip(.25);
        ferrymansTripJson = new ObjectMapper().writeValueAsString(ferrymansTripDto);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
            .content(ferrymansTripJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        // assert
        assertEquals(400, result.getResponse().getStatus());
        assertThat(result.getResponse().getContentAsString(), containsString("Needs bags of corn!"));
    }

    @Test
    public void whenCornculateWithoutPricePerTrip_thenAutomaticallyCornculatedAt25p() throws Exception {
        // arrange
        ferrymansTripDto.setAmount(5);
        ferrymansTripJson = new ObjectMapper().writeValueAsString(ferrymansTripDto);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
            .content(ferrymansTripJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        // assert
        assertEquals(200, result.getResponse().getStatus());
        assertThat(result.getResponse().getContentAsString(), containsString("2.75"));
    }
}
