package org.llpl.insurance_llpl.controller;

import lombok.RequiredArgsConstructor;
import org.llpl.insurance_llpl.model.InsuranceCalculation;
import org.llpl.insurance_llpl.dto.CalculationDTO;
import org.llpl.insurance_llpl.service.CalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculations")
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping
    public ResponseEntity<InsuranceCalculation> createCalculation(@RequestBody CalculationDTO calculationDTO) {
        return ResponseEntity.ok(calculationService.createCalculation(calculationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceCalculation> getCalculation(@PathVariable Long id) {
        return ResponseEntity.ok(calculationService.getCalculation(id));
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<InsuranceCalculation> getCalculationForProperty(@PathVariable Long propertyId) {
        return ResponseEntity.ok(calculationService.getCalculationForProperty(propertyId));
    }
}