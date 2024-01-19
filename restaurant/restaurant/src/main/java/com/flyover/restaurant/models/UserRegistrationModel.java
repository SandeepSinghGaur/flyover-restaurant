package com.flyover.restaurant.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationModel {
    private String userName;
    @NotNull
    private String userFirstName;
    @NotNull
    private String userLastName;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Invalid birthdate format. Use dd/mm/yyyy.")
    private String userBirthDate;
    @NotNull
    @Email
    private String userEmailId;
    @NotNull
    private String userMobileNumber;
    @NotNull
    private char userGender;
    private String userReferralCode;
    @NotNull
    @Size(min = 8, max = 20, message = "Password length must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String userPassword;
    private String userAddress;

}
