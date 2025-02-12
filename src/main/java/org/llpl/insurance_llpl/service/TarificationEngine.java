package org.llpl.insurance_llpl.service;

import lombok.RequiredArgsConstructor;
import org.insurance.model.Property;
import org.insurance.model.InsuranceCalculation;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TarificationEngine {

    public InsuranceCalculation calculateInsurance(Property property) {
        InsuranceCalculation calculation = new InsuranceCalculation();
        calculation.setProperty(property);
        calculation.setClient(property.getClient());

        // Przykładowa logika taryfikacji
        BigDecimal basePrice = calculateBasePrice(property);
        BigDecimal finalPrice = applyModifiers(basePrice, property);

        calculation.setBasePrice(basePrice);
        calculation.setFinalPrice(finalPrice);

        return calculation;
    }

    private BigDecimal calculateBasePrice(Property property) {
        // Implementacja logiki wyliczania ceny bazowej
        return BigDecimal.valueOf(1000);
    }

    private BigDecimal applyModifiers(BigDecimal basePrice, Property property) {
        // Implementacja modyfikatorów ceny
        return basePrice;
    }
}
