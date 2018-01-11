package com.satyadara.springexample.services;

import com.satyadara.springexample.models.Address;
import com.satyadara.springexample.models.Customer;
import com.satyadara.springexample.repositories.AddressRepository;
import com.satyadara.springexample.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Customer register(String name, String address) {
        Customer customer = new Customer();
        Address address1 = new Address();
        List<Address> list = new ArrayList<>();

        //set address
        address1.setId(UUID.randomUUID().toString());
        address1.setDesc(address);

        //set customer
        customer.setId(UUID.randomUUID().toString());
        customer.setName(name);

        list.add(address1);
        customer.setAddress(list);
        customer.getAddress().get(0).setCustomer(customer);

        System.out.println(customer.toString());
        System.out.println(address1.toString());

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
    public Customer update(String name, List<Address> addresses, String id) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(addresses);
        customer.setId(id);

        return customerRespository.save(customer);
    }

    @Override
    public String delete(String id) {
        if (customerRespository.exists(id)) {
            customerRespository.delete(id);
            return "deleted";
        }

        return "failed";
    }


}
