package com.shoes.backend.DTO.ShoesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shoes.backend.Annotation.FileType;
import com.shoes.backend.Annotation.ShoesExist;
import com.shoes.backend.Annotation.SizeAnnotation;
import com.shoes.backend.DTO.BaseDTO.CreateItemDTO;
import com.shoes.backend.Entity.Shoes;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateShoesSecondaryDTO {

    @Valid

    @NotNull(message = "this field no should be null")
    @ShoesExist
    private Shoes shoes;

    @NotNull(message = "the image is required")
    @FileType()
    private MultipartFile image;
    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Pattern(regexp = "^#(?:[A-Fa-f0-9]{3}|[A-Fa-f0-9]{6})$", message = "this color must be a Hex format")
    private String color;

    @NotNull(message = "this field no should be null")
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @SizeAnnotation
    @NotEmpty(message = "this field no should be empty")
    private List<Integer> size;

}
