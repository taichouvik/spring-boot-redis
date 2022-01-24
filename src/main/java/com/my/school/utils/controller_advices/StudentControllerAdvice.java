package com.my.school.utils.controller_advices;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.my.school.entities.Response;
import com.my.school.utils.exceptions.NotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentControllerAdvice {

    @ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<Response> recordNotFoundHandler(NotFoundException exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Response response = new Response(Arrays.asList(exception.getMessage()));
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Response> recordNotFoundHandler(MethodArgumentNotValidException exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Response response = new Response(exception.getFieldErrors().stream()
                .map(err -> String.format("'%s' - %s", err.getRejectedValue(), err.getDefaultMessage()))
                .collect(Collectors.toList()));
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
