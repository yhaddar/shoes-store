package com.shoes.backend.Annotation;

import com.shoes.backend.Validation.CategoryValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryValidation.class)
public @interface CategoryExist {
    String message() default "this category not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
