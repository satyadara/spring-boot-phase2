package com.satyadara.springexample.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
    @Column(name = "id_address")
    private String id;

    @Column(name = "description")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Address() {
    }

    public Address(String id, String desc, Customer customer) {
        this.id = id;
        this.desc = desc;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
