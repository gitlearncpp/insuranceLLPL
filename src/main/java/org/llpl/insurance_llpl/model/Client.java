package org.llpl.insurance_llpl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;




@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name is required")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    @Column(nullable = false)
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    @Column(nullable = false)
    private String lastName;

    @NotNull(message = "PESEL is required")
    @Pattern(regexp = "\\d{11}", message = "PESEL must be exactly 11 digits")
    @Column(nullable = false, unique = true)
    private String pesel;

    @NotNull
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must be in the format XX-XXX")
    @Column(nullable = false)
    private String postalCode;

    @Email(message = "Invalid email")
    private String email;

    @Pattern(regexp = "\\d{9}", message = "Phone number must be exactly 9 digits")
    private String phoneNumber;

    @Size(min = 4, max = 20, message = "Street must be between 4 and 20 characters")
    private String street;

    @Size(min = 2, max = 20, message = "City must be between 2 and 20 characters")
    private String city;

    @Size(min = 2, max = 20, message = "Country must be between 2 and 20 characters")
    private String country;

    @Size(min = 4, max = 20, message = "State must be between 4 and 20 characters")
    private String state;

    @Size(min = 1, max = 10, message = "House number must be between 1 and 10 characters")
    private String houseNumber;

    @Size(min = 1, max = 5, message = "Apartment number must be between 1 and 5 characters")
    private String apartmentNumber;

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