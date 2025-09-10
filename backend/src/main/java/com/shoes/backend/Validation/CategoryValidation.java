package com.shoes.backend.Validation;

import com.shoes.backend.Annotation.CategoryExist;
import com.shoes.backend.Entity.Category;
import com.shoes.backend.Repository.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryValidation implements ConstraintValidator<CategoryExist, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        if(category == null)
            return false;

        return this.categoryRepository.findById(category.getId()).isPresent();
    }
}
