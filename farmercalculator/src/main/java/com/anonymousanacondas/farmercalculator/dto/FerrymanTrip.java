package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class FerrymanTrip {
    
    public FerrymanTrip() {
        if (pricePerTrip == 0) {
            pricePerTrip = .25;
        }
    }

    @Min(value = 1, message = "Needs bags of corn!")
    public int amount;

    public double pricePerTrip;

    public double ferrymansPrice;

    public double calculateTripPrice() {
        if (this.amount == 1) return this.priceThereAndHome();
        return (this.amount * priceThereAndBackAgain()) + this.priceThereAndHome();
    }

    private double priceThereAndBackAgain() {
        return this.pricePerTrip * 2;
    }

    private double priceThereAndHome() {
        return this.pricePerTrip * 2;
    }
}
