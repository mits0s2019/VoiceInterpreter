package com.company.service;

import com.company.exception.ExceptionHandler;
import com.company.utils.DigitUtils;
import java.util.List;

import static com.company.utils.DigitUtils.*;

public class InterpretationService {

    /**
     * This method takes two numbers as an input... If The first number has two digits then
     *                                                          35,5               30 2
     *                                                          /  \               /  \
     * @return Array[][]  -->                             [35,5] [30,5,5]     [30,2]  [32]
     */
    public static Integer[][] twoDigitsneighborNumbers(int num1, Integer num2) {

        if (num2 != null) {
            if (num1 % 10 == 0 && num1 < 101) {
                if (num2 > 9 && num2 < 100) {                       //if the following number has 2 digits then there is a remainder
                    int firstDigit = DigitUtils.getFirstDigit(num2);//get the first digit of the following element
                    int remainder = DigitUtils.getRemainder(num2);

                    return new Integer[][]{{num1, num2}, {num1 + firstDigit, remainder}};

                } else if (num2 >= 100) {
                    int firstDigit = DigitUtils.getFirstDigit(num2);
                    int remainder = DigitUtils.getRemainder(num2);
                    return new Integer[][]{{num1,num2},{num1+firstDigit,remainder}};
                }
                return new Integer[][]{{num1, num2}, {num1 + num2}};

            } else if (num1 >= 20 && num1 < 100) {                  /// input 69,3 --->output [69,3],[60,9,3]
                Integer[] splitedDigit = splitTwoDigit(num1);
                int firstDigit = splitedDigit[0];
                int secondDigit = splitedDigit[1];
                return new Integer[][]{{num1, num2}, {firstDigit, secondDigit, num2}};
            } else {
                return new Integer[][]{{num1, num2}};
            }
        } else {
            if (!(num1 % 10 == 0) && num1 < 100) {                 //if the last digit isnt 10,20,30...then split it
                Integer[] splitedDigit = splitTwoDigit(num1);
                int firstDigit = splitedDigit[0];
                int secondDigit = splitedDigit[1];
                return new Integer[][]{{firstDigit, secondDigit}};
            } else {
                return new Integer[][]{{num1}};
            }
        }
    }

    /**
     * This method takes a list as an input and its index ... If it's a three digit number then
     * checks the followings numbers.Depending on the following numbers, there are a lot of possible combinations...
     *
     *@param index     if the index is '2' then the following method will execute
     *
     *@param list                     [1,33,400,50,6]
     *                                   /    \
     *@return                [[400,50,6],[400,56],[450,6],[456]]
     */
    public static Integer[][] threeDigitsNeighborNumber(List<Integer> list, int index) throws ExceptionHandler {

        if (list.get(index) % 100 != 0) {
            Integer[]splitedNumber= DigitUtils.splitThreeDigit(list.get(index));
            int firstDigit=splitedNumber[0];
            int secondDigit=splitedNumber[1];
            return new Integer[][]{{list.get(index)},{firstDigit,secondDigit},
                                  {getFirstDigit(list.get(index)),getRemainder(list.get(index))}};
        }
        else{
            if(list.get(index+1)>99){
                return new Integer[][]{{list.get(index)}};
            }
            else if(list.get(index+1)<99 && list.get(index+1)%10==0){
                if (index + 2 < list.size() && list.get(index + 2)<10){

                    return new Integer[][]{{list.get(index),list.get(index + 1), list.get(index + 2)},
                                           {list.get(index) + list.get(index + 1), list.get(index + 2)},
                                           {list.get(index) + list.get(index + 1) + list.get(index + 2)}};
                }
                else if(index + 2 < list.size() && list.get(index + 2)>9 && list.get(index + 2)<100){

                    return new Integer[][]{{list.get(index),list.get(index + 1),list.get(index + 2)},
                                           {list.get(index) + list.get(index + 1), list.get(index + 2)},
                                            {list.get(index) + list.get(index + 1)+getFirstDigit(list.get(index+2)),getRemainder(list.get(index+2))}};
                }
                else{
                    return new Integer[][]{{list.get(index),list.get(index + 1)},
                                           {list.get(index) + list.get(index + 1)}};
                }
            }
            else if(list.get(index+1)<10){
                return new Integer[][]{{list.get(index),list.get(index + 1)},
                                       {list.get(index) + list.get(index + 1)}};
            }
            else {
                return new Integer[][]{{list.get(index) +getFirstDigit(list.get(index+1)), getRemainder(list.get(index+1))},
                                       {list.get(index) + list.get(index + 1)}};
            }
        }
    }
}
