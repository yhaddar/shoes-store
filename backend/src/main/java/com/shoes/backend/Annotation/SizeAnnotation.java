package com.shoes.backend.Annotation;

import com.shoes.backend.Validation.SizeValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SizeValidation.class)
public @interface SizeAnnotation {
    String message() default "Size must be greater than or equal to 16";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
