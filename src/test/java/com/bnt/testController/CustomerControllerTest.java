package com.bnt.testController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.bnt.controller.CustomerController;
import com.bnt.exceptions.DataIsNotPresent;
import com.bnt.exceptions.ObjectIsNull;
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
    public void should_successfully_saved() throws ObjectIsNull{
        Customer customer = new Customer(1,"sam","berlin");
       when(customerService.saveCustomer(customer)).thenReturn(customer);
        Customer aCustomer = customerController.saveCustomer(customer);
        assertEquals(customer, aCustomer);
    }

    // @Test
    // public void testCustomerSave_exception(){
    //    Assertions.assertThrows(IllegalArgumentException.class, new TestCustomerNullInput());

    // }

    // Negative test for saveCustomer

    @Test
    public void testSaveCustomer_NullInput() {
        assertThrows(ObjectIsNull.class, () -> {
            customerController.saveCustomer(null);
        });
    }



    @Test
    public void updateCustomerTest() throws DataIsNotPresent{
        Customer customer = new Customer(2,"jack","berlin");
        when(customerService.updateCustomer(2, "jack")).thenReturn(customer);
        Customer aCustomer = customerController.upDateCustomer(2, "jack");
        assertEquals(customer, aCustomer);
    }

    // Negative test for updateCustomer

    @Test
    public void updateCustomerTest_Invalid_Id(){
        assertThrows(DataIsNotPresent.class, ()->{
            customerController.upDateCustomer(0, "nick");
        });
    }

    @Test
    public void getCustomerTest() throws ObjectIsNull{
        List<Customer> customer = new ArrayList<>();
        Customer c1 = new Customer(1,"sma","berlin");
        Customer c2 = new Customer(2,"tom","abu dhabi");

        customer.add(c1);
        customer.add(c2);

        when(customerService.getCustomer()).thenReturn(customer);

        List<Customer> acustomer = customerController.getCustomer();

        assertEquals(customer, acustomer);
    }


    // Negative test for getCustomer
    @Test
public void getCustomer_If_Response_IsNull() {
    assertThrows(ObjectIsNull.class, () -> {
        customerController.getCustomer();
    });
}




    @Test
    public void deleteCustomerTest() throws DataIsNotPresent{
        int custId = 1;
        customerController.deleteCustomer(custId);
         verify(customerService, times(1)).deleteCustomer(custId);
    }

    // Negative test for deleteCustomer
    @Test
    public void deleteCustomerTest_If_Id_Is_Not_Present(){
        assertThrows(DataIsNotPresent.class, ()->{
            customerController.deleteCustomer(0);
        });
    }

}
