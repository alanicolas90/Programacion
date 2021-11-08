package main;


import java.util.Random;

public class Arrays5 {
    public void media() {

        int[] numbers1 = new int[10];
        int[] numbers2 = new int[10];
        int[] numbersRemix = new int[20];
        Random r = getR();
        int j = 0;

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
        System.out.println();
        for (int i = 0; i < numbers1.length; i++) {

            numbersRemix[j] = numbers1[i];
            j++;

            numbersRemix[j] = numbers2[i];
            j++;
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
