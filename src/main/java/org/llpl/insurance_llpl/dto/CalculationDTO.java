package org.llpl.insurance_llpl.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CalculationDTO {
    private Long id;
    private BigDecimal basePrice;
    private BigDecimal finalPrice;
    private String calculationFactors;
    private LocalDateTime createdAt;
    private Long propertyId;
    private Long clientId;
}