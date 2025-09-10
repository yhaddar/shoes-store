package com.shoes.backend.Service.ShoesService;

import com.shoes.backend.DTO.ShoesDTO.CreateShoesDTO;
import com.shoes.backend.DTO.ShoesDTO.UpdateShoesDTO;
import com.shoes.backend.Entity.Shoes;
import com.shoes.backend.Exception.NotFoundException;
import com.shoes.backend.Helper.Image;
import com.shoes.backend.Repository.ShoesRepository;
import com.shoes.backend.Response.ResultResponse;
import com.shoes.backend.Response.ShoesResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ShoesService {

    @Autowired
    private ShoesRepository shoesRepository;
    @Autowired
    private ShoesCaching shoesCaching;
    private Image image = new Image();

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    public CompletableFuture<ResponseEntity<Object>> index() {

        List<ShoesResponse> shoes = this.shoesCaching.index(this.shoesRepository);

        if(shoes.isEmpty()){
            throw new RuntimeException("no shoes found");
        }

        return CompletableFuture.completedFuture(ResultResponse.result(shoes, HttpStatus.OK));

    }

    @Async
    @Transactional(rollbackOn = DataIntegrityViolationException.class)
    @CacheEvict(value = "SHOES_SERVICE", key = "'all_shoes'")
    public CompletableFuture<ResponseEntity<Object>> store(@Valid CreateShoesDTO createShoesDTO) throws IOException {

        MultipartFile file = createShoesDTO.getImage();

        if(this.shoesRepository.existsByCode(createShoesDTO.getCode()))
            throw new DataIntegrityViolationException("reference already exists");

        String file_name = this.image.uploadImage(file, "shoes");

        Shoes shoes = new Shoes();
        shoes.setName(createShoesDTO.getName().toLowerCase());
        shoes.setBrand(createShoesDTO.getBrand());
        shoes.setModel(createShoesDTO.getModel().toLowerCase());
        shoes.setCategory(createShoesDTO.getCategory());
        shoes.setImage(file_name);
        shoes.setSize(createShoesDTO.getSize().stream().toList());
        shoes.setColor(createShoesDTO.getColor());
        shoes.setMateriel(createShoesDTO.getMateriel());
        shoes.setPrice(createShoesDTO.getPrice());
        shoes.setDiscount(createShoesDTO.getDiscount());
        shoes.setStock(createShoesDTO.getStock());
        shoes.setCode(createShoesDTO.getCode().toUpperCase());
        shoes.setWidth(createShoesDTO.getWidth());
        shoes.setWater_resistant(createShoesDTO.isWater_resistant());
        shoes.setBreathable(createShoesDTO.isBreathable());
        shoes.setPattern(createShoesDTO.getPattern());
        shoes.setClosure_type(createShoesDTO.getClosure_type());
        shoes.setToe_shape(createShoesDTO.getToe_shape());
        shoes.setWeight(createShoesDTO.getWeight());
        shoes.setRelease_date(createShoesDTO.getRelease_date());
        shoes.setOrigin(createShoesDTO.getOrigin().toLowerCase());
        shoes.setDescription(createShoesDTO.getDescription().toLowerCase());

        this.shoesRepository.save(shoes);

        return CompletableFuture.completedFuture(ResultResponse.result("the " + createShoesDTO.getName() + " was created", HttpStatus.CREATED));
    }

    public CompletableFuture<ResponseEntity<Object>> update(@Valid UpdateShoesDTO updateShoesDTO, UUID id) {
        return null;
    }

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    @CacheEvict(value = "SHOES_SERVICE", key = "'all_shoes'")
    public CompletableFuture<ResponseEntity<Object>> delete(UUID id) throws IOException {

        Shoes shoes = this.shoesRepository.findById(id).orElseThrow(() -> new RuntimeException("no shoes found"));

        this.image.deleteImage("shoes", shoes.getImage());
        this.shoesRepository.delete(shoes);

        return CompletableFuture.completedFuture(ResultResponse.result("the " + shoes.getName() + " was deleted", HttpStatus.OK));
    }

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    public CompletableFuture<ResponseEntity<Object>> search(String q) {

        List<ShoesResponse> shoes = this.shoesCaching.search(this.shoesRepository, q);

        if(shoes.isEmpty()){
            throw new RuntimeException("no shoes found");
        }

        return CompletableFuture.completedFuture(ResultResponse.result(shoes, HttpStatus.OK));
    }

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    public CompletableFuture<ResponseEntity<Object>> filter(String f) {
        List<ShoesResponse> shoes = this.shoesCaching.filter(this.shoesRepository, f);

        if(shoes.isEmpty()){
            throw new RuntimeException("no shoes found");
        }

        return CompletableFuture.completedFuture(ResultResponse.result(shoes, HttpStatus.OK));
    }

    @Async
    @Transactional(rollbackOn = NotFoundException.class)
    public CompletableFuture<ResponseEntity<Object>> show(UUID id) {

        Optional<Shoes> shoes = this.shoesCaching.show(shoesRepository, id);

        if (shoes.isEmpty()) {
            throw new RuntimeException("no shoes found");
        }
        return CompletableFuture.completedFuture(ResultResponse.result(shoes, HttpStatus.OK));

    }
}
