package com.shoes.backend.Annotation;

import com.shoes.backend.Validation.BrandValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BrandValidation.class)
public @interface BrandExist {
    String message() default "this brand does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
