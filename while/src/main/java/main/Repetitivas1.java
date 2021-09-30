package main;

import java.util.Scanner;

public class Repetitivas1 {
    public void media(Scanner sc, int i){

        int factorial = 1;
        System.out.print("Escribeme el numero que te haga el factorial: ");

        for (int numero = sc.nextInt();numero != 0; numero--) {
            System.out.println(factorial+ " = "+ factorial+ " * "+numero);
            factorial = factorial * numero;
        }
        System.out.println("Respuesta fianl: " +factorial);
    }
}

