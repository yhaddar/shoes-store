package com.shoes.backend.Annotation;

import com.shoes.backend.Validation.FileTypeValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileTypeValidation.class)
public @interface FileType {

    String message() default  "the type of image invalid, import image with png or jpg or jpeg or webp";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
