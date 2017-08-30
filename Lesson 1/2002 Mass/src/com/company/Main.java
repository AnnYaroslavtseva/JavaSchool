package com.company;
import java.util.Scanner;

public class Main {

    public static int Sum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите количество чисел");
        int count = scan.nextInt(); //считываем количество чисел
        System.out.println("ВВедите элементы массива");
        int  sum = 0 ;
        for (int i = 0; i < count; i++) {
            sum = sum + scan.nextInt();
        }
        return sum;
    }

    public static void main(String[] args) {

	System.out.println(Sum());
    }
}
