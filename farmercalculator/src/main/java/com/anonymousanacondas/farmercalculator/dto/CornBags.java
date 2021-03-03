package com.anonymousanacondas.farmercalculator.dto;

import lombok.Data;
import javax.validation.constraints.Min;

@Data
public class CornBags {
    
    @Min(value = 1, message = "Needs bags of corn!")
    public int Amount;
}
