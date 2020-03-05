package com.company.service;

import com.company.exception.ExceptionHandler;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InterpretationServiceTest {


    /**
     *  This method takes two numbers as an input... If The first number is  two digit then
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

    @Test
    void threeDigitsNeighborNumber() throws ExceptionHandler {

        List<Integer> list = Arrays.asList(5,6,400,30,4);

        Integer[][] expected=new Integer[][]{{400,30,4},{430,4},{434}};

        Integer[][] actual=InterpretationService.threeDigitsNeighborNumber(list,2);
        assertArrayEquals(expected,actual);
    }
}