package com.shoes.backend.DTO.UserDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {

    @Valid

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "the email was invalid")
    @NotEmpty(message = "the email ne should be empty")
    @NotNull(message = "the email ne should be null")
    @NotBlank(message = "the email is required")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must have at least 8 chars, 1 letter, 1 number")
    @NotEmpty(message = "the password ne should be empty")
    @NotNull(message = "the password ne should be null")
    @NotBlank(message = "the password is required")
    private String password;
}
