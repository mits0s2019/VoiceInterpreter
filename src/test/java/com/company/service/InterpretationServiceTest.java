package com.company.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpretationServiceTest {


    /**
     *  This method takes two numbers as an input... If The first number is two digit then
     *                                                          35,5               30 2
     *                                                          /  \               /  \
     *                                                    [35,5] [30,5,5]     [30,2]  [32]
     */
    @Test
    void twoDigitsneighborNumbers() {

        int num1=35,num2=5;
        int num3=30,num4=2;

        Integer[][] expectedArray1=new Integer[][]{{35,5},{30,5,5}};
        Integer[][] expectedArray2=new Integer[][]{{30,2},{32}};

        Integer[][] actualArray1=InterpretationService.twoDigitsneighborNumbers(num1,num2);
        Integer[][] actualArray2=InterpretationService.twoDigitsneighborNumbers(num3,num4);

        assertArrayEquals(expectedArray1,actualArray1);
        assertArrayEquals(expectedArray2,actualArray2);
    }
}