package com.flyover.restaurant.controllers;

import com.flyover.restaurant.models.LoginRequestDto;
import com.flyover.restaurant.models.UserDto;
import com.flyover.restaurant.models.UserRegistrationModel;
import com.flyover.restaurant.servicesInterface.UserManagementService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/v1")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserManagementService userManagementService;

    @PostMapping(value="/user/registration")
    public boolean userRegistration(@Valid @RequestBody UserRegistrationModel userRegistrationModel){
        logger.info("Received user registration request: {}", userRegistrationModel);
        if(Objects.nonNull(userRegistrationModel)){
              return this.userManagementService.userRegistration(userRegistrationModel);
        }
        return false;
    }


}
