package com.company;

import java.util.List;

import static com.company.utils.DigitUtils.*;
import static com.company.utils.DigitUtils.isThreeDigit;

public class dummy {

    public static Integer[][] threeDigitsNeighborNumber(List<Integer> list, int index) throws ExceptionHandler {

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
