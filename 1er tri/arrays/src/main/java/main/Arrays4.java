package main;

import java.util.Random;

public class Arrays4 {
    public void media() {
        int[] numbers = new int[10];
        Random r = getR();
        int lastPosition = (numbers.length - 1);
        boolean midPosition = false;

        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers[i] = randomNumber;
            System.out.println(randomNumber);
        }

        for (int i = 0; i < numbers.length && !midPosition; i++, lastPosition--) {
            if (lastPosition < i) {
                midPosition = true;
            } else {
                System.out.print(numbers[i] + " ");
                System.out.print(numbers[lastPosition] + " ");
            }
        }
        System.out.println();
    }

    private Random getR() {
        return new Random();
    }
}
