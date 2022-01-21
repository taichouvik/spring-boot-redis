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

import com.my.school.validations.ValidMobile;
import lombok.Data;

@Entity
@Data
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "{STUD_ERR.NO_NAME}")
    @Size(max = 100)
    private String name;

    @Id
    @NotBlank(message = "{STUD_ERR.NO_EMAIL_ID}")
    @Email(message = "{STUD_ERR.BAD_EMAIL_ID}")
    private String email;

    @ValidMobile
    private String mob;

    @NotNull(message = "{STUD_ERR.NO_ADDR}")
    @Valid
    private Address address;
}
