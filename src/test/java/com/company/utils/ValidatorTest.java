package com.company.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    /**
     * checks if the Users input contains only numbers and spaces
     * and if the input sequence is up to a three digit number.
     *
     * @input : A string of numbers
     * @result boolean
     */
    @Test
    void validateInputNumber() {

        String usersInput="23 3 444 5  0";

        boolean actual=Validator.validateInputNumber(usersInput);
        assertEquals(true,actual);
    }

    @Test
    void isNumeric() {

        String number="12 34 045 03";
        boolean actual=Validator.isNumeric(number);

        assertEquals(true,actual);
    }
}