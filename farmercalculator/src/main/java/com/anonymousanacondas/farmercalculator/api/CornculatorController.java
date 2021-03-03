package com.anonymousanacondas.farmercalculator.api;

import com.anonymousanacondas.farmercalculator.dto.CornBags;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/cornculate")
@RestController
public class CornculatorController {
    
    @PostMapping
    public ResponseEntity<Double> postCornBags(@RequestBody CornBags cornBagsDto) {
        return ResponseEntity.ok(0.0);
    }
    
}
