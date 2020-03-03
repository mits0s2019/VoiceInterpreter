package com.company.service;

import com.company.Mobile;
import com.company.Phone;
import com.company.Telephone;
import com.company.utils.Validator;

import static com.company.Mobile.MOBILE_PREFIX10;
import static com.company.Mobile.MOBILE_PREFIX14;
import static com.company.Phone.PHONE_PREFIX10;
import static com.company.Phone.PHONE_PREFIX14;

public class TelephoneService {


    public static void create(String number){

        if( (number.startsWith( MOBILE_PREFIX10)) ||
                (number.startsWith( MOBILE_PREFIX14))){
            new Mobile(number);

        }else if((number.startsWith( PHONE_PREFIX10)) ||
                (number.startsWith( PHONE_PREFIX14))){
            new Phone(number);
        }else{
            Telephone.getTelephoneList().put(number, Validator.INVALID);
        }
    }
}
