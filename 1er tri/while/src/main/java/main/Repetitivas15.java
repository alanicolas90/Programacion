package main;

import java.util.Scanner;

public class Repetitivas15 {
    public void media(Scanner sc) {
        int mes = 1;
        int dinero;

        for (dinero = 5; mes != 21; mes++) {
            dinero = dinero * 2;
            System.out.println("El mes "+mes+" tiene que pagar: "+dinero+"€");
        }
        System.out.println("Despues de 20 meses vas a tener que pagar: " + dinero+"€");

    }
}
