package com.flyover.restaurant.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationModel {
    private String username;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Invalid birthdate format. Use dd/mm/yyyy.")
    private String birthDate;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String mobileNumber;
    @NotNull
    private char gender;
    private String referralCode;
    @NotNull
    @Size(min = 8, max = 20, message = "Password length must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;
    private String address;

}
