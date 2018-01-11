package com.satyadara.springexample.controllers;

import com.satyadara.springexample.models.Address;
import com.satyadara.springexample.requests.CustomerAddressRequest;
import com.satyadara.springexample.requests.UpdateAddressRequest;
import com.satyadara.springexample.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customers/{customer_id}/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Address> index(@PathVariable("customer_id") String customer_id) {
        return addressService.fetch(customer_id);
    }

    @RequestMapping(
            value = "/{address_id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Address get(@PathVariable("customer_id") String customer_id,
                       @PathVariable("address_id") String address_id) {
        return addressService.getOne(customer_id, address_id);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Address store(@PathVariable("customer_id") String customer_id,
                         @Valid @RequestBody CustomerAddressRequest request) {
        return addressService.insert(customer_id, request);
    }

    @RequestMapping(
            value = "/{address_id}/edit",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Address update(@PathVariable("customer_id") String customer_id,
                          @PathVariable("address_id") String address_id,
                          @Valid @RequestBody CustomerAddressRequest request) {
        return addressService.update(customer_id, address_id, request);
    }



}
