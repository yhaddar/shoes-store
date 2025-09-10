package com.shoes.backend.Response;

import com.shoes.backend.Entity.Brand;
import com.shoes.backend.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryResponse {
    private String id;
    private String name;
    private String image;

    public static CategoryResponse toJSON(Category category){
        return CategoryResponse.builder()
                .id(category.getId().toString())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }
}
