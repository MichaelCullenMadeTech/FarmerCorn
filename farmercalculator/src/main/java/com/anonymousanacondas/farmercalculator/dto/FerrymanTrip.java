package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class FerrymanTrip {

    @Min(value = 1, message = "Needs bags of corn!")
    public int amount;

    public double pricePerTrip;

    public double ferrymansPrice;

    public double calculateTripPrice() {
        return this.amount * this.roundTrip();
    }

    private double roundTrip() {
        if (this.pricePerTrip == 0.0) this.pricePerTrip = .25;
        return this.pricePerTrip * 2;
    }
}
