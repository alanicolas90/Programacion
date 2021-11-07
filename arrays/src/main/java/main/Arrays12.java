package main;

import java.util.Random;
import java.util.Scanner;

public class Arrays12 {
    public void media() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        Random r = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(20);
            System.out.println("La posicion (" + i + ") la ocupa:\n" + numbers[i] + " ");
        }

        System.out.println("Dime una posición entre 0-9 y la eliminaré");
        int position = sc.nextInt();

        for (int i = position; i < 9; i++) {
            numbers[i] = numbers[1 + i];
        }

        for (int i = 0; i < 9; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

    }
}
