package com.gabrielteodoro.trackassets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,String>> handleRunTimeException(RuntimeException e){
        Map<String,String> resp = Map.of("error",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,String>> handleRunTimeException(HttpMessageNotReadableException e){
        Map<String,String> resp = Map.of("error",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
}
