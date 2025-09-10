package com.shoes.backend.Service.CategoryService;

import com.shoes.backend.Repository.CategoryRepository;
import com.shoes.backend.Response.CategoryResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryCaching {
    @Cacheable(value = "CATEGORIES_SERVICE", key = "'categories'")
    public List<CategoryResponse> index(CategoryRepository categoryRepository) {
        return categoryRepository.findAll().stream().map(CategoryResponse::toJSON).toList();
    }
}
