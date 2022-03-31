package com.my.school.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int sid;

    private String name;
}
