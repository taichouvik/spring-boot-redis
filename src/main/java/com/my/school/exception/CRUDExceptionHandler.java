package com.my.school.exception;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CRUDExceptionHandler {

    @ExceptionHandler(value = { RecordNotFoundException.class })
    public ResponseEntity<Response> recordNotFoundHandler(RecordNotFoundException exception) {
        HttpHeaders headers = new HttpHeaders();
        Response response = new Response(Arrays.asList(exception.getMessage()));
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Response> recordNotFoundHandler(MethodArgumentNotValidException exception) {
        HttpHeaders headers = new HttpHeaders();
        Response response = new Response(exception.getFieldErrors().stream().map(fieldError -> fieldError.toString()).collect(Collectors.toList()));
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers,
                HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
