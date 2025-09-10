package com.shoes.backend.controller;

import com.shoes.backend.DTO.ShoesDTO.CreateShoesDTO;
import com.shoes.backend.DTO.ShoesDTO.UpdateShoesDTO;
import com.shoes.backend.Service.ShoesService.ShoesService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/shoes")
public class ShoesController {
    @Autowired
    private ShoesService shoesService;

    @GetMapping
    public CompletableFuture<ResponseEntity<Object>> index(){
        return this.shoesService.index();
    }

    @PostMapping("/add")
    public CompletableFuture<ResponseEntity<Object>> store(@ModelAttribute @Valid CreateShoesDTO createShoesDTO) throws IOException  {
        return this.shoesService.store(createShoesDTO);
    }

    @PatchMapping("/update")
    public CompletableFuture<ResponseEntity<Object>> update(@ModelAttribute @Valid UpdateShoesDTO updateShoesDTO, @PathParam("id") UUID id) throws IOException {
        return this.shoesService.update(updateShoesDTO, id);
    }

    @DeleteMapping("/delete")
    public CompletableFuture<ResponseEntity<Object>> delete(@PathParam("id") UUID id) throws IOException{
        return this.shoesService.delete(id);
    }

    @GetMapping("/detail")
    public CompletableFuture<ResponseEntity<Object>> show(@PathParam("id") UUID id){
        return this.shoesService.show(id);
    }

    @GetMapping("/search")
    public CompletableFuture<ResponseEntity<Object>> search(@PathParam("q") String q){
        return this.shoesService.search(q);
    }

    @GetMapping("/filter")
    public CompletableFuture<ResponseEntity<Object>> filter(@PathParam("f") String f){
        return this.shoesService.filter(f);
    }



}
