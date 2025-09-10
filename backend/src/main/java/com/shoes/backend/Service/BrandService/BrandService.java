package com.shoes.backend.Service.BrandService;

import com.shoes.backend.DTO.BrandDTO.CreateBrandDTO;
import com.shoes.backend.DTO.BrandDTO.UpdateBrandDTO;
import com.shoes.backend.Entity.Brand;
import com.shoes.backend.Exception.NotFoundException;
import com.shoes.backend.Helper.Image;
import com.shoes.backend.Repository.BrandRepository;
import com.shoes.backend.Response.BrandResponse;
import com.shoes.backend.Response.BrandWithShoesResponse;
import com.shoes.backend.Response.ResultResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandCaching brandCaching;
    private Image image = new Image();

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    public CompletableFuture<ResponseEntity<Object>> index() {

        List<BrandResponse> brands = this.brandCaching.index(this.brandRepository);

        if (brands.isEmpty()) {
            throw new RuntimeException("no brands");
        } else {
            return CompletableFuture.completedFuture(ResultResponse.result(brands, HttpStatus.OK));
        }

    }

    @Async
    @CacheEvict(value = "BRAND_SERVICE", key = "'brands'")
    public CompletableFuture<ResponseEntity<Object>> store(CreateBrandDTO createBrandDTO) throws IOException {

        MultipartFile file = createBrandDTO.getImage();

        String file_name = this.image.uploadImage(file, "brands");

        Brand brand = new Brand();
        brand.setName(createBrandDTO.getName().toLowerCase());
        brand.setImage(file_name);
        this.brandRepository.save(brand);

        return CompletableFuture.completedFuture(ResultResponse.result("the brand add with success", HttpStatus.CREATED));
    }

    @Async
    @CacheEvict(value = "BRAND_SERVICE", key = "'brands'")
    public CompletableFuture<ResponseEntity<Object>> update(UpdateBrandDTO updateBrandDTO, UUID id) throws IOException {

        try {

            Brand brand = this.brandRepository.findById(id).orElseThrow(() -> new RuntimeException("brand not found"));

            if (updateBrandDTO.getImage() != null) {

                MultipartFile file = updateBrandDTO.getImage();

                Object updateImage = this.image.updateImage(file, "brands", brand.getImage());


                try {
                    if (updateImage instanceof Boolean) {
                        throw new IOException("image not found");
                    } else {
                        brand.setImage(updateImage.toString());
                    }

                } catch (IOException e) {
                    return CompletableFuture.completedFuture(ResultResponse.result(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }

            if (updateBrandDTO.getName() != null) {
                brand.setName(updateBrandDTO.getName());
            }

            this.brandRepository.save(brand);

            return CompletableFuture.completedFuture(ResultResponse.result("the brand update with success", HttpStatus.OK));

        } catch (RuntimeException e) {
            return CompletableFuture.completedFuture(ResultResponse.result(e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @Async
    @CacheEvict(value = "BRAND_SERVICE", key = "'brands'")
    public CompletableFuture<ResponseEntity<Object>> delete(UUID id) throws IOException {

        try {
            Brand brand = this.brandRepository.findById(id).orElseThrow(() -> new RuntimeException("brand not found"));

            this.image.deleteImage("brands", brand.getImage());
            this.brandRepository.delete(brand);

            return CompletableFuture.completedFuture(ResultResponse.result("this brand was deleted", HttpStatus.OK));

        } catch (RuntimeException e) {
            return CompletableFuture.completedFuture(ResultResponse.result(e.getMessage(), HttpStatus.NOT_FOUND));
        }

    }

    @Async
    @Transactional(rollbackOn = RuntimeException.class)
    public CompletableFuture<ResponseEntity<Object>> brandsWithShoes() {
        List<BrandWithShoesResponse> brandWithShoesResponse = this.brandCaching.brandsWithShoes(this.brandRepository);

        if(brandWithShoesResponse.isEmpty())
            throw new RuntimeException("the item will be added soon");

        return CompletableFuture.completedFuture(ResultResponse.result(brandWithShoesResponse, HttpStatus.OK));
    }
}
