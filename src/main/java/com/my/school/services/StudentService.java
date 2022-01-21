package com.my.school.services;

import java.util.List;

import com.my.school.entities.Student;

public interface StudentService {

    public Student getStudentById(int id);

    public Student deleteStudentById(int id);

    public List<Student> getStudents();

    public Student addStudent(Student student);

    public Student updateStudent(Student student);
}
