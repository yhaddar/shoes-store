package com.shoes.backend.Validation;

import com.shoes.backend.Annotation.BrandExist;
import com.shoes.backend.Entity.Brand;
import com.shoes.backend.Repository.BrandRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class BrandValidation implements ConstraintValidator<BrandExist, Brand> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public boolean isValid(Brand brand, ConstraintValidatorContext constraintValidatorContext) {
        if(brand == null)
            return false;

        return this.brandRepository.findById(brand.getId()).isPresent();
    }
}
