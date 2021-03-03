package com.anonymousanacondas.farmercalculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CornculatorServiceTest {
    
    @Test
    public void whenIHaveTenBagsOfCorn_thenPriceIsTwoPoundsAndFiftyPence() {
        // arrange
        CornculatorService cornculatorService = new CornculatorService();
        int bagsOfCorn = 10;
        double twoFifty = 2.50;

        // act
        double result = cornculatorService.calculateTripPrice(bagsOfCorn);

        // assert
        assertEquals(twoFifty, result);
    }
}
