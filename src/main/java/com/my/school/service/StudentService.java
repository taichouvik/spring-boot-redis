package com.my.school.service;

import java.util.List;
import com.my.school.entity.Student;

public interface StudentService {
    public Student getStudentById(int id);

    public Student deleteStudentById(int id);

    public List<Student> getStudents();

    public Student addStudent(Student student);

    public Student updateStudent(Student student);
}
