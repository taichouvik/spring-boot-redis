package com.my.school.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.my.school.utils.annotations.ValidMobile;
import com.my.school.utils.errors.Err;

import lombok.Data;

@Entity
@Data
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;

    @NotBlank(message = Err.STUD_NO_NAME )
    @Size(max = 100)
    private String name;

    @Id
    @NotBlank(message = Err.STUD_NO_EMAILID)
    @Email(message = Err.STUD_BAD_EMAILID)
    private String email;

    @ValidMobile
    private String mob;

    @NotNull(message = Err.STUD_NO_ADDR)
    @Valid
    private Address address;
}
