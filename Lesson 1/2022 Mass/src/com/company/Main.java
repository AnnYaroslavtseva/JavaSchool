package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите количество чисел");
        int number = scan.nextInt();
        int[] mass = new int[number];
        System.out.println("Введите числа");
        int k = 0;
        for (int i = 0; i < number; i++){
        mass[i] = scan.nextInt();}


        for (int i = 0; i < number; i++){
            for (int j = 0; j < number; j++){
                if ((i != j) && (mass[i] % mass[j] == 0)){
                k++;
                }
            }
        }
        System.out.println(k);
    }
}
