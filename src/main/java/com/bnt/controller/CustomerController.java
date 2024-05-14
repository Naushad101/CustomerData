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


import com.bnt.model.Customer;

@RestController
public class CustomerController {
    
    @Autowired
    CustomerService customerService;


    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customer upDateCustomer(@RequestParam("id") int id,@RequestParam("newName") String newName){
        return customerService.updateCustomer(id, newName);
    }


    @GetMapping("/customer")
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(@RequestParam("id") int id){
        customerService.deleteCustomer(id);
    }
}
