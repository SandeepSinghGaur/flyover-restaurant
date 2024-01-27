package com.flyover.restaurant.controllers;

import com.flyover.restaurant.models.JwtRequest;
import com.flyover.restaurant.models.JwtResponse;
import com.flyover.restaurant.models.UserRegistrationModel;
import com.flyover.restaurant.security.JwtHelper;
import com.flyover.restaurant.servicesInterface.UserManagementService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserManagementService userManagementService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getMobileNumber(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getMobileNumber());
        String token = this.jwtHelper.generateToken(userDetails);
        JwtResponse jwtResponse = JwtResponse.builder().token(token).username(userDetails.getUsername()).build();
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    private void doAuthenticate(String mobileNumber, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(mobileNumber,password);
        try {
            manager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid Username and password !!");
        }
    }

    @PostMapping(value="/registration")
    public boolean userRegistration(@Valid @RequestBody UserRegistrationModel userRegistrationModel){
        logger.info("Received user registration request: {}", userRegistrationModel);
        if(Objects.nonNull(userRegistrationModel)){
            return this.userManagementService.userRegistration(userRegistrationModel);
        }
        return false;
    }
}
