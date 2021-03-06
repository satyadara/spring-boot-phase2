package com.satyadara.springexample.requests;

import com.satyadara.springexample.models.Address;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;

public class RegisterCustomerRequest {
    @Length(max = 50)
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    public RegisterCustomerRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
