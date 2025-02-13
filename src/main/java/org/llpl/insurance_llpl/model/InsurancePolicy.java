package org.llpl.insurance_llpl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private BigDecimal premium;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private InsuranceOffer offer;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}