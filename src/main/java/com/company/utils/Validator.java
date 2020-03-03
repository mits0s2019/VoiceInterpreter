package com.company.utils;

public class Validator {

    public static final String VALID = "VALID";
    public static final String INVALID = "INVALID";

    public static boolean validateInputNumber(String inputNumber){
        boolean isValid=true;
        String[] arrayInput=inputNumber.split("\\s+");

        if(isNumeric(inputNumber)) {
            for (String number : arrayInput) {
                if (number.length() > 3) {
                    isValid = false;
                    break;
                }
            }
        }
        else{
            return false;
        }
        return isValid;
    }

    public static boolean isNumeric(String inputNumber){
       boolean numeric=inputNumber.matches("(\\d+\\s*)+");
        return numeric;
    }
}
