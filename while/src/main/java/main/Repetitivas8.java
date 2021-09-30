package main;

import java.util.Scanner;

public class Repetitivas8 {
    public void media(Scanner sc, int i){
        int limiteInferior;
        int limiteSuperior;
        int numeroInsertado;
        int contador = 0;
        int suma = 0;

        do {
            System.out.print("Dime el valor del límite inferior: ");
            limiteInferior = sc.nextInt();

            System.out.print("Dime el valor del límite superior: ");
            limiteSuperior = sc.nextInt();

            if (limiteInferior > limiteSuperior) {
                System.out.println("ERROR, ponga los valores de nuevo.");
            }
        } while (limiteInferior > limiteSuperior);

        do {
            System.out.print("Intorduce un numero: ");
            numeroInsertado = sc.nextInt();
            if (numeroInsertado != 0) {
                if (numeroInsertado < limiteSuperior && numeroInsertado > limiteInferior) {
                    suma = suma + numeroInsertado;
                } else if (numeroInsertado >= limiteSuperior || numeroInsertado <= limiteInferior) {
                    System.out.println("Has introducido un numero fuera del limite o igal a uno de los limites.");
                } else {
                    contador++;
                }
            }
        } while (numeroInsertado != 0);
        System.out.println("la suma de los valores introducidos es:"+ suma);
        System.out.println("estos son los valores que se han salido del intervalo: " + contador);
    }
}
