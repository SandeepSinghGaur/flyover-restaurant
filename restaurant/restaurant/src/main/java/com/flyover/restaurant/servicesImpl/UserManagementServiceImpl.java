package com.flyover.restaurant.servicesImpl;

import com.flyover.restaurant.models.UserRegistrationModel;
import com.flyover.restaurant.servicesInterface.UserManagementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("primaryTransactionManager")
public class UserManagementServiceImpl implements UserManagementService {
    @Override
    public boolean userRegistration(UserRegistrationModel userRegistrationModel) {
        return true;
    }
}
