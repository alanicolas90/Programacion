package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] lineaArrays1 = new int[]{-10, -6, -5, -3, -2, -1, 4, 6, 7, 9};
        int[] lineaArrays2 = new int[]{-1, -6, -4, -3, -2, -1, 10, 3, 8, 5};
        int[] lineaArrays3 = new int[]{-10, -1, -5, -3, -2, -1, 4, 6, 7, 9};

        System.out.println(Arrays.toString(lineaArrays1));

        boolean line1IsOk = true;
        boolean line2IsOk = true;
        boolean line3IsOk = true;

        System.out.println("If result is false it means format it´s not valid\nIf result is true it means format is valid\n");

        //Comprobamos si la línea de arrays está bien
        //Primera linea de arrays
        for (int i = 1; i < lineaArrays1.length && line1IsOk; i++) {
            if (lineaArrays1[i] < lineaArrays1[i - 1]) {
                line1IsOk = false;
            }
        }
        //Segunda linea de arrays
        for (int i = 1; i < lineaArrays2.length && line2IsOk; i++) {
            if (lineaArrays2[i] < lineaArrays2[i - 1]) {
                line2IsOk = false;
            }
        }
        //tercera linea de arrays
        for (int i = 1; i < lineaArrays3.length && line3IsOk; i++) {
            if (lineaArrays3[i] < lineaArrays3[i - 1]) {
                line3IsOk = false;
            }
        }
        System.out.println("The line Arrays1 is: " + line1IsOk);
        System.out.println("The line Arrays2 is: " + line2IsOk);
        System.out.println("The line Arrays3 is: " + line3IsOk);

        //ENCRIPTAR
        int aux;
        if (line1IsOk) {

            for (int i = 0; i < lineaArrays1.length; i++) {
                for (int j = 0; j < lineaArrays1.length - 1; j++) {
                    if (Math.abs(lineaArrays1[j]) > Math.abs(lineaArrays1[j + 1])) {
                        aux = lineaArrays1[j];
                        lineaArrays1[j] = lineaArrays1[j + 1];
                        lineaArrays1[j + 1] = aux;
                    }
                }
            }
            System.out.println(Arrays.toString(lineaArrays1));
        }
        //aquí irían las otras encriptaciones en cada caso de linea de arrays

        //DESENCRIPTAR
        for (int i = 0; i <lineaArrays1.length; i++) {
            for (int j = 0; j < lineaArrays1.length-1; j++) {
                if (lineaArrays1[j] > lineaArrays1[j + 1]) {
                    aux = lineaArrays1[j];
                    lineaArrays1[j] = lineaArrays1[j+1];
                    lineaArrays1[j+1]=aux;
                }
            }
        }
        System.out.println(Arrays.toString(lineaArrays1));
    }
}


