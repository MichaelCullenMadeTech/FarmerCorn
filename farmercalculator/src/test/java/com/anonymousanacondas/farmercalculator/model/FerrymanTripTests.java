package com.anonymousanacondas.farmercalculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.anonymousanacondas.farmercalculator.dto.FerrymanTrip;

import org.junit.jupiter.api.Test;

public class FerrymanTripTests {
    
    @Test
    public void whenICrossWith10Bags_thenPriceIsAFiver() {
        // arrange
        double fiver = 5.0;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setCornBags(10);
        ferrymanTrip.setFerrymansCharge(.25);

        // act
        double totalPrice = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(fiver, totalPrice);
    }

    @Test
    public void whenIDoNotHaveAPricePerTrip_thenPriceIsDefaultedTo25Pee() {
        // arrange
        FerrymanTrip ferrymanTrip = new FerrymanTrip();

        // act
        ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(.25, ferrymanTrip.getFerrymansCharge());
    }

    @Test 
    public void whenICrossWith1Bag_thenPriceIsFiftyPee() {
        // arrange
        double fiftyPee = 0.5;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setCornBags(1);

        // act
        double result = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(fiftyPee, result);
    }

    @Test
    public void whenICrossWith1Goose_thenPriceIsFiftyPee() {
        // arrange
        double fiftyPee = 0.5;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setGeese(1);

        // act
        double result = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(fiftyPee, result);
    }

    @Test
    public void whenICrossWith1BagAnd1Goose_thenPriceIsAQuid() {
        // arrange
        double quid = 1.0;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setCornBags(1);
        ferrymanTrip.setGeese(1);

        // act
        double result = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(quid, result);
    }

    @Test
    public void whenICrossWith2BagsAnd1Goose_thenPriceIsTwoQuid() {
        // arrange
        double twoQuid = 2.0;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setCornBags(2);
        ferrymanTrip.setGeese(1);

        // act
        double result = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(twoQuid, result);
    }

    @Test
    public void whenICrossWith1BagAnd2Geese_thenPriceIsTwoQuid() {
        // arrange
        double twoQuid = 2.0;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setCornBags(1);
        ferrymanTrip.setGeese(2);

        // act
        double result = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(twoQuid, result);
    }

    @Test
    public void whenICrossWithNoBagsAndNoGeese_thenPriceIsFiftyPee() {
        // arrange
        double fiftyPee = 0.5;
        FerrymanTrip ferrymanTrip = new FerrymanTrip();
        ferrymanTrip.setCornBags(0);
        ferrymanTrip.setGeese(0);

        // act
        double result = ferrymanTrip.cornculateFerrymansQuote();

        // assert
        assertEquals(fiftyPee, result);
    }

}
