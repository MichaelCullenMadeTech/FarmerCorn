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
        return ((this.amount * this.pricePerTrip) * 2) + this.pricePerTrip;
    }
}
