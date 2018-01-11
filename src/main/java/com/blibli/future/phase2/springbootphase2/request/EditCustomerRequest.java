package com.blibli.future.phase2.springbootphase2.request;

import org.hibernate.validator.constraints.NotBlank;

public class EditCustomerRequest {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
