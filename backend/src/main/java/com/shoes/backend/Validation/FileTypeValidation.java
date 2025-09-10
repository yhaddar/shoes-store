package com.shoes.backend.Validation;

import com.shoes.backend.Annotation.FileType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FileTypeValidation implements ConstraintValidator<FileType, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        if(multipartFile == null || multipartFile.isEmpty())
            return false;

        List<String> extension = List.of("image/jpg", "image/png", "image/jpeg", "image/webp");
        return extension.contains(multipartFile.getContentType());
    }
}
