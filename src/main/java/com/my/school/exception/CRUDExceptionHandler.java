package com.my.school.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CRUDExceptionHandler {

    @ExceptionHandler(value = { RecordNotFoundException.class })
    public ResponseEntity<Response> recordNotFoundHandler(RecordNotFoundException exception) {
        HttpHeaders headers = new HttpHeaders();
        Response response = new Response(exception.getMessage());
        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
