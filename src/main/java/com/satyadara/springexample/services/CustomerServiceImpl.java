package com.satyadara.springexample.services;

import com.satyadara.springexample.models.Customer;
import com.satyadara.springexample.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    @Override
    public Customer register(String name, String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setId(UUID.randomUUID().toString());

        return customerRespository.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer get(String uuid) {
        return customerRespository.findOne(uuid);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> fetch() {
        return customerRespository.findAll();
    }

    @Override
    public Customer update(String name, String address, String id) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setId(id);

        return customerRespository.save(customer);
    }

    @Override
    public String delete(String id) {
        customerRespository.delete(id);
        return "mantap";
    }


}
