package main;

import java.util.Scanner;

public class Repetitivas20 {
    public void media(Scanner sc, int i) {
        boolean esPrimo;
        int numero = 3;
        int contador = 1;
        int divisor;

        System.out.print("Dime cuantos numeros primos quieres: ");
        int cantidadPrimos = sc.nextInt();

        System.out.println("1) 2");

        while (contador < cantidadPrimos) {
            esPrimo = true;
            divisor = 3;
            while ((divisor <numero) && esPrimo) {
                if (numero % divisor == 0) {
                    esPrimo = false;
                }
                divisor = divisor + 2;
            }
            if (esPrimo) {
                contador=contador+1;
                System.out.println(contador + ") " + numero);
            }
            numero = numero + 2;

        }


    }


}

