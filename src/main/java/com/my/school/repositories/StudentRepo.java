package com.my.school.repositories;

import java.util.Optional;

import com.my.school.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findBySid(int id);
    
}
