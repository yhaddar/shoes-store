package com.shoes.backend.DTO.ShoesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shoes.backend.Annotation.BrandExist;
import com.shoes.backend.Annotation.CategoryExist;
import com.shoes.backend.Annotation.SizeAnnotation;
import com.shoes.backend.DTO.BaseDTO.CreateItemDTO;
import com.shoes.backend.Entity.Brand;
import com.shoes.backend.Entity.Category;
import com.shoes.backend.Enum.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateShoesDTO extends CreateItemDTO {

    @Valid

    @NotNull(message = "this field no should be null")
    @BrandExist
    private Brand brand;

    @NotBlank(message = "this field no should be blank")
    @NotNull(message = "this field no should be null")
    @Size(min = 3, max = 20, message = "the model should be between 3 and 20 character")
    @Pattern(regexp = "^[A-Za-z0-9][A-Za-z0-9\\s-_]{3,20}$", message = "this model is invalid")
    private String model;

    @NotNull(message = "this field no should be null")
    @CategoryExist
    private Category category;

    @NotNull(message = "this field no should be null")
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @SizeAnnotation
    @NotEmpty(message = "this field no should be empty")
    private List<Integer> size;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Pattern(regexp = "^#(?:[A-Fa-f0-9]{3}|[A-Fa-f0-9]{6})$", message = "this color must be a Hex format")
    private String color;

    @NotNull(message = "this field no should be null")
    private Materiel materiel;

    @Min(value = 0, message = "the price must be greater than or equal 0")
    private double price;

    @Min(0)
    @Max(100)
    @NotNull(message = "this field no should be null")
    private double discount = 0;

    @Min(value = 0, message = "the stock must be greater than or equal 0")
    @NotNull(message = "this field no should be null")
    private int stock;

    @Size(max = 9, message = "the code must be 9 character")
    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{3}-[0-9]{3}$", message = "the code of this shoes is invalid")
    private String code;

    @NotNull(message = "this field no should be null")
    private Width width;

    @NotNull(message = "this field no should be null")
    private boolean water_resistant = false;

    @NotNull(message = "this field no should be null")
    private boolean breathable = false;

    @NotNull(message = "this field no should be null")
    private PatternEnum pattern;

    @NotNull(message = "this field no should be null")
    private ClosureType closure_type;

    @NotNull(message = "this field no should be null")
    private Shape toe_shape;

    @NotNull(message = "this field no should be null")
    private double weight;

    @NotNull(message = "this field no should be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate release_date;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Pattern(regexp = "^[a-zA-Z\\s?]+$", message = "this origin is invalid")
    private String origin;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Size(min = 8, max = 255, message = "the description must be between 8 and 255 character")
    @Pattern(regexp = "^.{8,255}$", message = "this description is invalid")
    private String description;

}
