package com.bnt.service;

import com.bnt.model.Customer;
import com.bnt.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    public Customer saveCustomer(Customer customer){
        return customerRepository.saveCustomer(customer);
    }

    public Customer updateCustomer(int id,String newName){
        return customerRepository.updateCustomer(id, newName);
    }

    public List<Customer> getCustomer(){
        return customerRepository.getCustomer();
    }

    public void deleteCustomer(int id){
        customerRepository.deleteCustomer(id);
    }

}
