package com.satyadara.springexample.repositories;

import com.satyadara.springexample.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findAddressByCustomer_Id(String customer_id);

    Address findAddressByIdAndCustomer_Id(String address_id, String customer_id);

    boolean existsAddressByIdAndCustomer_Id(String address_id, String customer_id);

    void deleteAddressByIdAndCustomer_Id(String address_id, String customer_id);
}
