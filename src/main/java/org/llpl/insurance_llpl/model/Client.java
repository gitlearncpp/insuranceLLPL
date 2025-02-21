package org.llpl.insurance_llpl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;




@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String pesel;

    @Column(nullable = false)
    private String birthDate;

    @Column(nullable = false)
    @NotNull
    private String postalCode;

    @Email(message = "Invalid email")
    private String email;

    @Column(length = 9)
    private String phoneNumber;

    @Column(nullable = false)
    private String street;

    @Column(length =50, nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(length = 20)
    private String state;

    @Column(length = 51 )
    @Size(min = 1, max = 10, message = "House number must be between 1 and 10 characters")
    private String houseNumber;

    @Size(min = 1, max = 5, message = "Apartment number must be between 1 and 5 characters")
    private String apartmentNumber;

    private String gender;
    @Column(nullable = false)
    private String declaredGender;

    @Column(nullable = false)
    private boolean marketingConsent;

    @Column(nullable = false)
    private boolean emailConsent;



    @OneToMany(mappedBy = "client")
    private List<Property> properties;

    @OneToMany(mappedBy = "client")
    private List<InsuranceCalculation> calculations;

    @OneToMany(mappedBy = "client")
    private List<InsuranceOffer> offers;

    @OneToMany(mappedBy = "client")
    private List<InsurancePolicy> policies;
}