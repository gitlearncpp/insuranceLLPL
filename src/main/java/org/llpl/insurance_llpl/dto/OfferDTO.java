package org.llpl.insurance_llpl.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OfferDTO {
    private Long id;
    private BigDecimal offerPrice;
    private LocalDateTime validUntil;
    private LocalDateTime createdAt;
    private String offerDetails;
    private Long calculationId;
    private Long propertyId;
    private Long clientId;
}