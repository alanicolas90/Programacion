package main;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Repetitivas11 {
    public void media(Scanner sc) {

        System.out.print("Dime un numero y yo te digo si es primo o no: ");
        double numeroEscrito = sc.nextInt();
        double comprobacion = 0;

        for (double division = numeroEscrito; division != 1; division--) {

            comprobacion = numeroEscrito % division;
        }
        if (comprobacion == 0) {
            System.out.println("NO ES NUMERO PRIMO");
        } else {
            System.out.println("SI ES PRIMO");
        }
    }
}
