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
public class ShoesForBrandResponse {
    private UUID id;
    private String name;
    private String image;
    private String color;
    private double price;
    private double discount = 0;
    private int stock;
    @JsonFormat(pattern = "yyyy")
    private LocalDate release_date;
    private String description;
    private List<ShoesSecondaryResponse> shoesSecondary;

    public static ShoesForBrandResponse toJSON(Shoes shoes){
        return ShoesForBrandResponse.builder()
                .id(shoes.getId())
                .name(shoes.getName())
                .image("http://localhost:8080/shoes/"+ shoes.getImage())
                .color(shoes.getColor())
                .price(shoes.getPrice())
                .discount(shoes.getDiscount())
                .stock(shoes.getStock())
                .release_date(shoes.getRelease_date())
                .description(shoes.getDescription())
                .shoesSecondary(shoes.getShoes_secondary().stream().map(ShoesSecondaryResponse::toJSON).toList())
                .build();
    }

}
