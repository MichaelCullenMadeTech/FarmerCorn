package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;

@Data
public class FerrymanTrip {

    public int cornBags;

    public int geese;

    public double ferrymansCharge;

    public double ferrymansQuote;

    public double cornculateFerrymansQuote() {
        if (this.hasCorn() == this.hasGeese() && !this.equalAmounts()) {
            return cornculateCornGeeseRoundTripPlusEmptyTrip();
        }
        return cornculateCornGeeseRoundTrip();
    }

    private boolean hasCorn() {
        return this.cornBags > 0;
    }

    private boolean hasGeese() {
        return this.geese > 0;
    }
    
    private boolean equalAmounts() {
        return this.cornBags == this.geese;
    }

    private double cornculateCornGeeseRoundTrip() {
        return totalTrips() * this.roundTrip();
    }

    private int totalTrips() {
        int totalTrips = this.cornBags + this.geese;
        return totalTrips == 0 ? 1 : totalTrips;
    }

    private double cornculateCornGeeseRoundTripPlusEmptyTrip() {
        return this.cornculateCornGeeseRoundTrip() + this.roundTrip();
    }

    private double roundTrip() {
        if (this.ferrymansCharge == 0.0) this.ferrymansCharge = .25;
        return this.ferrymansCharge * 2;
    }
}
