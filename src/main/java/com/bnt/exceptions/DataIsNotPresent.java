package com.bnt.exceptions;

public class DataIsNotPresent extends Throwable {
    String excepMassege;
    public DataIsNotPresent(String excepMassage){
        this.excepMassege=excepMassage;
    }
}
