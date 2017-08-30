package com.company;
import java.util.Scanner;



public class Main {
    public static int Solution(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ведите количество чисел");
        int count = scan.nextInt();
        System.out.println("Ведите числа");
        int[] mass = new int[count];
        mass[0]  = scan.nextInt();
        int min = mass[0];
        int index = 0;
        for (int i = 1; i < count; i++ ){
            mass[i] = scan.nextInt();
            if (min > mass[i]){
                min = mass[i];
                 index = i;
            }
        }
        return index+1;
    }

    public static void main(String[] args){
        System.out.println(Solution());

    }
}
