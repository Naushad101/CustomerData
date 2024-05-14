package com.bnt.testController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.bnt.controller.CustomerController;
import com.bnt.model.Customer;
import com.bnt.service.CustomerService;


public class CustomerControllerTest {

    @Mock
    CustomerService customerService;
    

    @InjectMocks
    CustomerController customerController;

     @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void should_successfully_saved(){
        Customer customer = new Customer(1,"sam","berlin");
       when(customerService.saveCustomer(customer)).thenReturn(customer);
        Customer aCustomer = customerController.saveCustomer(customer);
        assertEquals(customer, aCustomer);
    }

    @Test
    public void updateCustomerTest(){
        Customer customer = new Customer(2,"jack","berlin");
        when(customerService.updateCustomer(2, "jack")).thenReturn(customer);
        Customer aCustomer = customerController.upDateCustomer(2, "jack");
        assertEquals(customer, aCustomer);
    }

    @Test
    public void getCustomerTest(){
        List<Customer> customer = new ArrayList<>();
        Customer c1 = new Customer(1,"sma","berlin");
        Customer c2 = new Customer(2,"tom","abu dhabi");

        customer.add(c1);
        customer.add(c2);

        when(customerService.getCustomer()).thenReturn(customer);

        List<Customer> acustomer = customerController.getCustomer();

        assertEquals(customer, acustomer);
    }

    @Test
    public void deleteCustomerTest(){
        int custId = 1;
        customerController.deleteCustomer(custId);
         verify(customerService, times(1)).deleteCustomer(custId);
    }

}
