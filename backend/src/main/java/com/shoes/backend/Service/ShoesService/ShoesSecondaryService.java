package com.shoes.backend.Service.ShoesService;

import com.shoes.backend.DTO.ShoesDTO.CreateShoesSecondaryDTO;
import com.shoes.backend.DTO.ShoesDTO.UpdateShoesSecondaryDTO;
import com.shoes.backend.Entity.ShoesSecondary;
import com.shoes.backend.Helper.Image;
import com.shoes.backend.Repository.ShoesSecondaryRepository;
import com.shoes.backend.Response.ResultResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ShoesSecondaryService {

    @Autowired
    private ShoesSecondaryRepository shoesSecondaryRepository;
    private Image image = new Image();

    @Async
    @Transactional(rollbackOn = Throwable.class)
    @CacheEvict(value = "SHOES_SERVICE", key = "'all_shoes'")
    public CompletableFuture<ResponseEntity<Object>> store(@Valid CreateShoesSecondaryDTO createShoesSecondaryDTO) throws IOException {

        String image = this.image.uploadImage(createShoesSecondaryDTO.getImage(), "shoes_secondary");

        if(image == null)
            throw new IOException("Image not found");

        ShoesSecondary shoesSecondary = new ShoesSecondary();
        shoesSecondary.setImage(image);
        shoesSecondary.setColor(createShoesSecondaryDTO.getColor());
        shoesSecondary.setSize(createShoesSecondaryDTO.getSize());
        shoesSecondary.setShoes(createShoesSecondaryDTO.getShoes());

        this.shoesSecondaryRepository.save(shoesSecondary);

        return CompletableFuture.completedFuture(new ResponseEntity<>("this shoes secondary added with success", HttpStatus.OK));
    }

    @Async
    @Transactional(rollbackOn = Throwable.class)
    @CacheEvict(value = "SHOES_SERVICE")
    public CompletableFuture<ResponseEntity<Object>> update(@Valid UpdateShoesSecondaryDTO updateShoesSecondaryDTO, UUID id) throws IOException {

        ShoesSecondary shoesSecondary = this.shoesSecondaryRepository.findById(id).orElseThrow(() -> new RuntimeException("shoes secondary not found"));

        if(updateShoesSecondaryDTO.getImage() != null){
            Object image = this.image.updateImage(updateShoesSecondaryDTO.getImage(), "shoes_secondary", shoesSecondary.getImage());

            if(image instanceof Boolean)
                throw new IOException("Image not found");

            shoesSecondary.setImage(image.toString());
        }

        if(!updateShoesSecondaryDTO.getColor().isEmpty())
            shoesSecondary.setColor(updateShoesSecondaryDTO.getColor());

        if(!updateShoesSecondaryDTO.getSize().isEmpty())
            shoesSecondary.setSize(updateShoesSecondaryDTO.getSize());

        this.shoesSecondaryRepository.save(shoesSecondary);

        return CompletableFuture.completedFuture(ResultResponse.result("this shoes secondary was updated", HttpStatus.OK));
    }
}
