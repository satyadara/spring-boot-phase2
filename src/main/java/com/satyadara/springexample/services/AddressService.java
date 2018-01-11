package com.satyadara.springexample.services;

import com.satyadara.springexample.models.Address;
import com.satyadara.springexample.requests.CustomerAddressRequest;

import java.util.List;

public interface AddressService {
    List<Address> fetch(String customer_id);

    Address getOne(String customer_id, String address_id);

    Address insert(String customer_id, CustomerAddressRequest request);

    Address update(String customer_id, String address_id, CustomerAddressRequest request);

    String delete(String customer_id, String address_id);
}
