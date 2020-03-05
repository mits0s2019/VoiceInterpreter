package com.company;

import com.company.exception.ExceptionHandler;
import com.company.model.AmbiguitieList;
import com.company.model.InputNumber;
import com.company.model.Telephone;
import com.company.service.AmbiguitieService;
import com.company.service.TelephoneService;
import com.company.utils.PrintingMap;

import java.util.Scanner;

public class VoiceInterpreter {

    public static void main(String[] args) {

        System.out.print("Give your number : ");
        InputNumber.set(new Scanner(System.in).nextLine().trim());

        if(InputNumber.validate()){
            System.out.println("***************************************************************");
            System.out.println("You entered : "+InputNumber.removeSpaces());
            System.out.println("***************************************************************");

            try {
                AmbiguitieService.findAmbiguities(InputNumber.get());
            } catch (Exception ex) {
                System.out.println(new ExceptionHandler(ex.getMessage()));
            }
            AmbiguitieList.getAmbiguities().stream().forEach(number-> TelephoneService.create(number));

            System.out.println(new PrintingMap(Telephone.getTelephoneList()));
            System.out.println("***************************************************************");
        }
        else{
            System.out.println("Invalid Input");
        }
   }
}
