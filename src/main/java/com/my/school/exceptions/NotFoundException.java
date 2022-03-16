package com.my.school.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String id, String msg) {
        super(String.format("%s - %s", id, msg));
    }
}
