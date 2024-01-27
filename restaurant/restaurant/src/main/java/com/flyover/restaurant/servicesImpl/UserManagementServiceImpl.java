package com.flyover.restaurant.servicesImpl;

import com.flyover.restaurant.entity.User;
import com.flyover.restaurant.models.UserDto;
import com.flyover.restaurant.models.UserRegistrationModel;
import com.flyover.restaurant.repositories.UserRepository;
import com.flyover.restaurant.servicesInterface.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional("transactionManager")
public class UserManagementServiceImpl implements UserManagementService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean userRegistration(UserRegistrationModel userRegistrationModel) {
       User u = new User();
       u.setUserAddress(userRegistrationModel.getAddress());
       u.setUserEmailId(userRegistrationModel.getEmail());
       u.setUserMobileNumber(userRegistrationModel.getMobileNumber());
       u.setUserPassword(passwordEncoder.encode(userRegistrationModel.getPassword()));
       u.setUserBirthDate(userRegistrationModel.getBirthDate());
       u.setUserName(userRegistrationModel.getUsername());
       u.setUserFirstName(userRegistrationModel.getFirstName());
       u.setUserLatName(userRegistrationModel.getLastName());

       try{
           this.userRepository.save(u);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException("Error during user registration", e);
       }
    }

    @Override
    public ResponseEntity<UserDto> login(String email, String password) {
        Optional<User> userOptional = userRepository.findByUserEmailId(email);

        if (userOptional.isEmpty()) {
            //return this.userRegistration(email, password);
            return null;
        }

        User user = userOptional.get();

        return null;
    }
}
