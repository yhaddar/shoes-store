package com.shoes.backend.Validation;

import com.shoes.backend.Annotation.SizeAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collections;
import java.util.List;

public class SizeValidation implements ConstraintValidator<SizeAnnotation, List<Integer>> {
    @Override
    public boolean isValid(List<Integer> integers, ConstraintValidatorContext constraintValidatorContext) {
        if(integers.isEmpty())
            return false;

        Collections.sort(integers);

        return integers.getFirst() >= 16 && integers.getLast() <= 50;
    }
}
