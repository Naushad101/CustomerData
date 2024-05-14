package com.bnt.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bnt.dao.CustomerRepository;
import com.bnt.model.Customer;
import com.bnt.service.CustomerService;

public class ServiceTest {
    
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void customerSaveTest(){
        Customer customer = new Customer(1,"sam","berlin");
        when(customerRepository.saveCustomer(customer)).thenReturn(customer);
        Customer aCustomer = customerService.saveCustomer(customer);
        assertEquals(customer, aCustomer);
    }

    @Test
    public void customerUdateTest(){
        Customer customer = new Customer(2,"jerry","abu dhabi");
        when(customerRepository.updateCustomer(2, "jerry")).thenReturn(customer);
        Customer aCustomer = customerService.updateCustomer(2, "jerry");
        assertEquals(customer, aCustomer);
    }

    @Test
    public void customerGetTest(){
        List<Customer> customer = new ArrayList<>();
        Customer c1 = new Customer(1,"sam","berlin");
        Customer c2 = new Customer(2,"Tom","abu dhabi");
        Customer c3 = new Customer(3,"jack","sharjah");
        customer.add(c1);
        customer.add(c2);
        customer.add(c3);

        when(customerRepository.getCustomer()).thenReturn(customer);
        List<Customer> aCustomer = customerService.getCustomer();
        assertEquals(customer, aCustomer);
    }

    @Test
    public void deletecustomerTest(){
        int custId=1;
        customerService.deleteCustomer(custId);
         verify(customerRepository, times(1)).deleteCustomer(custId);
    }

}
