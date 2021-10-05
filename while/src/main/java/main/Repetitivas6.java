package main;

import java.util.Scanner;

public class Repetitivas6 {
    public void media(Scanner sc){
        int numMinimo;
        int numMaximo;

        System.out.print("Escribeme 2 numeros distintos, ahora escribeme uno: ");
        int numero1 = sc.nextInt();
        System.out.print("Escribeme el otro numero a continuación: ");
        int numero2 = sc.nextInt();

        if (numero1 > numero2) {
            numMinimo = numero2;
            numMaximo = numero1;
        } else {
            numMinimo = numero1;
            numMaximo = numero2;
        }

        for (int progreso = numMinimo + 1; progreso < numMaximo; progreso++) {
            if (progreso % 2 == 0) {
                System.out.println(progreso);
            }
        }
    }
}
