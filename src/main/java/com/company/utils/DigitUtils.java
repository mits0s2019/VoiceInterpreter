package com.company.utils;

import java.util.List;

public class DigitUtils {

    public static boolean isTwoDigit(List<Integer> list, int index){
        return list.get(index)>=20 && list.get(index)<100;
    }

    public static boolean isThreeDigit(List<Integer> list, int index){
        return list.get(index)>=100 && list.get(index)<1000;
    }

    /**
     * @param num1 = 65
     * @return  [60 , 5]
     */
    public static Integer[] splitTwoDigit(Integer num1) {
        if(!(num1%10==0) && num1>10 && num1<100) {
            int firstDigit=(num1-num1%10);
            int secondDigit=num1%10;
            return new Integer[]{firstDigit, secondDigit};
        }else{
            return   new Integer[]{num1};
        }
    }

    /**
     * @param num1 = 666
     * @return  [600 , 66]
     */
    public static Integer[] splitThreeDigit(Integer num1) {
        if((num1%100!=0) && num1>100 && num1<1000) {
            int firstDigit = num1-num1%100;
            int secondDigit=num1%100;

            return new Integer[]{firstDigit, secondDigit};
        }else{
            return   new Integer[]{num1};
        }
    }

    public static int getFirstDigit(int num){
        return Integer.parseInt(Integer.toString(num).substring(0, 1));
    }
    public static int getRemainder(int num){
        return Integer.parseInt(String.valueOf(num).substring(1));
    }
}
