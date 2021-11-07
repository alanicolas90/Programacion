package main;

import java.util.Random;

public class Arrays2 {
    public void media(){

        int[] numbers = new int[5];
        Random r = getR();
        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers[i]= randomNumber;
            System.out.println(randomNumber);
        }
        for (int i = numbers.length-1; i!=-1; i--) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }

    private Random getR() {
        return new Random();
    }
}
