package com.company.utils;

import java.util.Iterator;
import java.util.List;

public class ArrayUtils {

    public static int[] stringToInt(String[] stringArray){

        int size = stringArray.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(stringArray[i]);
        }
        return arr;
    }

    public static String listIntegerToString(List<Integer> list) {
        StringBuilder strbul = new StringBuilder();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            strbul.append(iter.next());
        }
       return strbul.toString();
    }
}
