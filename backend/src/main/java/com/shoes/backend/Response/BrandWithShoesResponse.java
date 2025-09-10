package com.shoes.backend.Response;

import com.shoes.backend.Entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BrandWithShoesResponse {
    private String brand;
    private ShoesForBrandResponse shoes;

    public static BrandWithShoesResponse toJSON(Brand brand){
        return BrandWithShoesResponse.builder()
                .brand(brand.getName())
                .shoes(brand.getShoes().stream().map(ShoesForBrandResponse::toJSON).toList().getFirst())
                .build();
    }


}
