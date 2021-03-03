package com.anonymousanacondas.farmercalculator.api;

import com.anonymousanacondas.farmercalculator.dto.CornBags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/cornculate")
@RestController
public class CornculatorController {

    private final CornculatorService cornculatorService;
    
    @PostMapping
    public ResponseEntity<Double> postCornBags(@RequestBody CornBags cornBagsDto) {
        double pricePerTrip = 0.25;


        return ResponseEntity.ok(0.0);
    }
    
}
