package com.company.utils;


import com.company.model.InputNumber;

import java.util.Scanner;

public class Display {

    public static InputNumber menu(){

        System.out.println("Press \"0\" to Exit");
        System.out.print("Give your phone number : ");

        return new InputNumber(new Scanner(System.in).nextLine().trim());
    }
}
