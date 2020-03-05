package com.company;

import com.company.exception.ExceptionHandler;
import com.company.model.InputNumber;
import com.company.model.Telephone;
import com.company.service.AmbiguitieService;
import com.company.service.TelephoneService;
import com.company.utils.Display;
import com.company.utils.PrintingMap;


public class VoiceInterpreter {

    public static void main(String[] args) {

        boolean start = true;
        String exit="0";

        while (start) {

            InputNumber inputNumber= Display.menu();
            start = !inputNumber.get().equals(exit);

            if (inputNumber.validate() && start) {
                System.out.println("***************************************************************");
                System.out.println("You entered : " + inputNumber.removeSpaces());
                System.out.println("***************************************************************");

                AmbiguitieService ambiguitieService = new AmbiguitieService();
                try {
                    ambiguitieService.search(inputNumber.get());
                } catch (Exception ex) {
                    System.out.println(new ExceptionHandler(ex.getMessage(), inputNumber.get()));
                }
                ambiguitieService.getAmbiguities().stream().forEach(number -> {
                    Telephone telephone = TelephoneService.create(number);
                    inputNumber.setInterpretationNumbers(telephone);
                });

                System.out.println(new PrintingMap(inputNumber.getInterpretationNumbers()));
                System.out.println("***************************************************************");
            } else if (!start) {
            } else {
                System.out.println("***************************************************************");
                System.out.println("Invalid Input");
                System.out.println("***************************************************************");
            }
        }
    }
}
