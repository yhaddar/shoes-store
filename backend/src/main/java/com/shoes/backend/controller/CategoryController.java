package com.shoes.backend.controller;

import com.shoes.backend.DTO.BrandDTO.UpdateBrandDTO;
import com.shoes.backend.DTO.CategoryDTO.CreateCategoryDTO;
import com.shoes.backend.DTO.CategoryDTO.UpdateCategoryDTO;
import com.shoes.backend.Service.CategoryService.CategoryService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public CompletableFuture<ResponseEntity<Object>> getCategory() {
        return this.categoryService.index();
    }

    @PostMapping("/add")
    public CompletableFuture<ResponseEntity<Object>> createCategory(@ModelAttribute @Valid CreateCategoryDTO createCategoryDTO) throws IOException {
        return this.categoryService.store(createCategoryDTO);
    }

    @PatchMapping("/update")
    public CompletableFuture<ResponseEntity<Object>> update(@ModelAttribute @Valid UpdateCategoryDTO updateCategoryDTO, @PathParam("id") UUID id) throws  IOException {
        return this.categoryService.update(updateCategoryDTO, id);
    }

    @DeleteMapping("/delete")
    public CompletableFuture<ResponseEntity<Object>> delete(@PathParam("id") UUID id) throws IOException {
        return this.categoryService.delete(id);
    }

}
