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

    private String city;

    private String street;

    private String houseNumber;

    private String apartmentNumber;

    private String propertyType;

    @Column(nullable = false)
    private BigDecimal propertyValue;

    private BigDecimal electronicValue;

    private BigDecimal artValue;

    private BigDecimal otherValue;

    private boolean isCash;

    private BigDecimal cashValue;

    private boolean isRented;

    private BigDecimal isGarage;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Integer constructionYear;

    private String constructionType;

    private String roofType;

    private String heatingType;



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