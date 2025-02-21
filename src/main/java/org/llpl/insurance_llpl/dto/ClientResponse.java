package org.llpl.insurance_llpl.dto;

import lombok.Data;

@Data
public class ClientResponse {

    private Long id; // Generowane automatycznie

    private String firstName;

    private String lastName;

    private String pesel;

    private String birthDate;

    private String postalCode;

    private String email;

    private String phoneNumber;

    private String street;

    private String city;

    private String country;

    private String state;

    private String houseNumber;

    private String apartmentNumber;

    private String gender;

    private String declaredGender;

    private boolean marketingConsent;

    private boolean emailConsent;
}