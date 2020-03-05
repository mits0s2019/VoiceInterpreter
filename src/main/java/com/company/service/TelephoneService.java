package com.company.service;

import com.company.model.Mobile;
import com.company.model.Phone;
import com.company.model.Telephone;
import com.company.utils.Validator;

import static com.company.model.Mobile.MOBILE_PREFIX10;
import static com.company.model.Mobile.MOBILE_PREFIX14;
import static com.company.model.Phone.PHONE_PREFIX10;
import static com.company.model.Phone.PHONE_PREFIX14;

public class TelephoneService {


    public static Telephone create(String number){

        if( (number.startsWith( MOBILE_PREFIX10)) ||
                (number.startsWith( MOBILE_PREFIX14))){
          return   new Mobile(number);

        }else if((number.startsWith( PHONE_PREFIX10)) ||
                (number.startsWith( PHONE_PREFIX14))){
           return new Phone(number);
        }else{
           return new Telephone(number);
        }
    }

}
