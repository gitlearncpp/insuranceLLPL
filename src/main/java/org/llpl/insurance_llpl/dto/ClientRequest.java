package org.llpl.insurance_llpl.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequest {

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    private String pesel;

    @NotNull
    private String birthDate;

    @NotNull
    private String postalCode;

    @Email(message = "Invalid email")
    private String email;

    @Size(max = 9)
    private String phoneNumber;

    @NotNull
    private String street;

    @NotNull
    @Size(max = 50)
    private String city;

    @NotNull
    private String country;

    @Size(max = 20)
    private String state;

    @Size(min = 1, max = 10, message = "House number must be between 1 and 10 characters")
    private String houseNumber;

    @Size(min = 1, max = 5, message = "Apartment number must be between 1 and 5 characters")
    private String apartmentNumber;

    private String gender;

    @NotNull
    private String declaredGender;

    @NotNull
    private boolean marketingConsent;

    @NotNull
    private boolean emailConsent;
}