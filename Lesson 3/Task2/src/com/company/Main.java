package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Compare implements Comparator<String> {
    @Override
    public int compare(String str, String str1) {
        if (str.length() < str1.length()) {
            return -1;
        }
        if (str.length() > str1.length()) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Main {




    public static void main(String[] args) {
        String text = "аааа ббб ввввввв аааа ббб ггггггггггггггг дд е";
        int count = 0;
        String[] stringMass = text.split(" ");
        ArrayList<String> str = new ArrayList<String>();
        Comparator<String> strLengthComprator = new Compare();
        Arrays.sort(stringMass, strLengthComprator);
        for (int i = 0; i < stringMass.length; i++) {
            if( str.contains(stringMass[i]) == false) str.add(stringMass[i]);





        }
        System.out.println(str);

    }
}


