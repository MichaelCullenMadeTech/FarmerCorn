package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;

@Data
public class FerrymanTrip {

    public int cornBags;

    public int geese;

    public double ferrymansCharge;

    public double ferrymansQuote;

    public double crocPrice;

    public int amountOfCrocMeat;

    public double totalCrocPrice;

    public double cornculateFerrymansQuote() {
        this.amountOfCrocMeat = this.cornculateCrocMeat();
        this.totalCrocPrice = this.cornculateCrocPrice();

        if (this.hasCorn() == this.hasGeese() && !this.equalAmounts()) {
            return cornculateCornGeeseRoundTripPlusEmptyTrip();
        }
        return cornculateCornGeeseRoundTrip();
    }

    private int cornculateCrocMeat() {
        return this.totalTrips() * 2;
    }

    private double cornculateCrocPrice() {
        return this.amountOfCrocMeat * this.crocPrice;
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

    public String noItems = "1. Go to market. 2. Go back home.";
    public String justCornItems = "1. Take corn over to market side. 2. Return empty handed to home side. 3. If you still have corn repeat previous two steps, otherwise go back home.";
    public String justGeeseItems = "1. Take geese over to market side. 2. Return empty handed to home side. 3. If you still have geese repeat previous two steps, otherwise go back home.";
    public String oneOfEach = "1. Take corn over to market side. 2. Return empty handed to home side. 3. Take geese over to market side. 4. Return to home side.";
    public String twoCornOneGoose = "1. Take geese over to market side. 2. Return empty handed to home side. 3. Take corn #1 over to market side. 4. Bring goose back to home side. 5. Take corn #2 over to market. 6. Return to home side. 7. Bring goose over to market side. 8. Return to home side.";
    public String twoGeeseOneCorn = "1. Take corn over to market side. 2. Return empty handed to home side. 3. Take goose #1 over market. 4. Bring corn over to home side. 5. Take goose # 2 over to market. 6. Return to home side. 7. Take corn over to market side. 8. Return to home side";
    public String unknownInstructions = "1. Cannot be done!";

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
