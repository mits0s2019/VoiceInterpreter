package com.company.model;

import com.company.utils.Validator;


public class Telephone {


    private String inputNumber;
    private String valid= Validator.INVALID;

    public Telephone(String inputNumber) {
        this.inputNumber = inputNumber;
    }


    public void setValid(String valid) {
        this.valid = valid;
    }


    public String getInputNumber() {
        return inputNumber;
    }

    public String getValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "inputNumber='" + inputNumber + '\'' +
                ", valid='" + valid + '\'' +
                '}';
    }
}
