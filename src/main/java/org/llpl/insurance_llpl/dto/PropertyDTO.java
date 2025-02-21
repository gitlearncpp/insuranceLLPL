package org.llpl.insurance_llpl.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import jakarta.validation.constraints.Pattern;

// ToDo zweryfikować DTO i metody ewentualne

@Data
public class PropertyDTO {
    private Long id;

    @NotNull(message = "Postal code is required")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Invalid postal code format")
    private String postalCode;

    @NotNull(message = "City is required")
    @Pattern(regexp = "[a-zA-Z]+", message = "Invalid city format")
    private String city;

    @NotNull(message = "Country is required")
    @Pattern(regexp = "[a-zA-Z]+", message = "Invalid country format")
    @Size(min = 2, max = 20, message = "Country code must be 2 characters")
    private String country;

    @Size(min = 4, max = 30, message = "Street must be between 4 and 20 characters")
    @NotNull(message = "Street is required")
    private String street;

    @Positive(message = "Property value must be positive")
    @NotNull(message = "House number is required")
    @Size(min = 1, max = 10, message = "House number must be between 1 and 10 characters")
    private String houseNumber;

    @Positive(message = "Property value must be positive")
    @NotNull(message = "Apartment number is required")
    @Size(min = 1, max = 5, message = "Apartment number must be between 1 and 5 characters")
    private String apartmentNumber;

    @NotNull(message = "Property type is required")
    @Pattern(regexp = "[a-zA-Z]+", message = "Invalid property type format")
    private String propertyType;

    @NotNull(message = "Property value is required")
    @Positive(message = "Property value must be positive")
    private BigDecimal propertyValue;

    @Positive(message = "Electronic value must be positive")
    private BigDecimal electronicValue;

    @NotNull(message = "Is art is required")
    private boolean isArt;

    private BigDecimal artValue;

    private BigDecimal otherValue;

    @NotNull(message = "Is cash is required")
    private boolean isCash;

    private BigDecimal cashValue;

    @NotNull(message = "Is rented is required")
    private boolean isRented;

    @NotNull(message = "Is garage is required")
    private boolean isGarage;

    @NotNull(message = "Area is required")
    @Positive(message = "Area must be positive")
    private Double area;

    @Positive(message = "Property value must be positive")
    @NotNull(message = "Construction year is required")
    private Integer constructionYear;

    private String constructionType;

    private String roofType;

    private String heatingType;

    @NotNull(message = "Client ID is required")
    private Long clientId;
}