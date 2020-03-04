package com.company.model;


import com.company.utils.Validator;


public class Mobile extends Telephone {

    public final static String MOBILE_PREFIX10="69";
    public final static String MOBILE_PREFIX14="003069";
    public final static int MOBILE_LENGTH10=10;
    public final static int MOBILE_LENGTH14=14;


    public Mobile(String number) {
        super(number);
        setValidation(number);
        addToTelephoneList();
    }

    @Override
    public void setValidation(String number) {

        if( (number.startsWith( MOBILE_PREFIX10) && number.length()==MOBILE_LENGTH10) ||
                (number.startsWith( MOBILE_PREFIX14) && number.length()==MOBILE_LENGTH14)){
            setValid(Validator.VALID);
        }
    }
}
