package main;

import java.util.Random;

public class Arrays9 {
    public void media() {
        int[] numbers = new int[10];

        Random r = getR();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(10);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int saveLast = numbers[9];

        for (int i = (numbers.length - 2); i >= 0; i--) {
            numbers[i + 1] = numbers[i];
        }
        numbers[0] = saveLast;


        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private Random getR() {
        return new Random();
    }
}
