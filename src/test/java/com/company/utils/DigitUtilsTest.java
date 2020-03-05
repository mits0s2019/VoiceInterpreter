package com.company.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DigitUtilsTest {

    @Test
    void isTwoDigit() {

        List list= Arrays.asList(3,5,22,143,25);

        assertEquals(true,DigitUtils.isTwoDigit(list,2));
    }

    @Test
    void isThreeDigit() {

        List list= Arrays.asList(3,5,22,143,25);

        assertEquals(true,DigitUtils.isThreeDigit(list,3));
    }


    @Test
    void splitThreeDigit() {

        int number=605;

        Integer[] expected=new Integer[]{600,05};
        Integer[] actual=  DigitUtils.splitThreeDigit(number);

        assertArrayEquals(expected,actual);
    }

    @Test
    void splitTwoDigit() {
        int number=17;

        Integer[] expected=new Integer[]{10,7};
        Integer[] actual=  DigitUtils.splitTwoDigit(number);

        assertArrayEquals(expected,actual);
    }
}