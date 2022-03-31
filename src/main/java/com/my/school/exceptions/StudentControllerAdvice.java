package com.my.school.exceptions;

import com.my.school.entities.Response;

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
        Response response = new Response();
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Response> recordNotFoundHandler(MethodArgumentNotValidException exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Response response = new Response();
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
