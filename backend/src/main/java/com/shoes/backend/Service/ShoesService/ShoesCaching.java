package com.shoes.backend.Service.ShoesService;

import com.shoes.backend.Entity.Shoes;
import com.shoes.backend.Repository.ShoesRepository;
import com.shoes.backend.Response.ShoesResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoesCaching {

    @Cacheable(value = "SHOES_SERVICE", key = "'all_shoes'")
    public List<ShoesResponse> index(ShoesRepository shoesRepository) {
        return shoesRepository.findAll().stream().map(ShoesResponse::toJSON).toList();
    }

    @Cacheable(value = "SHOES_SERVICE", key = "'search_'+#q")
    public List<ShoesResponse> search(ShoesRepository shoesRepository, String q) {
        return shoesRepository.searchByName(q).stream().map(ShoesResponse::toJSON).toList();
    }

    @Cacheable(value = "SHOES_SERVICE", key = "'filter-by-'+#f")
    public List<ShoesResponse> filter(ShoesRepository shoesRepository, String f) {
        return shoesRepository.filterByBrandOrCategory(f).stream().map(ShoesResponse::toJSON).toList();
    }

    @Cacheable(value = "SHOES_SERVICE", key = "'show_shoes_with_id_'+#id", unless = "#result == null")
    public Optional<Shoes> show(ShoesRepository shoesRepository, UUID id) {
         return shoesRepository.findById(id);
    }
}
