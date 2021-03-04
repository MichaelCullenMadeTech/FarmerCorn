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


	public String getInstructions() {
		if (!this.hasGeese() && !this.hasCorn()) {
            return noItems;
        }
        else if (!this.hasGeese() && this.hasCorn()) {
            return justCornItems;
        }
        else if (this.hasGeese() && !this.hasCorn()) {
            return justGeeseItems;
        }
        else if (this.geese == 1 && this.cornBags == 1) {
            return oneOfEach;
        }
        else if (this.geese == 2 && this.cornBags == 1) {
            return twoGeeseOneCorn;
        }
        else if (this.geese == 1 && this.cornBags == 2) {
            return twoCornOneGoose;
        }
        return unknownInstructions;
	}

    public String noItems = "Go to market. Go back home.";
    public String justCornItems = "Take corn over to market side. Return empty handed to home side. If you still have corn repeat previous two steps, otherwise go back home.";
    public String justGeeseItems = "Take geese over to market side. Return empty handed to home side. If you still have geese repeat previous two steps, otherwise go back home.";
    public String oneOfEach = "Take corn over to market side. Return empty handed to home side. Take geese over to market side. Return to home side.";
    public String twoCornOneGoose = "Take geese over to market side. Return empty handed to home side. Take corn #1 over to market side. Bring goose back to home side. Take corn #2 over to market. Return to home side. Bring goose over to market side. Return to home side";
    public String twoGeeseOneCorn = "Take corn over to market side. Return empty handed to home side. Take goose #1 over market. Bring corn over to home side. Take goose # 2 over to market. Return to home side. Take corn over to market side. Return to home side";
    public String unknownInstructions = "Cannot be done!";

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
