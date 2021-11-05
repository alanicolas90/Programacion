package main;

import java.util.Arrays;
import java.util.Random;

public class Arrays1 {
    public void media() {

        int[] numbers = new int[5];
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers[i]= randomNumber;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
}
