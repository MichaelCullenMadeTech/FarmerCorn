package com.anonymousanacondas.farmercalculator.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setup() {
        ferrymansTripDto = new FerrymanTrip();
    }
    
    @Test
    public void whenIPostToCornculate_thenCornculated() throws Exception {  
        // arrange
        ferrymansTripDto.setCornBags(10);
        ferrymansTripDto.setFerrymansCharge(.25);
        ferrymansTripDto.setCrocPrice(.05);;

        // act
        MvcResult result = post(createJsonBody(ferrymansTripDto));

        // assert
        assertEquals(200, result.getResponse().getStatus());
        FerrymanResponse objResponse = backToObject(result.getResponse().getContentAsString());
        assertEquals(5.0, objResponse.getFerrymansQuote());
        assertEquals(1.0, objResponse.getPriceCrocMeat());
        assertEquals(20, objResponse.getAmountCrocMeat());
    }

    private String createJsonBody(FerrymanTrip ferrymanTrip) {
        try {
            return new ObjectMapper().writeValueAsString(ferrymanTrip);
        }
        catch (Exception exception) {
            fail(exception.getMessage());
            return null;
        }
    }

    private FerrymanResponse backToObject(String jsonResponse) {
        try {
            return new ObjectMapper().readValue(jsonResponse, FerrymanResponse.class);
        }
        catch (Exception exception) {
            fail(exception.getMessage());
            return null;
        }
    }

    private MvcResult post(String jsonBody) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        }
        catch (Exception exception) {
            fail(exception.getMessage());
            return null;
        }
    }
}
