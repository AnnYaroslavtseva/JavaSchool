package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите количество см");
        int count = scan.nextInt(); //считываем количество чисел
        int number = count/3;
        int pound = number/12;
        int inch = number - pound*12;
        ArrayList<Integer> list = new ArrayList();
        list.add(pound);
        list.add(inch);
        System.out.println (list.get(0) + " "+list.get(1));
    }
}
