package com.my.school.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.my.school.validations.ValidPin;

import lombok.Data;

@Embeddable
@Data
public class Address {

    @NotBlank(message = "{ADDR_ERR.NO_ADDRL1}")
    private String addrLine1;

    private String addrLine2;

    @NotBlank(message = "{ADDR_ERR.NO_CITY}")
    private String city;

    @NotNull(message = "{ADDR_ERR.NO_PIN}")
    @ValidPin
    private String pin;

    @NotBlank(message = "{ADDR_ERR.NO_STATE}")
    private String state;

    @NotBlank(message = "{ADDR_ERR.NO_COUNTRY}")
    private String country;
}
