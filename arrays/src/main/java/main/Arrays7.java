package main;

import java.util.Random;

public class Arrays7 {
    public void media() {
        int[] numbers = new int[10];
        boolean esCreciente = true;
        boolean esDecreciente = true;

        /*
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
            System.out.print(numbers[i]+" ");
        }

        //números decrecientes

        int j=10;
        for (int i = 0; i < numbers.length; i++,j--) {
            numbers[i] = j;
            System.out.print(numbers[i]+" ");
        }
         */


        //numero aleatorio
        Random r= new Random();

        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers[i]= randomNumber;
            System.out.print(numbers[i]+" ");
        }

        System.out.println();
        for (int i = numbers.length - 1; i != -1; i--) {
            if (i > 0) {
                if (numbers[i] < numbers[i - 1]) {
                    esCreciente = false;
                }
                if (numbers[i] > numbers[i - 1]) {
                    esDecreciente = false;
                }
            }
        }
        if (esCreciente) {
            System.out.println("Es creciente");
        } else if (esDecreciente) {
            System.out.println("Es decreciente");
        } else {
            System.out.println("Es aleatorio");
        }
        //saber si es decreciente
        //es aleatorio

    }
}

