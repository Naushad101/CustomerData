package com.bnt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.bnt.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

import com.bnt.exceptions.DataIsNotPresent;
import com.bnt.exceptions.ObjectIsNull;
import com.bnt.model.Customer;

@RestController
@Slf4j
public class CustomerController {
    
    @Autowired
    CustomerService customerService;


    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) throws ObjectIsNull{
        if(customer==null) {
            log.warn("The value of object is null");
            throw new ObjectIsNull("The value of object is null");
        }
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customer upDateCustomer(@RequestParam("id") int id,@RequestParam("newName") String newName) throws DataIsNotPresent{
        if(!customerService.getId().contains(id)){
            log.warn("Id is not present id db");
            throw new DataIsNotPresent("Id is not present id db");
        }
        return customerService.updateCustomer(id, newName);
    }


    @GetMapping("/customer")
public List<Customer> getCustomer() throws  ObjectIsNull {
    List<Customer> customers = customerService.getCustomer();
    if (customers.isEmpty()) {
        log.warn("The value of object is null");
        throw new ObjectIsNull("List is Empty");
    }
    return customers;
}


    @DeleteMapping("/customer")
    public void deleteCustomer(@RequestParam("id") int id) throws DataIsNotPresent{
        if(!customerService.getId().contains(id)){
            log.warn("Id is not present id db");
            throw new DataIsNotPresent("id is not present");
        }
        customerService.deleteCustomer(id);
    }
}
