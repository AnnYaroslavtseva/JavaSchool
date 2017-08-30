package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String text = "ааа ббб ввв ааа ббб ггг ддд еее";
        int count = 0;
        String[] stringMass = text.split(" ");
        ArrayList<String> str = new ArrayList<String>();
        for (int i = 0; i < stringMass.length; i++) {
            if( str.contains(stringMass[i]) == false) str.add(stringMass[i]);


            count = str.size();
        }
        System.out.println(count);

    }
}


