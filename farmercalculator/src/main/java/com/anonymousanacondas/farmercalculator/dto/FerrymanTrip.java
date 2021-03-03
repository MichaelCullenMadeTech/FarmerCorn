package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;
import javax.validation.constraints.Min;

@Data
public class FerrymanTrip {
    
    @Min(value = 1, message = "Needs bags of corn!")
    public int Amount;

    public double pricePerTrip;

    public double ferrymansPrice;

    public double calculateTripPrice() {
        return this.Amount * this.pricePerTrip;
    }
}
