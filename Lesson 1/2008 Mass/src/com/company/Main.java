package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите количество чисел");
        int number = scan.nextInt();
        System.out.println("ВВедите max вес");
        int weight = scan.nextInt();
        int[] mass = new int[number];
        int sum = 0;
        int k = 0;
        System.out.println("Введите числа");
        for (int i = 0; i < number; i++){
            mass[i] = scan.nextInt();
            if ((sum + mass[i]) > weight ){
            }
            else {
                sum += mass[i];
                k++;

            }


        }
        System.out.println(sum+" "+k);
    }
}
