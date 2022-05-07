package com.example.a1;

public class Deposit {

    public String deposit(String outAccount, String spinnerValue){

        int parsedValues = Integer.parseInt(outAccount)
                + Integer.parseInt(spinnerValue);
        String parsedString = ""+parsedValues;

        return parsedString;
    }


}
