package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите число");
        int count = scan.nextInt();
        int MaxPower = 0;
        while (count % 2 == 0 ) {
            count /= 2;
            MaxPower++;
        };
        System.out.println(MaxPower);

    }
}
