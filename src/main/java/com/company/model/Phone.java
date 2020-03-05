package com.company.model;


import com.company.utils.Validator;

public class Phone extends Telephone implements NumberValidationInterface {

    public final static String PHONE_PREFIX10="2";
    public final static String PHONE_PREFIX14="00302";
    public final static int PHONE_LENGTH10=10;
    public final static int PHONE_LENGTH14=14;

    public Phone(String number) {
        super(number);
        setValidation(number);
    }

    @Override
    public void setValidation(String number) {

        if ((number.startsWith(PHONE_PREFIX10 ) && number.length() == PHONE_LENGTH10) ||
                (number.startsWith(PHONE_PREFIX14) && number.length() == PHONE_LENGTH14)) {
            setValid(Validator.VALID);
        }
    }
}
