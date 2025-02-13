package org.llpl.insurance_llpl.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;

@Data
public class ClientDTO {
    private Long id;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "PESEL is required")
    @Pattern(regexp = "\\d{11}", message = "Invalid PESEL format")
    private String pesel;

    @NotNull(message = "Postal code is required")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Invalid postal code format")
    private String postalCode;

    @Email(message = "Invalid email format")
    private String email;

    private String phoneNumber;
    private String address;
    private boolean marketingConsent;
}