package com.company.service;

import java.util.List;

import static com.company.utils.DigitUtils.*;

public class InterpretationService {

    public static Integer[][] twoDigitsneighborNumbers(int num1, Integer num2) {


        if (num2 != null) {

            if (num1 % 10 == 0 && num1<101)  {  /// input 30,36 --->output [30,3],[33,6]
                if (num2>9 && num2<100) {//if the following number has 2 digits then there is a remainder
                    int firstDigit = Integer.parseInt(Integer.toString(num2).substring(0, 1));//get the first digit of the following element
                    int remainder = Integer.parseInt(String.valueOf(num2).substring(1));

                    return new Integer[][]{{num1, num2}, {num1 + firstDigit, remainder}};

                }else if(num2>=100){
                    return new Integer[][]{{num1}};
                }
                return new Integer[][]{{num1, num2}, {num1 + num2}};

            } else if (num1>=20 && num1<100) {  /// input 69,3 --->output [69,3],[60,9,3]
                Integer[] splitedDigit=splitTwoDigit(num1);
                int firstDigit=splitedDigit[0];
                int secondDigit=splitedDigit[1];
                return new Integer[][]{{num1, num2}, {firstDigit, secondDigit, num2}};
            } else {
                return new Integer[][]{{num1, num2}};
            }

            // if is the last number
        } else {
            if (!(num1 % 10 == 0) && num1<100) {    //if the last digit isnt 10,20,30...then split it
                Integer[] splitedDigit=splitTwoDigit(num1);
                int firstDigit=splitedDigit[0];
                int secondDigit=splitedDigit[1];
                return new Integer[][]{{firstDigit, secondDigit}};
            }
            else{
                return new Integer[][]{{num1}};
            }
        }
    }


    public static Integer[][] threeDigitsNeighborNumber(List<Integer> list, int index){

        if(list.get(index)%100==0) {

            if(list.size()>index+1){
                if(list.size()>index+2){
                    if(list.get(index+1)%10==0) {
                        if (list.get(index + 2) < 10) {
                            return new Integer[][]{{list.get(index), list.get(index + 1), list.get(index + 2)},
                                    {list.get(index) + list.get(index + 1), list.get(index + 2)},
                                    {list.get(index) + list.get(index + 1) + list.get(index + 2)}};
                        } else if (list.get(index + 2) >= 10 && list.get(index + 2) < 99 && list.get(index + 2) % 10 != 0) {

                            Integer[] splitedTwoDigitNumber = splitTwoDigit(list.get(index + 2));
                            return new Integer[][]{{list.get(index), list.get(index + 1), list.get(index + 2)},
                                    {list.get(index) + list.get(index + 1), list.get(index + 2)},
                                    {list.get(index) + list.get(index + 1) + getFirstDigitOfNumber(splitedTwoDigitNumber[0]), splitedTwoDigitNumber[1]}};
                        } else if (list.get(index + 2) >= 10 && list.get(index + 2) < 99 && list.get(index + 2) % 10 == 0) {
                            return new Integer[][]{{list.get(index), list.get(index + 1)},
                                    {list.get(index) + list.get(index + 1)}};
                        } else {
                            return new Integer[][]{{list.get(index), list.get(index + 1)},
                                    {list.get(index) + list.get(index + 1)}};
                        }
                    } else{
                        return new Integer[][]{{list.get(index),list.get(index+1)},
                                {list.get(index)+list.get(index+1)}};
                    }
                }else if(isThreeDigit(list.get(index+1))){
                    return new Integer[][]{{list.get(index)}};
                }
            }
            if(isThreeDigit(list.get(index))){
                return new Integer[][]{{list.get(index)}};
            }
            else{
                return new Integer[][]{{list.get(index),list.get(index+1)},
                        {list.get(index)+list.get(index+1)}};
            }
        }
        return  null;
    }
}