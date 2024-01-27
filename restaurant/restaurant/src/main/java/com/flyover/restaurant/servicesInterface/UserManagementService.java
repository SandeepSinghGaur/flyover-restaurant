package com.flyover.restaurant.servicesInterface;

import com.flyover.restaurant.models.UserDto;
import com.flyover.restaurant.models.UserRegistrationModel;
import org.springframework.http.ResponseEntity;

public interface UserManagementService {
    public boolean userRegistration(UserRegistrationModel userRegistrationModel);

    public ResponseEntity<UserDto> login(String email, String password);
}
