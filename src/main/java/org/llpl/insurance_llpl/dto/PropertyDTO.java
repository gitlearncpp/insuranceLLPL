package org.llpl.insurance_llpl.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import jakarta.validation.constraints.Pattern;

@Data
public class PropertyDTO {
    private Long id;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Postal code is required")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Invalid postal code format")
    private String postalCode;

    @NotNull(message = "Property value is required")
    @Positive(message = "Property value must be positive")
    private BigDecimal propertyValue;

    @NotNull(message = "Area is required")
    @Positive(message = "Area must be positive")
    private Double area;

    @NotNull(message = "Construction year is required")
    private Integer constructionYear;

    @NotNull(message = "Client ID is required")
    private Long clientId;
}