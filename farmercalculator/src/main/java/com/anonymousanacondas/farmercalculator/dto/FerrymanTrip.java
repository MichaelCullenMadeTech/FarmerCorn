package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;

@Data
public class FerrymanTrip {

    public int cornBags;

    public int geese;

    public double ferrymansCharge;

    public double ferrymansQuote;

    public double cornculateFerrymansQuote() {
        return (this.cornBags + this.geese) * this.roundTrip();
    }

    private double roundTrip() {
        if (this.ferrymansCharge == 0.0) this.ferrymansCharge = .25;
        return this.ferrymansCharge * 2;
    }
}
