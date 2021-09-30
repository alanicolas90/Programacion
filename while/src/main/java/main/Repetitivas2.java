package main;

import java.util.Scanner;

public class Repetitivas2 {
    public void media(Scanner sc, int i){
        int numeroRandom =(int) (Math.random() * 101);
        int intentosRestantes = 10;
        System.out.println("Intenta adivinar el numero entre 1 y 100, solo tienes 10 intentos.");

        int intentoAdivinar;
        do {
            System.out.println("numero de intentos restantes: " + intentosRestantes);
            System.out.print("Escriba aquí su intento: ");
            intentoAdivinar = sc.nextInt();

            if(intentoAdivinar==numeroRandom) {
                System.out.println("Muy bien lo has adivinado!!");
                break;
            }
            else if (intentoAdivinar < numeroRandom) {
                System.out.println("número incorrecto, el numero que buscas es mayor");
                intentosRestantes--;
            }
            else {
                System.out.println("el numero que buscas es menor.");
                intentosRestantes--;
            }

        } while (numeroRandom != intentoAdivinar && intentosRestantes > 0);

        if(intentosRestantes==0) {
            System.out.println("Se te han acabado los intentos el numero que buscabas era "+numeroRandom);
        }


    }




    }

