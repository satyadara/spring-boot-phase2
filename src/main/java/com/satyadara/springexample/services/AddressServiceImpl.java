package com.satyadara.springexample.services;

import com.satyadara.springexample.models.Address;
import com.satyadara.springexample.repositories.AddressRepository;
import com.satyadara.springexample.repositories.CustomerRespository;
import com.satyadara.springexample.requests.CustomerAddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRespository customerRespository;

    @Override
    public List<Address> fetch(String customer_id) {
        return addressRepository.findAddressByCustomer_Id(customer_id);
    }

    @Override
    public Address getOne(String customer_id, String address_id) {
        return addressRepository.findAddressByIdAndCustomer_Id(address_id, customer_id);
    }

    @Override
    public Address insert(String customer_id, CustomerAddressRequest request) {
        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setDesc(request.getDesc());
        address.setCustomer(customerRespository.findOne(customer_id));

        return addressRepository.save(address);
    }

    @Override
    public Address update(String customer_id, String address_id, CustomerAddressRequest request) {
        Address update = addressRepository.findAddressByIdAndCustomer_Id(address_id, customer_id);
        update.setDesc(request.getDesc());
        return addressRepository.save(update);
    }

    @Override
    public String delete(String customer_id, String address_id) {
        if (addressRepository.existsAddressByIdAndCustomer_Id(address_id, customer_id)) {
            addressRepository.deleteAddressByIdAndCustomer_Id(address_id, customer_id);
            return "deleted";
        }

        return "failed";
    }
}
