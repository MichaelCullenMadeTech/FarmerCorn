package com.anonymousanacondas.farmercalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.anonymousanacondas.farmercalculator.api.CornculatorController;
import com.anonymousanacondas.farmercalculator.dto.CornBags;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
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

    public CornculatorControllerTest() {
        cornBagsDto = new CornBags();
    }
    
    @Test
    public void cornculate() throws Exception {  
        // arrange
        cornBagsDto.setAmount(10);
        String cornBagsJson = new ObjectMapper().writeValueAsString(cornBagsDto);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(cornculatorApi)
            .content(cornBagsJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        // assert
        assertEquals(200, result.getResponse().getStatus());
    }
}
