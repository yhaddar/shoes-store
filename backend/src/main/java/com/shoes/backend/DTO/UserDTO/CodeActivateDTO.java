package com.shoes.backend.DTO.UserDTO;

import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodeActivateDTO {
    @Digits(integer = 4, fraction = 0)
    private Integer code_activation;
}
