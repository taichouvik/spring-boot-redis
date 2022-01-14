package com.my.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.my.school.validation.ValidStudent;

import lombok.Data;

@Entity
@Data
@ValidStudent
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int standard;

    private char section;

    private String email;

    @NotNull
    private String mob;

    private Address address;
}
