package com.shoes.backend.controller;

import com.shoes.backend.DTO.BrandDTO.CreateBrandDTO;
import com.shoes.backend.DTO.BrandDTO.UpdateBrandDTO;
import com.shoes.backend.Service.BrandService.BrandService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping
    public CompletableFuture<ResponseEntity<Object>> index(){
        return this.brandService.index();
    }

    @PostMapping("/add")
    public CompletableFuture<ResponseEntity<Object>> store(@ModelAttribute @Valid CreateBrandDTO createBrandDTO) throws IOException {
        return this.brandService.store(createBrandDTO);
    }

    @PatchMapping("/update")
    public CompletableFuture<ResponseEntity<Object>> update(@ModelAttribute @Valid UpdateBrandDTO updateBrandDTO, @PathParam("id") UUID id) throws  IOException {
        return this.brandService.update(updateBrandDTO, id);
    }

    @DeleteMapping("/delete")
    public CompletableFuture<ResponseEntity<Object>> delete(@PathParam("id") UUID id) throws IOException {
        return this.brandService.delete(id);
    }

    @GetMapping("/with-shoes")
    public CompletableFuture<ResponseEntity<Object>> brandsWithShoes() {
        return this.brandService.brandsWithShoes();
    }
}
