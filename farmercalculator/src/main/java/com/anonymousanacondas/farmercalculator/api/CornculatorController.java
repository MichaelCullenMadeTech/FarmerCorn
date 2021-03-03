package com.anonymousanacondas.farmercalculator.api;

import javax.validation.Valid;

import com.anonymousanacondas.farmercalculator.dto.CornBags;
import com.anonymousanacondas.farmercalculator.service.CornculatorService;

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
    
    @Autowired
    public CornculatorController(CornculatorService cornculatorService) {
        this.cornculatorService = cornculatorService;
    }

    @PostMapping
    public ResponseEntity<Double> postCornBags(
        @RequestBody @Valid CornBags cornBagsDto) {
        double result = cornculatorService.calculateTripPrice(cornBagsDto.getAmount());
        return ResponseEntity.ok(result);
    }
    
}
