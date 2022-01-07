package com.my.school.exception;

public class StudentNotFoundException extends RecordNotFoundException {

    public StudentNotFoundException(String msg) {
        super("studentId: " + msg + " - student not found");
    }

}
