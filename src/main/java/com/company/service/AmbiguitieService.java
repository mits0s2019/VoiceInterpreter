package com.company.service;


import com.company.AmbiguitieList;
import com.company.utils.ArrayUtils;
import com.company.utils.DigitUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.utils.DigitUtils.*;

public class AmbiguitieService {


    public static void findAmbiguities(String inputNumber) {
        String[] arrayInput = inputNumber.split("\\s+");
        int[] arrayInt = ArrayUtils.stringToInt(arrayInput);
        List<Integer> arrayInputList = Arrays.stream(arrayInt).boxed().collect(Collectors.toList());

        AmbiguitieService.recursionList(new ArrayList<Integer>(Arrays.asList(2,10,200,20,100,20,5)), 0);
    }

    private static void createAmbiguitieList(Integer[][] array,List<Integer>list, int index) {

        for (int i = 0; i < array.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            for (int j = 0; j < array[i].length; j++) {
                newList.add(index + j, array[i][j]);
            }
            recursionList(newList, index + 1);
        }
    }

    public static void recursionList(List<Integer> list, int index) {

        AmbiguitieList.getAmbiguities().add(ArrayUtils.listIntegerToString(list));  //adding the converted String list to ambiguities list

        if (list.size() == index) {
            return ;
        }

//        THREE digits
        if(isThreeDigit(list,index)){
            DigitUtils.threeDigitsNeighborNumber(list,index);
            if(( list.size()==index+1)){//checks if its the last digit of the list
                Integer[][] array = neighborNumbers(list.get(index),null);
                list.remove(index);
                createAmbiguitieList(array,list,index);
            }
            else {
                Integer[][] array = threeDigitsNeighborNumber(list,index);

                for (int i = 0; i < array.length; i++){
                    list.remove(index);
                    System.out.println(Arrays.toString(array[i]));
            }
                createAmbiguitieList(array,list,index);
            }
        }



        // 2 digits
        else if (isTwoDigit(list, index)) {//checks a digits and the  following digit
            if(( list.size()==index+1)){//checks if its the last digit of the list
                Integer[][] array = neighborNumbers(list.get(index),null);
                list.remove(index);
                createAmbiguitieList(array,list,index);
            }
            else {
                Integer[][] array = neighborNumbers(list.get(index), list.get(index + 1));
                for(int i=0;i<array.length;i++){
                    list.remove(index);
                }
                createAmbiguitieList(array,list,index);
            }
        } else {
            recursionList(list, index + 1);
        }
    }
}
