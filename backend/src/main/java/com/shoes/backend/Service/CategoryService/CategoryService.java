package com.shoes.backend.Service.CategoryService;

import com.shoes.backend.DTO.CategoryDTO.CreateCategoryDTO;
import com.shoes.backend.DTO.CategoryDTO.UpdateCategoryDTO;
import com.shoes.backend.Entity.Category;
import com.shoes.backend.Exception.NotFoundException;
import com.shoes.backend.Helper.Image;
import com.shoes.backend.Repository.CategoryRepository;
import com.shoes.backend.Response.CategoryResponse;
import com.shoes.backend.Response.ResultResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryCaching categoryCaching;
    private Image image = new Image();

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    public CompletableFuture<ResponseEntity<Object>> index() {
        List<CategoryResponse> category = this.categoryCaching.index(this.categoryRepository);

        if(category.isEmpty())
            throw new RuntimeException("category not found");

        return CompletableFuture.completedFuture(ResultResponse.result(category, HttpStatus.OK));
    }

    @Async
    @CacheEvict(value = "CATEGORIES_SERVICE", key = "'categories'")
    public CompletableFuture<ResponseEntity<Object>> store(CreateCategoryDTO createCategoryDTO) throws IOException {

        MultipartFile file = createCategoryDTO.getImage();

        String file_name = this.image.uploadImage(file, "categories");

        Category brand = new Category();
        brand.setName(createCategoryDTO.getName().toLowerCase());
        brand.setImage(file_name);
        this.categoryRepository.save(brand);

        return CompletableFuture.completedFuture(ResultResponse.result("the category add with success", HttpStatus.CREATED));
    }

    @Async
    @CacheEvict(value = "CATEGORIES_SERVICE", key = "'categories'")
    public CompletableFuture<ResponseEntity<Object>> update(UpdateCategoryDTO updateCategoryDTO, UUID id) throws IOException {

        try {

            Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("category not found"));

            if (updateCategoryDTO.getImage() != null) {

                MultipartFile file = updateCategoryDTO.getImage();

                Object updateImage = this.image.updateImage(file, "categories", category.getImage());


                try {
                    if (updateImage instanceof Boolean) {
                        throw new IOException("image not found");
                    } else {
                        category.setImage(updateImage.toString());
                    }

                } catch (IOException e) {
                    return CompletableFuture.completedFuture(ResultResponse.result(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }

            if (updateCategoryDTO.getName() != null) {
                category.setName(updateCategoryDTO.getName());
            }

            this.categoryRepository.save(category);

            return CompletableFuture.completedFuture(ResultResponse.result("the category update with success", HttpStatus.OK));

        } catch (RuntimeException e) {
            return CompletableFuture.completedFuture(ResultResponse.result(e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @Async
    @CacheEvict(value = "CATEGORIES_SERVICE", key = "'categories'")
    public CompletableFuture<ResponseEntity<Object>> delete(UUID id) throws IOException {

        try {
            Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("brand not found"));

            this.image.deleteImage("categories", category.getImage());
            this.categoryRepository.delete(category);

            return CompletableFuture.completedFuture(ResultResponse.result("this category was deleted", HttpStatus.OK));

        } catch (RuntimeException e) {
            return CompletableFuture.completedFuture(ResultResponse.result(e.getMessage(), HttpStatus.NOT_FOUND));
        }

    }

}
