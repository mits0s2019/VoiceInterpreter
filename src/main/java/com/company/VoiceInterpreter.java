package com.company;

import com.company.service.AmbiguitieService;
import com.company.service.TelephoneService;
import com.company.utils.PrintingMap;
import com.company.utils.UsersInputNumber;
import com.company.utils.Validator;

public class VoiceInterpreter {

    public static void main(String[] args) {
        System.out.print("Give your number : ");

        String inputNumber=UsersInputNumber.getInput();

        if(Validator.validateInputNumber(inputNumber)){ //checks if the input is numeric and if Each number in the input sequence is up to a three digit number.

            String inputNumberWithoutSpaces= UsersInputNumber.removeSpaceFromInputNumber(inputNumber);
            System.out.println("You entered : "+inputNumberWithoutSpaces);
            System.out.println("*************************************");

            AmbiguitieService.findAmbiguities(inputNumber);

            AmbiguitieList.getAmbiguities().stream().forEach(number-> TelephoneService.create(number));

            System.out.println(new PrintingMap<String, String>(Telephone.getTelephoneList()));
            System.out.println("*************************************");

        }
        else{
            System.out.println("Invalid Input");
        }
    }
}
