package com.shoes.backend.controller;

import com.shoes.backend.DTO.ShoesDTO.CreateShoesSecondaryDTO;
import com.shoes.backend.DTO.ShoesDTO.UpdateShoesSecondaryDTO;
import com.shoes.backend.Service.ShoesService.ShoesSecondaryService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/shoes-secondary")
public class ShoesSecondaryController {
    @Autowired
    private ShoesSecondaryService shoesSecondaryService;

    @PostMapping("/add")
    public CompletableFuture<ResponseEntity<Object>> store(@ModelAttribute @Valid CreateShoesSecondaryDTO createShoesSecondaryDTO) throws IOException {
        return this.shoesSecondaryService.store(createShoesSecondaryDTO);
    }

    @PatchMapping("update")
    public CompletableFuture<ResponseEntity<Object>> update(@ModelAttribute @Valid UpdateShoesSecondaryDTO updateShoesSecondaryDTO, @PathParam("id") UUID id) throws IOException{
        return this.shoesSecondaryService.update(updateShoesSecondaryDTO, id);
    }

}
