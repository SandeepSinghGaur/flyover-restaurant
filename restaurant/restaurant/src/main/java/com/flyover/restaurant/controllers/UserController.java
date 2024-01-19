package com.flyover.restaurant.controllers;

import com.flyover.restaurant.models.UserRegistrationModel;
import com.flyover.restaurant.servicesInterface.UserManagementService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserManagementService userManagementService;

    @PostMapping(value="v1/user/registration")
    public boolean userRegistration(@Valid @RequestBody UserRegistrationModel userRegistrationModel){
        logger.info("Received user registration request: {}", userRegistrationModel);
        if(Objects.nonNull(userRegistrationModel)){
              return this.userManagementService.userRegistration(userRegistrationModel);
        }
        return false;
    }

}
