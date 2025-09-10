package com.shoes.backend.DTO.ShoesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shoes.backend.Annotation.FileType;
import com.shoes.backend.Annotation.SizeAnnotation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateShoesSecondaryDTO {
    @Valid

    private MultipartFile image;

    @Pattern(regexp = "^#(?:[A-Fa-f0-9]{3}|[A-Fa-f0-9]{6})$", message = "this color must be a Hex format")
    private String color;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @SizeAnnotation
    private List<Integer> size;
}
