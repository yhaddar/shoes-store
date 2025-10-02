package com.shoes.backend.Validation;

import com.shoes.backend.Annotation.UserExist;
import com.shoes.backend.Repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class UserValidation implements ConstraintValidator<UserExist, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String user, ConstraintValidatorContext constraintValidatorContext) {
        if(user.isEmpty()){
            return false;
        }

        return this.userRepository.findByEmail(user) == 0;
    }
}
