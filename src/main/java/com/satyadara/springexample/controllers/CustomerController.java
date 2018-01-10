package com.satyadara.springexample.controllers;

import com.satyadara.springexample.models.Customer;
import com.satyadara.springexample.requests.RegisterCustomerRequest;
import com.satyadara.springexample.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer register(@Valid @RequestBody RegisterCustomerRequest request) {
        return customerService.register(request.getName(), request.getAddress());
    }

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> fetch() {
        return customerService.fetch();
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer get(@PathVariable String id) {
        return customerService.get(id);
    }

    @RequestMapping(
            value = "/customers/{id}/edit",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer update(@Valid @RequestBody RegisterCustomerRequest request, @PathVariable String id) {
        return customerService.update(request.getName(), request.getAddress(), id);
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String delete(@PathVariable String id) {
        return customerService.delete(id);
    }
}
