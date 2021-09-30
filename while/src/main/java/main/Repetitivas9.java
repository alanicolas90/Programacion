package main;

import java.util.Scanner;

public class Repetitivas9 {
    public void media(Scanner sc, int i) {
        int potencia = 1;
        int numeroExponente;

        System.out.print("Introduce la base de la potencia: ");
        int basePotencia = sc.nextInt();
        System.out.print("Introduce el exponente de la potencia(positivo): ");

        for (numeroExponente = sc.nextInt(); numeroExponente != 0; numeroExponente--) {
            if (numeroExponente < 0) {
                System.out.print("Escribe otro exponente PERO EN POSITIVO: ");
                numeroExponente = sc.nextInt();
            }
            potencia = potencia * basePotencia;
        }
        System.out.println("El resultado de la potencia es: " + potencia);
    }
}
