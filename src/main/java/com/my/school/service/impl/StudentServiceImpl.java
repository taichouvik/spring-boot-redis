package com.my.school.service.impl;

import java.util.List;
import com.my.school.entity.Student;
import com.my.school.exception.StudentNotFoundException;
import com.my.school.repo.StudentRepo;
import com.my.school.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student getStudentById(int id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(String.valueOf(id)));
        return student;
    }

    @Override
    public Student deleteStudentById(int id) {
        List<Student> studentList = studentRepo.deleteStudentById(id);
        if (studentList.isEmpty())
            throw new StudentNotFoundException(String.valueOf(id));
        else
            return studentList.get(0);
    }

    @Override
    public Student updateStudent(Student student) {
        if (studentRepo.existsById(student.getId()))
            return studentRepo.save(student);
        else
            throw new StudentNotFoundException(String.valueOf(student.getId()));
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();
        if (studentList.isEmpty())
            throw new StudentNotFoundException("");
        else
            return studentList;
    }

    @Override
    public Student addStudent(Student student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setSection(student.getSection());
        newStudent.setStandard(student.getStandard());
        newStudent.setAddress(student.getAddress());
        return studentRepo.save(newStudent);
    }

}
