package com.my.school.services.impl;

import java.util.List;

import com.my.school.entities.Student;
import com.my.school.repositories.StudentRepo;
import com.my.school.services.StudentService;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    ModelMapper modelMapper;
    
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    @Cacheable(value = "student", key = "#id", unless = "#result == null")
    public Student getStudentById(int id) {
        return studentRepo.findBySid(id).orElse(null);
    }

    @Override
    @CacheEvict(value = "student", key = "#id")
    public Student deleteStudentById(int id) {
        Student student = getStudentById(id);
        if(student == null)
            return student;
        studentRepo.delete(student);
        return student;
    }

    @Override
    @CachePut(value = "student", key = "#student.sid")
    public Student updateStudent(Student student) {
        Student oldStudent = getStudentById(student.getSid());
        modelMapper.map(student, oldStudent);
        return oldStudent;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();
            return studentList;
    }

    @Override
    public Student addStudent(Student student) {
        if(getStudentById(student.getSid()) != null)
            return null;
        log.info(student.toString());
        return studentRepo.save(student);
    }

}
