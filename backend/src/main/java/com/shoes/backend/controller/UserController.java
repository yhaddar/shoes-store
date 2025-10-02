package com.shoes.backend.controller;

import com.shoes.backend.DTO.UserDTO.CodeActivateDTO;
import com.shoes.backend.DTO.UserDTO.UserLoginDTO;
import com.shoes.backend.DTO.UserDTO.UserRegisterDTO;
import com.shoes.backend.Service.UserService.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CompletableFuture<ResponseEntity<Object>> login(@RequestBody @Valid UserLoginDTO userDTO) throws Exception {
        return this.userService.login(userDTO);
    }

    @PostMapping("/register")
    public CompletableFuture<ResponseEntity<String>> register(@RequestBody @Valid UserRegisterDTO userDTO){
        return this.userService.register(userDTO);
    }

    @PatchMapping("/activate-account")
    public CompletableFuture<ResponseEntity<String>> activateAccount(@RequestBody @Valid CodeActivateDTO codeActivate, @PathParam("email")  String email){
        return this.userService.activateAccount(codeActivate, email);
    }

}
