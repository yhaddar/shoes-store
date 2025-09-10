package com.shoes.backend.Annotation;

import com.shoes.backend.Validation.ShoesValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ShoesValidation.class)
public @interface ShoesExist {
    String message() default "this shoes don't exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
