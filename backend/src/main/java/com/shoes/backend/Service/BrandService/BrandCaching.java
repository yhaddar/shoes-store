package com.shoes.backend.Service.BrandService;

import com.shoes.backend.Repository.BrandRepository;
import com.shoes.backend.Response.BrandResponse;
import com.shoes.backend.Response.BrandWithShoesResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandCaching {

    @Cacheable(value = "BRAND_SERVICE", key = "'brands'")
    public List<BrandResponse> index(BrandRepository brandRepository){
        return brandRepository.findAll().stream().map(BrandResponse::toJSON).toList();
    }

    @Cacheable(value = "BRAND_SERVICE", key = "'brand-with-shoes'")
    public List<BrandWithShoesResponse> brandsWithShoes(BrandRepository brandRepository) {
        return brandRepository.findAllWithShoes().stream().map(BrandWithShoesResponse::toJSON).toList();
    }
}
