package com.example.a1;

public class Withdraw {
    public String withdraw(String textField, String spinnerValue){

        int parsedValues = Integer.parseInt(textField)
                - Integer.parseInt(spinnerValue);
        String parsedString = ""+parsedValues;

        return parsedString;
    }

}
