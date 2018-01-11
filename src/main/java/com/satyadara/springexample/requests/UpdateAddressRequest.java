package com.satyadara.springexample.requests;

import com.satyadara.springexample.models.Address;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class UpdateAddressRequest {
    @Length(max = 50)
    @NotBlank
    private String name;

    @NotBlank
    private List<Address> address;

    public UpdateAddressRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
