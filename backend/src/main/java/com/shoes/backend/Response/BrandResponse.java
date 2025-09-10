package com.shoes.backend.Response;

import com.shoes.backend.Entity.Brand;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BrandResponse {
    private String id;
    private String name;
    private String image;

    public static BrandResponse toJSON(Brand brand){
        return BrandResponse.builder()
                .id(brand.getId().toString())
                .name(brand.getName())
                .image("brands/"+brand.getImage())
                .build();
    }

}
