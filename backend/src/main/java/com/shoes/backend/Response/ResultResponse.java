package com.shoes.backend.Response;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor
public class ResultResponse {

    public static ResponseEntity<Object> result(Object message, HttpStatus status){
        return ResponseEntity.status(status).body(message);
    }

}
