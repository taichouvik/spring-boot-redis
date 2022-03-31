package com.my.school.services.impl;

import java.util.List;

import com.my.school.entities.Student;
import com.my.school.repositories.StudentRepo;
import com.my.school.services.StudentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findBySid(id).orElse(new Student());
    }

    @Override
    public Student deleteStudentById(int id) {
        Student student = getStudentById(id);
        studentRepo.delete(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        Student newStudent = getStudentById(student.getSid());
        modelMapper.map(student, newStudent);
        return newStudent;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();
            return studentList;
    }

    @Override
    public Student addStudent(Student student) {
        Student newStudent = new Student();
       
        return studentRepo.save(newStudent);
    }

}
