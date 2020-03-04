package com.company.model;

import com.company.utils.InputNumberUtils;
import com.company.utils.Validator;

public class InputNumber {

    private static String inputNumber;

    public static void set(String inputNumber) {
        InputNumber.inputNumber = inputNumber;
    }

    public static String get() {
        return inputNumber;
    }
    public static String removeSpaces(){
        return InputNumberUtils.removeSpaceFromInputNumber(inputNumber);
    }
    public static boolean validate(){
        return Validator.validateInputNumber(inputNumber);
    }
}
