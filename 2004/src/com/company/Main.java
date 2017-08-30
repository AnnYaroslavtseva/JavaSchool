package com.company;
import  java.util.Scanner;

public class Main {
    public static int Solution(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите год");
        int year = scan.nextInt();
        if (((year % 4 == 0)&&(year % 100 != 0 ))||(year % 400 == 0)){
            return 1;
        }
        else{
            return 0;
        }

    }

    public static void main(String[] args) {
    System.out.println(Solution());
    }
}
