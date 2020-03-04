package com.company.service;


import com.company.model.AmbiguitieList;
import com.company.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.service.InterpretationService.*;
import static com.company.utils.DigitUtils.*;

public class AmbiguitieService {

    /**
     *This method takes the users input and put it in a List<Integer> and pass it to a recursion method.
     *
     * @param inputNumber users input number
     */
    public static void findAmbiguities(String inputNumber) {
        String[] arrayInput = inputNumber.split("\\s+");
        int[] arrayInt = ArrayUtils.stringToInt(arrayInput);
        List<Integer> arrayInputList = Arrays.stream(arrayInt).boxed().collect(Collectors.toList());

        AmbiguitieService.recursionList(arrayInputList, 0);
    }


    /**
     *    Whenever this method is called, it saves the @param list (the first time it saves the users input).
     * Checks the index of the list . If its a two/three digit number then calls the corresponding method and gets back a two dimentional array
     * with all the ambiguities and then calls @createAmbiguitieList method to save the new list.
     */
    public static void recursionList(List<Integer> list, int index) {

        AmbiguitieList.getAmbiguities().add(ArrayUtils.listIntegerToString(list));  //adding the converted String list to ambiguities list

        if (list.size() == index) {
            return ;
        }

        if(isThreeDigit(list,index)){
            if(( list.size()==index+1)){//checks if its the last digit of the list
                Integer[][] array = twoDigitsneighborNumbers(list.get(index),null);
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
        else if (isTwoDigit(list, index)) {//checks a digits and the  following digit
            if(( list.size()==index+1)){//checks if its the last digit of the list
                Integer[][] array = twoDigitsneighborNumbers(list.get(index),null);
                list.remove(index);
                createAmbiguitieList(array,list,index);
            }
            else {
                Integer[][] array = twoDigitsneighborNumbers(list.get(index), list.get(index + 1));
                for(int i=0;i<array.length;i++){
                    list.remove(index);
                }
                createAmbiguitieList(array,list,index);
            }
        } else {
            recursionList(list, index + 1);
        }
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
}
