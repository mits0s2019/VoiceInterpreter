package com.company.utils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void stringToInt() {
        String[] stringArray=new String[]{"2","15","555"};
        int[] expected=new int[]{2,15,555};

        int[] intArray=ArrayUtils.stringToInt(stringArray);
        assertArrayEquals(expected,intArray);
    }

    @Test
    void listIntegerToString() {
        List<Integer> list= Arrays.asList(3,55,22,500);
        String expected="35522500";

        String stringArray=ArrayUtils.listIntegerToString(list);
        assertEquals(expected,stringArray);
    }
}