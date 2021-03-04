package com.anonymousanacondas.farmercalculator.api;

import javax.validation.Valid;

import com.anonymousanacondas.farmercalculator.dto.FerrymanTrip;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/cornculate")
@RestController
public class CornculatorController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<FerrymanResponse> postCornBags(
        @RequestBody @Valid FerrymanTrip ferrymanTripDto) {
        FerrymanResponse response = new FerrymanResponse();

        double quote = ferrymanTripDto.cornculateFerrymansQuote();
        response.setFerrymansQuote(quote);

        String instructions = ferrymanTripDto.getInstructions();
        response.setInstructions(instructions);

        response.setPriceCrocMeat(ferrymanTripDto.getTotalCrocPrice());
        response.setAmountCrocMeat(ferrymanTripDto.getAmountOfCrocMeat());

        return ResponseEntity.ok(response);
    }
    
}
