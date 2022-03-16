package com.my.school.services.impl;

import java.util.List;

import com.my.school.constants.ErrorConstants;
import com.my.school.entities.Student;
import com.my.school.exceptions.NotFoundException;
import com.my.school.repositories.StudentRepo;
import com.my.school.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentRepo.findBySid(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id), ErrorConstants.STUD_NOT_FOUND));
        return student;
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
        newStudent.setSid(student.getSid());
        newStudent.setName(student.getName());
        newStudent.setEmail(student.getEmail());
        newStudent.setMob(student.getMob());
        newStudent.setAddress(student.getAddress());
        return newStudent;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();
        if (studentList.isEmpty())
            throw new NotFoundException(ErrorConstants.STUD_NOT_FOUND);
        else
            return studentList;
    }

    @Override
    public Student addStudent(Student student) {
        Student newStudent = new Student();
        newStudent.setSid(student.getSid());
        newStudent.setName(student.getName());
        newStudent.setEmail(student.getEmail());
        newStudent.setMob(student.getMob());
        newStudent.setAddress(student.getAddress());
        return studentRepo.save(newStudent);
    }

}
