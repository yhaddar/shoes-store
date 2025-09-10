package com.shoes.backend.DTO.BaseDTO;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class UpdateItemDTO {
    @Pattern(regexp = "^[a-zA-Z\\s&?]{3,20}$", message = "this name is invalid")
    private String name;
    private MultipartFile image;
}
