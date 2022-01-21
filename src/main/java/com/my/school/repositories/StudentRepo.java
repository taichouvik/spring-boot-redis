package com.my.school.repos;

import java.util.List;

import com.my.school.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
