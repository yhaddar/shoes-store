package com.shoes.backend.Response;

import com.shoes.backend.Entity.ShoesSecondary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoesSecondaryResponse {
    private String color;
    private String image;
    private List<Integer> size;

    public static ShoesSecondaryResponse toJSON(ShoesSecondary shoesSecondary){
        return ShoesSecondaryResponse.builder()
                .color(shoesSecondary.getColor())
                .size(shoesSecondary.getSize())
                .image("http://localhost:8080/shoes_secondary/"+shoesSecondary.getImage())
                .build();
    }

}
