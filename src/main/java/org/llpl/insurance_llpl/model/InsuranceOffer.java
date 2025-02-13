package org.llpl.insurance_llpl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class InsuranceOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal offerPrice;

    @Column(nullable = false)
    private LocalDateTime validUntil;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private String offerDetails;

    @ManyToOne
    @JoinColumn(name = "calculation_id", nullable = false)
    private InsuranceCalculation calculation;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}