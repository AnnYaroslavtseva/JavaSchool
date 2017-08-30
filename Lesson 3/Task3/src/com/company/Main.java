package com.company;

import  java.util.ArrayList;
import java.util.Iterator;

import  java.util.List;

public class Main {

    public static void main(String[] args) {
        String text = "ааа ббб ввв ааа ббб ггг ддд еее";
        int count = 0;
        String[] stringMass = text.split(" ");
        ArrayList<String> str = new ArrayList<String>();
        Iterator<String> iter = str.iterator();
        for (int i = 0; i < stringMass.length; i++) {
            String str1 = str.get(i);
            str.add(stringMass[i]);
            while(iter.hasNext()) {
                String str2 = iter.next();
                if (str1.equals(str2)){
                    count++;
                    iter.remove();
                }

            }
            System.out.println(str1+" "+count);
            count = 0;
        }

    }
}


