package com.shoes.backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class NotFoundException extends RuntimeException {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getMessage(RuntimeException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());

        return map;
    }
}
