package com.shoes.backend.DTO.ShoesDTO;

import com.shoes.backend.Annotation.BrandExist;
import com.shoes.backend.Annotation.CategoryExist;
import com.shoes.backend.DTO.BaseDTO.UpdateItemDTO;
import com.shoes.backend.Entity.Brand;
import com.shoes.backend.Entity.Category;
import com.shoes.backend.Enum.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateShoesDTO extends UpdateItemDTO {
    @Valid

    @BrandExist
    private Brand brand;

    @Pattern(regexp = "^[A-Za-z0-9][A-Za-z0-9\\s-_]{3,20}$", message = "this model is invalid")
    private String model;

    @CategoryExist
    private Category category;

    @Pattern(regexp = "^\\d{16,50}$", message = "the size must be number")
    private int size;

    @Pattern(regexp = "^#(?:[A-Fa-f0-9]{3}|[A-Fa-f0-9]{6})$", message = "this color must be a Hex format")
    private String color;

    private Materiel materiel;

    private double price;

    private double discount = 0;

    private int stock;

    @Pattern(regexp = "^[A-Z0-9]{8}$", message = "the code of this shoes is invalid")
    private String code;

    private Width width;

    private boolean water_resistant;

    private boolean breathable;

    private PatternEnum pattern;

    private ClosureType closure_type;

    private Shape toe_shape;

    private double weight;

    private Date release_date;

    @Pattern(regexp = "^[a-zA-Z\\s?]+$", message = "this origin is invalid")
    private String origin;

    @Pattern(regexp = "^.{8,255}$", message = "this description is invalid")
    private String description;
}
