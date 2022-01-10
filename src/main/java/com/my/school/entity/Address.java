package com.my.school.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Embeddable
@Data
public class Address {

    private String addrLine1;
    private String addrLine2;
    private String state;
    private String pin;
    private String country;
}
