package com.company.utils;

public class Validator {

    public static final String VALID = "VALID";
    public static final String INVALID = "INVALID";


    /**
     * checks if the Users input contains only numbers and spaces
     * and if the input sequence is up to a three digit number.
     *
     * @param inputNumber  : A string of numbers (with spaces)
     * @result boolean
     */
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
        return inputNumber.matches("(\\d+\\s*)+");
    }
}
