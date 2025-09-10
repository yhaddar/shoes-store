package com.shoes.backend.Entity.Base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class Item extends Base {
    @Column(unique = false, nullable = false)
    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Size(min = 3, max = 20, message = "the name should be between 3 and 20 character")
    private String name;

    @Column(unique = false, nullable = false)
    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    private String image;

}
