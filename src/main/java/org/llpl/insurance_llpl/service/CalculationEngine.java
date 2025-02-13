package org.llpl.insurance_llpl.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.llpl.insurance_llpl.model.Client;
import org.llpl.insurance_llpl.model.Property;

@Service
@RequiredArgsConstructor
public class CalculationEngine {

    public BigDecimal calculateBasePrice(Property property) {
        BigDecimal baseRate = BigDecimal.valueOf(0.001); // 0.1% of property value
        return property.getPropertyValue().multiply(baseRate);
    }

    public BigDecimal calculateFinalPrice(Property property, Client client) {
        BigDecimal basePrice = calculateBasePrice(property);
        BigDecimal finalPrice = basePrice;

        // Apply age factor
        if (property.getConstructionYear() < 1990) {
            finalPrice = finalPrice.multiply(BigDecimal.valueOf(1.2)); // 20% increase for older buildings
        }

        // Apply area factor
        if (property.getArea() > 200) {
            finalPrice = finalPrice.multiply(BigDecimal.valueOf(1.1)); // 10% increase for large areas
        }

        return finalPrice;
    }
}