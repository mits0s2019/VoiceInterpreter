package com.company.model;

import com.company.utils.InputNumberUtils;
import com.company.utils.Validator;

import java.util.Map;
import java.util.TreeMap;

public class InputNumber {

    private  String inputNumber;
    private Map<String,String> interpretationNumbers=new TreeMap<>();

    public InputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public  String get() {
        return this.inputNumber;
    }

    public  String removeSpaces(){
        return InputNumberUtils.removeSpaceFromInputNumber(inputNumber);
    }

    public  boolean validate(){
        return Validator.validateInputNumber(inputNumber);
    }

    public void setInterpretationNumbers(Telephone telephone) {
        interpretationNumbers.put(telephone.getInputNumber(),telephone.getValid());
    }

    public Map<String, String> getInterpretationNumbers() {
        return interpretationNumbers;
    }
}
