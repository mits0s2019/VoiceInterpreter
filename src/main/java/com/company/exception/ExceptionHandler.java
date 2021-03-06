package com.company.exception;

import com.company.model.InputNumber;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExceptionHandler extends Exception {

    private String errorNumber;
    private String errorMessage;
    private LocalDate localDate=LocalDate.now();
    private String localTime=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));



    public ExceptionHandler(String errorMessage,String inputNumber) {
        this.errorNumber=inputNumber;
        this.errorMessage = errorMessage;
    }


    @Override
    public String toString() {
        return   localDate+" at "+localTime+"\n"+
                "Sorry something went wrong with the Number = '" + errorNumber + '\'' +"\n"+
                "Error Message ='" + errorMessage + '\''+
                "\n***************************************************************";
    }
}
