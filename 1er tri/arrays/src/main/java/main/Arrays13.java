package main;

import java.util.Random;

public class Arrays13 {
    public void media() {
        Random r = getR();
        int positionNumberPar = 0;
        int positionNUmberImpar = 0;
        int j = 0;
        int k = 0;


        int[] allNumbers = new int[10];
        int[] numbersPares = new int[10];
        int[] numbersImpares = new int[10];
        int[] positionPar = new int[10];
        int[] positionImpar = new int[10];

        for (int i = 0; i < allNumbers.length; i++) {
            allNumbers[i] = r.nextInt(40);
            System.out.print(allNumbers[i] + " ");
        }
        System.out.println();

        //números pares

        for (int i = 0; i < allNumbers.length; i++) {
            if (allNumbers[i] % 2 == 0) {
                numbersPares[positionNumberPar] = allNumbers[i];
                positionNumberPar++;
            } else if (allNumbers[i] % 2 != 0) {
                numbersImpares[positionNUmberImpar] = allNumbers[i];
                positionNUmberImpar++;
            }
        }
        for (int i = 0; i < allNumbers.length; i++) {
            if (i % 2 == 0) {
                positionPar[j] = allNumbers[i];
                j++;
            }else {
                positionImpar[k]=allNumbers[i];
                k++;
            }
        }
        System.out.print("Los números pares son: ");
        //leer todos los arrays
        for (int i = 0; i < numbersPares.length; i++) {
            System.out.print(numbersPares[i]+" ");
        }
        System.out.println();

        System.out.println("Los números impares son: ");

        for (int i = 0; i < numbersImpares.length; i++) {
            System.out.print(numbersImpares[i]+" ");
        }
        System.out.println();

        System.out.println("Los números que la posición es par: ");
        for (int i = 0; i < positionPar.length; i++) {

            System.out.print(positionPar[i]+" ");
        }
        System.out.println();

        System.out.println("Los números que la posición es impar");
        for (int i = 0; i < positionImpar.length; i++) {
            System.out.print(positionImpar[i]+" ");
        }
        System.out.println();
    }

    private Random getR() {
        return new Random();
    }
}
