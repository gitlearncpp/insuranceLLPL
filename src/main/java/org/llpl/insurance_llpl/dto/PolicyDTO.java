package org.llpl.insurance_llpl.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PolicyDTO {
    private Long id;
    private String policyNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal premium;
    private String status;
    private Long offerId;
    private Long propertyId;
    private Long clientId;
}