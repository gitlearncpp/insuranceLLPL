package org.llpl.insurance_llpl.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    @NotNull(message = "Birth date is required")
    private String birthDate;

    @NotNull(message = "Postal code is required")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Invalid postal code format")
    private String postalCode;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{9}", message = "Phone number must be exactly 9 digits")
    private String phoneNumber;

    @NotNull(message = "Address is required")
    @Size(min = 4, max = 20, message = "Street must be between 4 and 20 characters")
    private String street;

    @NotNull(message = "City is required")
    @Size(min = 2, max = 20, message = "City must be between 2 and 20 characters")
    private String city;

    @NotNull(message = "Country is required")
    @Size(min = 2, max = 20, message = "Country must be between 2 and 20 characters")
    private String country;

    @NotNull(message = "State is required")
    @Size(min = 4, max = 20, message = "State must be between 4 and 20 characters")
    private String state;

    @NotNull(message = "House number is required")
    @Size(min = 1, max = 10, message = "House number must be between 1 and 10 characters")
    private String houseNumber;

    @Size(min = 1, max = 5, message = "Apartment number must be between 1 and 5 characters")
    private String apartmentNumber;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "[KM]", message = "Gender must be either K (male) or M (female)")
    private String gender;

    @NotNull(message = "Declared gender is required")
    @Pattern(regexp = "[KM]", message = "Declared gender must be either K (male) or M (female)")
    private String declaredGender;

    @NotNull(message = "Marketing consent is required")
    private boolean marketingConsent;

    @NotNull(message = "Email consent is required")
    private boolean emailConsent;

    private String peselValidationMessage;


    // ToDo future - przenieść metody do biznesu albo nowa klasa np. walidator itp.
    /**
     * Setter for PESEL with automatic logic for:
     * - Date of birth extraction,
     * - Gender extraction, and
     * - Validation message update.
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;

        // Automatically extract and set birthDate
        this.birthDate = getBirthDateFromPesel();

        // Automatically extract and set gender
        this.gender = getGenderFromPesel();

        // Automatically validate PESEL and set validation message
        this.peselValidationMessage = validatePesel();
    }

    /**
     * Validates the PESEL number, including the checksum.
     *
     * @return message about correctness or incorrectness
     */
    public String validatePesel() {
        if (pesel == null || !pesel.matches("\\d{11}")) {
            return "The PESEL number must consist of 11 digits.";
        }
        if (!isValidChecksum()) {
            return "The PESEL number is incorrect (bad checksum).";
        }
        return "The PESEL number is valid.";
    }

    /**
     * Reads date of birth from PESEL number.
     *
     * @return date of birth as a string or null if incorrect
     */
    public String getBirthDateFromPesel() {
        if (pesel == null || pesel.length() != 11) {
            return null;
        }

        try {
            String yearComponent = pesel.substring(0, 2);
            String monthComponent = pesel.substring(2, 4);
            String dayComponent = pesel.substring(4, 6);

            int year = Integer.parseInt(yearComponent);
            int month = Integer.parseInt(monthComponent);
            int day = Integer.parseInt(dayComponent);

            // Century adjustment based on PESEL month
            if (month >= 1 && month <= 12) {
                year += 1900;
            } else if (month >= 21 && month <= 32) {
                year += 2000;
                month -= 20;
            } else if (month >= 41 && month <= 52) {
                year += 2100;
                month -= 40;
            } else if (month >= 61 && month <= 72) {
                year += 2200;
                month -= 60;
            } else if (month >= 81 && month <= 92) {
                year += 1800;
                month -= 80;
            } else {
                return null;
            }

            // Parsing birthdate
            LocalDate birthDate = LocalDate.of(year, month, day);
            return birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        } catch (DateTimeParseException | NumberFormatException e) {
            return null;
        }
    }

    /**
     * Reads gender based on PESEL number.
     *
     * @return gender as "K" or "M" or null if incorrect
     */
    public String getGenderFromPesel() {
        if (pesel == null || pesel.length() != 11) {
            return null;
        }

        int genderDigit = Character.getNumericValue(pesel.charAt(9));
        return (genderDigit % 2 == 0) ? "K" : "M";
    }

    /**
     * Verifies the checksum of the PESEL number.
     *
     * @return true if checksum is correct
     */
    private boolean isValidChecksum() {
        int[] weights = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        int controlDigit = Character.getNumericValue(pesel.charAt(10));
        return (sum % 10) == controlDigit;
    }
}