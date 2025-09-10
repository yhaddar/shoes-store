package com.shoes.backend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shoes.backend.Entity.Base.Item;
import com.shoes.backend.Enum.*;
import jakarta.persistence.*;
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
@Table(name = "shoes")
@Entity
public class Shoes extends Item {

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull(message = "this field no should be null")
    private Brand brand;

    @Column(unique = false, nullable = false)
    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Size(min = 3, max = 20, message = "the model should be between 3 and 20 character")
    private String model;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "this field no should be null")
    private Category category;

    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    private List<Integer> size;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    private String color;

    @NotNull(message = "this field no should be null")
    @Enumerated(EnumType.STRING)
    private Materiel materiel;

    @Min(0)
    private double price;

    @Min(0)
    @Max(100)
    @NotNull(message = "this field no should be null")
    private double discount = 0;

    @Min(0)
    @NotNull(message = "this field no should be null")
    private int stock;

    @Column(unique = true)
    @Size(max = 9, message = "the code must be 8 character")
    @NotNull(message = "this field no should be null")
    private String code;

    @NotNull(message = "this field no should be null")
    @Enumerated(EnumType.STRING)
    private Width width;

    @NotNull(message = "this field no should be null")
    private boolean water_resistant = false;

    @NotNull(message = "this field no should be null")
    private boolean breathable = false;

    @NotNull(message = "this field no should be null")
    @Enumerated(EnumType.STRING)
    private PatternEnum pattern;

    @NotNull(message = "this field no should be null")
    @Enumerated(EnumType.STRING)
    private ClosureType closure_type = ClosureType.LACE;

    @NotNull(message = "this field no should be null")
    @Enumerated(EnumType.STRING)
    private Shape toe_shape;

    @NotNull(message = "this field no should be null")
    private double weight;

    @NotNull(message = "this field no should be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate release_date;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    private String origin;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    @Size(min = 8, max = 255, message = "the description must be between 8 and 255 character")
    private String description;

    @OneToMany(mappedBy = "shoes", cascade = CascadeType.ALL)
    private List<ShoesSecondary> shoes_secondary;


}
