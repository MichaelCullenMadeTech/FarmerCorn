package com.anonymousanacondas.farmercalculator.service;

public class CornculatorService {
     
    private final double ferrymanPrice = 0.25;

    public double calculateTripPrice(int amountOfCornBags) {
        return amountOfCornBags * ferrymanPrice;
    }
}
