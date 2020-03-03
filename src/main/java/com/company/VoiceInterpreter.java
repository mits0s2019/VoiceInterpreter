package com.company;

import com.company.service.AmbiguitieService;
import com.company.service.TelephoneService;
import com.company.utils.DigitUtils;
import com.company.utils.PrintingMap;
import com.company.utils.UsersInputNumber;
import com.company.utils.Validator;

public class VoiceInterpreter {

    public static void main(String[] args) {

        System.out.print("Give your number : ");
        String inputNumber="2 10 23 40";

        if(Validator.validateInputNumber(inputNumber)){ //checks if the input is numeric and if Each number in the input sequence is up to a three digit number.

            String inputNumberWithoutSpaces= UsersInputNumber.removeSpaceFromInputNumber(inputNumber);
            System.out.println("You entered : "+inputNumberWithoutSpaces);
            System.out.println("*************************************");

            AmbiguitieService.findAmbiguities(inputNumber);

            AmbiguitieList.getAmbiguities().stream().forEach(number-> TelephoneService.create(number));

            System.out.println(new PrintingMap<>(Telephone.getTelephoneList()));
            System.out.println("*************************************");

        }
        else{
            System.out.println("Invalid Input");
        }
    }
}
