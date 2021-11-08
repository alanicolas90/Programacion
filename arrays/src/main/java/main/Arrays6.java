package main;

import java.util.Random;

public class Arrays6 {
    public void media() {
        int[] numbers1 = new int[12];
        int[] numbers2 = new int[12];
        int[] numbersRemix = new int[24];
        Random r = getR();
        int counter = 0;


        for (int i = 0; i < numbers1.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers1[i] = randomNumber;
            System.out.print(randomNumber + " ");
        }
        System.out.println();

        for (int i = 0; i < numbers2.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers2[i] = randomNumber;
            System.out.print(randomNumber + " ");
        }

        for (int i = 0; i < numbers1.length; i += 3) {

            for (int j = 0; j < 3; j++) {
                numbersRemix[counter] = numbers1[i + j];
                counter++;
            }
            for (int j = 0; j < 3; j++) {
                numbersRemix[counter] = numbers2[i + j];
                counter++;
            }
        }

        for (int i = 0; i < numbersRemix.length; i++) {
            System.out.print(numbersRemix[i] + " ");
        }
        System.out.println();
    }

    private Random getR() {
        return new Random();
    }
}

