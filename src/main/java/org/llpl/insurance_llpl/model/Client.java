package org.llpl.insurance_llpl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String pesel;

    @Column(nullable = false)
    private String postalCode;

    private String email;
    private String phoneNumber;
    private String address;

    @Column(nullable = false)
    private boolean marketingConsent;

    @OneToMany(mappedBy = "client")
    private List<Property> properties;

    @OneToMany(mappedBy = "client")
    private List<InsuranceCalculation> calculations;

    @OneToMany(mappedBy = "client")
    private List<InsuranceOffer> offers;

    @OneToMany(mappedBy = "client")
    private List<InsurancePolicy> policies;
}