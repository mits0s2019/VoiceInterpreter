package com.company;

import com.company.model.InputNumber;
import com.company.service.AmbiguitieService;
import com.company.service.TelephoneService;
import com.company.utils.PrintingMap;

import java.util.Scanner;

public class VoiceInterpreter {

    public static void main(String[] args) {

        System.out.print("Give your number : ");
//        String inputNumber="2 10 23 40";
        InputNumber.set(new Scanner(System.in).nextLine());

        if(InputNumber.validate()){ //checks if the input is numeric and if Each number in the input sequence is up to a three digit number.

            System.out.println("You entered : "+InputNumber.removeSpaces());
            System.out.println("*************************************");

            AmbiguitieService.findAmbiguities(InputNumber.get());

            AmbiguitieList.getAmbiguities().stream().forEach(number-> TelephoneService.create(number));

            System.out.println(new PrintingMap<>(Telephone.getTelephoneList()));
            System.out.println("*************************************");

        }
        else{
            System.out.println("Invalid Input");
        }
   }
}
