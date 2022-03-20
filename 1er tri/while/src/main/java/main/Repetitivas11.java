package main;

import java.util.Scanner;

public class Repetitivas11 {
    public void media(Scanner sc) {

        System.out.print("Dime un numero y yo te digo si es primo o no: ");
        double numeroEscrito = sc.nextInt();
        boolean esPrimo = true;
        int divisor=2;

        while ((divisor <numeroEscrito) && esPrimo) {
            if (numeroEscrito % divisor == 0) {
                esPrimo = false;
            }
            divisor=divisor+1;
        }
        if (esPrimo == false) {
            System.out.println("NO ES NUMERO PRIMO");
        }
        else{
            System.out.println("SI ES PRIMO");
        }
    }
}

