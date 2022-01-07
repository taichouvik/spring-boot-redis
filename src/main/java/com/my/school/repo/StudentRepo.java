package com.my.school.repo;

import java.util.List;

import com.my.school.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> deleteStudentById(int id);
}
