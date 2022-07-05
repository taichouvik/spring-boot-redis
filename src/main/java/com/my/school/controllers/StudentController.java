package com.my.school.controllers;

import com.my.school.entities.Student;
import com.my.school.services.StudentService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.getStudents());
    }
    
    @GetMapping(path = "/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.getStudentById(id));
    }

    @PostMapping(path = "/student")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.addStudent(student));
    }

    @PutMapping(path = "/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.updateStudent(student));
    }

    @DeleteMapping(path = "/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.deleteStudentById(id));
    }
}
