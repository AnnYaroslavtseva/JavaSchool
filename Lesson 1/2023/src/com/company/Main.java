package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите длину первого массива");
        int number = scan.nextInt();
        int[] massA = new int[number];
        System.out.println("Введите числа");
        int k = 0;
        for (int i = 0; i < number; i++){
            massA[i] = scan.nextInt();
        }
        System.out.println("ВВедите длину второго массива");
        int number2 = scan.nextInt();
        int[] massB = new int[number2];
        System.out.println("Введите числа");
         for (int j = 0; j <  number2; j++){
             massB[j] = scan.nextInt();
         }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < number; i++){
              if ( massA[i] == massB[i]) {
                  list.add(massA[i]);
              }

         }
         System.out.println(list);
    }

}
