package com.satyadara.springexample.services;

import com.satyadara.springexample.models.Address;
import com.satyadara.springexample.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer register(String name, String address);
    Customer get(String uuid);
    List<Customer> fetch();
    Customer update(String name, List<Address> addresses, String id);
    String delete(String id);
}
