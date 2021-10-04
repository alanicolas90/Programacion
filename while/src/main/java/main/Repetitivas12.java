package main;

import java.util.Scanner;

public class Repetitivas12 {
    public void media(Scanner sc) {
        int ahorrado = 0;

        for (int mes = 1; mes != 12 + 1; mes++) {

            System.out.print("En el mes " + mes + " cuanto vas a depositar? ");
            int depositado = sc.nextInt();
            ahorrado = ahorrado + depositado;

            System.out.println("Usted lleva " + ahorrado + "€ ahorrado en el mes " + mes);
        }
        System.out.println("Al final habrá ahorrado: " + ahorrado + "€");
    }
}
