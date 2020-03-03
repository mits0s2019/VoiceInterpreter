package com.company.utils;


import java.util.Scanner;

public class UsersInputNumber {

    public static String removeSpaceFromInputNumber(String number){
        return number.replaceAll("\\s","");
    }


    public static String getInput(){

        return new Scanner(System.in).nextLine();
    }
}
