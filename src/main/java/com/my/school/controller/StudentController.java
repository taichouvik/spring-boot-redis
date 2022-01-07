package com.my.school.controller;

import com.my.school.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.my.school.entity.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/student")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping(path = "/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping(path = "/student")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.addStudent(student));
    }

    @PutMapping(path = "/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.updateStudent(student));
    }

    @DeleteMapping(path = "/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok().body(studentService.deleteStudentById(id));
    }
}
