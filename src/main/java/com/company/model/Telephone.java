package com.company.model;

import com.company.utils.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract  class Telephone {


    private String inputNumber;
    private static Map<String,String> telephoneList=new TreeMap<>();
    private String valid= Validator.INVALID;


    public Telephone(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    abstract void setValidation(String number);

    public void addToTelephoneList() {
        telephoneList.put(getInputNumber(),getValid());
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public static Map<String, String> getTelephoneList() {
        return telephoneList;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public String getValid() {
        return valid;
    }

}
