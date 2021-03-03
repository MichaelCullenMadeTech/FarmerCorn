package com.anonymousanacondas.farmercalculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.anonymousanacondas.farmercalculator.dto.FerrymanTrip;

import org.junit.jupiter.api.Test;

public class FerrymanTripTests {
    
    @Test
    public void whenICrossWith10Bags_thenPriceIs550p() {
        // arrange
        double fiver = 5.0;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setAmount(10);
        ferrymanTrip.setPricePerTrip(.25);

        // act
        double totalPrice = ferrymanTrip.calculateTripPrice();

        // assert
        assertEquals(fiver, totalPrice);
    }

    @Test
    public void whenIDoNotHaveAPricePerTrip_thenPriceIsDefaultedTo25p() {
        // arrange
        FerrymanTrip ferrymanTrip = new FerrymanTrip();

        // assert
        assertEquals(.25, ferrymanTrip.getPricePerTrip());
    }

    @Test 
    public void whenICrossWith1Bag_thenPriceIsASingleTrip() {
        // arrange
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setAmount(1);

        // assert
        assertEquals(.5, ferrymanTrip.calculateTripPrice());
    }
}
