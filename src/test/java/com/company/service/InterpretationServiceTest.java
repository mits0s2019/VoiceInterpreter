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


    /**
     * This method takes a list as an input and its index ... If it's a three digit number then
     * checks the followings numbers.Depending on the following numbers, there are a lot of possible combinations...
     *
     *                   if the index is '2' then the following method will execute
     *
     *                               [1,33,400,50,6]
     *                                   /    \
     *@return                    [[400,50,6],[450,6],[456]]
     */
    @Test
    void threeDigitsNeighborNumber() throws ExceptionHandler {

        List<Integer> list = Arrays.asList(1,33,400,50,6);

        Integer[][] expected=new Integer[][]{{400,50,6},{450,6},{456}};

        Integer[][] actual=InterpretationService.threeDigitsNeighborNumber(list,2);
        assertArrayEquals(expected,actual);
    }
}