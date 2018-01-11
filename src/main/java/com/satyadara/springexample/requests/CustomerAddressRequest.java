package com.satyadara.springexample.requests;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerAddressRequest {
    @NotBlank
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
