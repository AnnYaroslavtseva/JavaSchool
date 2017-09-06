package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //  Созд объект класса сканнер, ятобы считывать с консоли
        System.out.println("Enter array length: ");
        int size = scan.nextInt(); // Считываем с клавиатуры размер массива
        int array[] = new int[size]; // Создаём массив размером в size
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++){
            array[i] = scan.nextInt();//заполняем массив вводимыми элементами
        }

        for (int j = 0; j < 2; j++) {  //цикл чтоб пройти по массивуу 2 раза
            int max = array[0];
            for (int i = 1; i < size; i++) {
                if (array[i] > max) {
                    max = array[i];//находим максимум
                }
            }
            for (int k = 0; k < size; k++) {
                if (array[k] == max) {//проходим массив еще раз. чтобы выявить есть ли несколько максимумов
                    array[k] = max / 2;//делим максимумы и записыаем
                }
            }
        }


        for (int i = 0; i < size; i++) {
            System.out.print(array[i]+" ");
        }

    }
}
