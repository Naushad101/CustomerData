package com.bnt.testRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bnt.dao.CustomerRepository;
import com.bnt.model.Customer;

public class TestCustomerRepository {
    
    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveCustomerTest(){
        Customer customer = new Customer(1,"sam","berlin");

        when(customerRepository.saveCustomer(customer)).thenReturn(customer);

        Customer aCustomer = customerRepository.saveCustomer(customer);

        assertEquals(customer, aCustomer);

    }

    @Test
    public void saveCustomerTest_If_ObjIsNull(){
        assertThrows(NullPointerException.class,()->{
            customerRepository.saveCustomer(null);
        });
    }

    @Test
    public void updateCustomerTest(){
        Customer customer = new Customer(1,"fizzy","berlin");
        when(customerRepository.updateCustomer(1, "fizzy")).thenReturn(customer);
        Customer aCustomer = customerRepository.updateCustomer(1, "fizzy");
        assertEquals(customer, aCustomer);
    }

    @Test
    public void getCustomerTest(){
        List<Customer> customer = new ArrayList<>();
        Customer c1 = new Customer(1,"sam","berlin");
        Customer c2 = new Customer(2,"Tom","abu dhabi");
        Customer c3 = new Customer(3,"jack","sharjah");
        customer.add(c1);
        customer.add(c2);
        customer.add(c3);
        when(customerRepository.getCustomer()).thenReturn(customer);
        List<Customer> aCustomer = customerRepository.getCustomer();
        assertEquals(customer, aCustomer);
    }

    @Test
    public void deleteCustomerTest(){
        int custId=1;
        customerRepository.deleteCustomer(custId);
        verify(customerRepository,times(1)).deleteCustomer(custId);
    }

}
