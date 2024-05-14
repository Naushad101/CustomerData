package com.bnt.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    int id;
    String name;
    String city;
    
    public Customer(){

    }

    public Customer(int id,String name,String city){
        this.id=id;
        this.name=name;
        this.city=city;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setCity(String city){
        this.city=city;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCity(){
        return city;
    }

    public Object thenReturn(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'thenReturn'");
    }

}
