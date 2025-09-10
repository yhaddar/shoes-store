package com.shoes.backend.Validation;

import com.shoes.backend.Annotation.ShoesExist;
import com.shoes.backend.Entity.Shoes;
import com.shoes.backend.Entity.ShoesSecondary;
import com.shoes.backend.Repository.ShoesRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoesValidation implements ConstraintValidator<ShoesExist, Shoes> {

    @Autowired
    private ShoesRepository shoesRepository;

    @Override
    public boolean isValid(Shoes shoes, ConstraintValidatorContext constraintValidatorContext) {
        if(shoes == null)
            return false;

        return this.shoesRepository.findById(shoes.getId()).isPresent();
    }
}
