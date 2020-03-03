package com.company.utils;

import java.util.List;

public class DigitUtils {

    public static boolean isTwoDigit(List<Integer> list, int index){
        return list.get(index)>=20 && list.get(index)<100;
    }
    public static boolean isThreeDigit(List<Integer> list, int index){
        return list.get(index)>=100 && list.get(index)<=1000;
    }

    public static Integer[][] neighborNumbers(int num1, Integer num2) {

        if (num2 != null) {

            if (num1 % 10 == 0 && num1<101)  {  /// input 30,36 --->output [30,3],[33,6]
                if (num2>9) {//if the following number has 2 digits then there is a remainder
                    int firstDigit = Integer.parseInt(Integer.toString(num2).substring(0, 1));//get the first digit of the following element
                    int remainder = Integer.parseInt(String.valueOf(num2).substring(1));

                    return new Integer[][]{{num1, num2}, {num1 + firstDigit, remainder}};
                }
                return new Integer[][]{{num1, num2}, {num1 + num2}};

            } else if (num1>=20 && num1<100) {  /// input 69,3 --->output [69,3],[60,9,3]
                Integer[] splitedDigit=splitDigit(num1);
                int firstDigit=splitedDigit[0];
                int secondDigit=splitedDigit[1];
                return new Integer[][]{{num1, num2}, {firstDigit, secondDigit, num2}};
            } else {
                return new Integer[][]{{num1, num2}};
            }

            // if is the last number
        } else {
            if (!(num1 % 10 == 0)) {    //if the last digit isnt 10,20,30...then split it
                Integer[] splitedDigit=splitDigit(num1);
                int firstDigit=splitedDigit[0];
                int secondDigit=splitedDigit[1];
                return new Integer[][]{{firstDigit, secondDigit}};
            }
            else{
                return new Integer[][]{{num1}};
            }
        }
    }

    private static Integer[] splitDigit(Integer num1) {
        if(!(num1%10==0)) {
            char firstD = String.valueOf(num1).charAt(0);
            char secondD = String.valueOf(num1).charAt(1);
            String firstDigitString = firstD + "0";
            int firstDigit = Integer.parseInt(firstDigitString);
            int secondDigit = Integer.parseInt(String.valueOf(secondD));

            return new Integer[]{firstDigit, secondDigit};
        }else{
          return   new Integer[]{num1};
        }
    }

    public static Integer[][] neighborNumberForThreDigits(List<Integer> list,int index){

        if(list.get(index)%100==0) {

            if(list.size()>index+1){

                System.out.println("2");
                if(list.size()>index+2){

                    if(list.get(index+1)%10==0){

                        if(list.get(index+2)<10){
                            return new Integer[][]{{list.get(index), list.get(index+1),list.get(index+2)},
                                                    {list.get(index) + list.get(index+1),list.get(index+2)},
                                                    {list.get(index)+list.get(index+1)+list.get(index+2) }};
                        }
                    }
                }
            }

        }
        System.out.println("NO");
        return  null;
    }
}
