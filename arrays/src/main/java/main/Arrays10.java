package main;

import java.util.Random;
import java.util.Scanner;

public class Arrays10 {
    public void media() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int[] guardar = new int[10];

        Random r = getR();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(10);
            guardar[i] = numbers[i];
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        System.out.println("Dime cuantas posiciones quieres que se muevan los arrays:");
        int mover = sc.nextInt();
        mover = mover % 10;

        for (int i = (numbers.length - 1 - mover); i >= 0; i--) {
            numbers[i + mover] = numbers[i];
        }
        int contador = (numbers.length - mover);
        for (int i = 0; i < mover; i++) {
            numbers[i] = guardar[contador];
            contador++;
        }


        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private Random getR() {
        return new Random();
    }
}
