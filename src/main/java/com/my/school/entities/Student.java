package com.my.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.my.school.constants.ErrorConstants;
import com.my.school.validations.ValidMobile;

import lombok.Data;

@Entity
@Data
public class Student {

    @Positive
    @Column(unique = true)
    private int sid;

    @NotBlank(message = ErrorConstants.STUD_NO_NAME )
    @Size(max = 100)
    private String name;

    @Id
    @NotBlank(message = ErrorConstants.STUD_NO_EMAILID)
    @Email(message = ErrorConstants.STUD_BAD_EMAILID)
    private String email;

    @ValidMobile
    private String mob;

    @NotNull(message = ErrorConstants.STUD_NO_ADDR)
    @Valid
    private Address address;
}
