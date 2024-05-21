package com.bnt.service;

import com.bnt.model.Customer;

import lombok.extern.slf4j.Slf4j;

import com.bnt.dao.CustomerRepository;
import com.bnt.exceptions.DataIsNotPresent;
import com.bnt.exceptions.ObjectIsNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.xml.crypto.Data;


@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    public Customer saveCustomer(Customer customer) throws ObjectIsNull{
        if(customer==null){
            log.warn("The value of obj is null");
            throw new ObjectIsNull("The value of obj is null");
        }
        return customerRepository.saveCustomer(customer);
    }

    public Customer updateCustomer(int id,String newName) throws DataIsNotPresent{
        if(!getId().contains(id)){
            log.warn("Id is not present id db");
            throw new DataIsNotPresent("Id is not present in db");
        }
        return customerRepository.updateCustomer(id, newName);
    }

    public List<Customer> getCustomer() throws ObjectIsNull{
        if(customerRepository.getCustomer().isEmpty()){
            log.warn("The value of obj is null");
            throw new ObjectIsNull("Data is not present in db");
        }
        return customerRepository.getCustomer();
    }

    public void deleteCustomer(int id) throws DataIsNotPresent{
        if(!getId().contains(id)){
            throw new DataIsNotPresent("id is not present in db");
        }
        customerRepository.deleteCustomer(id);
    }

    public List<Integer> getId(){
        return customerRepository.getId();
    }

}
