package com.satyadara.springexample.services;

import com.satyadara.springexample.models.Customer;
import com.satyadara.springexample.repositories.CustomerRespository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class CustomerServiceImplTest {
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Mock
//    private CustomerRespository customerRespository;
//
//    @InjectMocks
//    private CustomerServiceImpl customerService;
//
//    @Test
//    public void testRegisterSuccess() {
//        Mockito.when(customerRespository.save(Mockito.any(Customer.class)))
//                .then(invocationOnMock -> invocationOnMock.getArguments()[0]);
//
//        Customer customer = customerService.register("satya", "purbalingga");
//
//        assertNotNull(customer.getId());
//        assertEquals("satya", customer.getName());
//        assertEquals("purbalingga", customer.getAddress());
//
//        Mockito.verify(customerRespository, Mockito.times(1))
//                .save(Mockito.any(Customer.class));
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testRegisterError() {
//        Mockito.when(customerRespository.save(Mockito.any(Customer.class)))
//                .thenThrow(new RuntimeException());
//
//        customerService.register("satya", "purbalingga");
//    }

}