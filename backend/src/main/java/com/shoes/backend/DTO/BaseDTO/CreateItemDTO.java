package com.shoes.backend.DTO.BaseDTO;

import com.shoes.backend.Annotation.FileType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateItemDTO {
    @Valid

    @NotNull(message = "the name is required")
    @NotEmpty(message = "the name should no be empty")
    @NotBlank(message = "the name should no be blank")
    @Pattern(regexp = "^[a-zA-Z0-9\\s&?]{3,20}$", message = "this name is invalid")
    @Size(min = 3, max = 20, message = "the name should be between 3 and 20 character")
    private String name;

    @NotNull(message = "the image is required")
    @FileType()
    private MultipartFile image;
}
