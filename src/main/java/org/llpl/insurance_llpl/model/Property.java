package org.llpl.insurance_llpl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private BigDecimal propertyValue;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Integer constructionYear;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "property")
    private List<InsuranceCalculation> calculations;

    @OneToMany(mappedBy = "property")
    private List<InsuranceOffer> offers;

    @OneToMany(mappedBy = "property")
    private List<InsurancePolicy> policies;
}