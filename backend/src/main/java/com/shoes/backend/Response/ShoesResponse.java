package com.shoes.backend.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shoes.backend.Entity.Brand;
import com.shoes.backend.Entity.Category;
import com.shoes.backend.Entity.Shoes;
import com.shoes.backend.Entity.ShoesSecondary;
import com.shoes.backend.Enum.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoesResponse {
    private UUID id;
    private String name;
    private String image;
    private BrandResponse brand;
    private String model;
    private CategoryResponse category;
    private List<Integer> size;
    private String color;
    private Materiel materiel;
    private double price;
    private double discount = 0;
    private int stock;
    private String code;
    private Width width;
    private boolean water_resistant;
    private boolean breathable = false;
    private PatternEnum pattern;
    private ClosureType closure_type;
    private Shape toe_shape;
    private double weight;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate release_date;
    private String origin;
    private String description;
    @JsonFormat(pattern = "dd-mm-yyyy",  shape = JsonFormat.Shape.STRING)
    private LocalDateTime created_at;
    @JsonFormat(pattern = "dd-mm-yyyy",  shape = JsonFormat.Shape.STRING)
    private LocalDateTime updated_at;
    private List<ShoesSecondaryResponse> shoesSecondary;

    public static ShoesResponse toJSON(Shoes shoes){
        return ShoesResponse.builder()
                .id(shoes.getId())
                .name(shoes.getName())
                .image("http://localhost:8080/shoes/"+ shoes.getImage())
                .brand(BrandResponse.toJSON(shoes.getBrand()))
                .model(shoes.getModel())
                .category(CategoryResponse.toJSON(shoes.getCategory()))
                .size(shoes.getSize())
                .color(shoes.getColor())
                .materiel(shoes.getMateriel())
                .price(shoes.getPrice())
                .discount(shoes.getDiscount())
                .stock(shoes.getStock())
                .code(shoes.getCode())
                .width(shoes.getWidth())
                .water_resistant(shoes.isWater_resistant())
                .breathable(shoes.isBreathable())
                .pattern(shoes.getPattern())
                .closure_type(shoes.getClosure_type())
                .toe_shape(shoes.getToe_shape())
                .weight(shoes.getWeight())
                .release_date(shoes.getRelease_date())
                .origin(shoes.getOrigin())
                .description(shoes.getDescription())
                .shoesSecondary(shoes.getShoes_secondary().stream().map(ShoesSecondaryResponse::toJSON).toList())
                .created_at(shoes.getCreated_at())
                .updated_at(shoes.getUpdated_at())
                .build();
    }

}
