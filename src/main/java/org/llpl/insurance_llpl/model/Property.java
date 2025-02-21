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
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false, length = 50)
    private String street;

    @Column(length = 20, nullable = false)
    private String houseNumber;

    @Column(length = 5, nullable = false)
    private String apartmentNumber;

    @Column(nullable = false)
    private String propertyType;

    @Column(nullable = false)
    private BigDecimal propertyValue;

    private BigDecimal electronicValue;

    @Column(nullable = false)
    private boolean isArt;

    private BigDecimal artValue;                            // Only if isArt = true

    private BigDecimal otherValue;

    @Column(nullable = false)
    private boolean isCash;

    private BigDecimal cashValue;                          // Only if isCash = true

    @Column(nullable = false)
    private boolean isRented;

    @Column(nullable = false)
    private boolean isGarage;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Integer constructionYear;

    private String constructionType;                        // House only

    private String roofType;                                // House only

    private String heatingType;                             // House only



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