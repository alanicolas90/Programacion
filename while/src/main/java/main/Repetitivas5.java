package main;

import java.util.Locale;
import java.util.Scanner;

public class Repetitivas5 {
    public void media(Scanner sc){
        System.out.print("Dime un caracter(ponga un espacio para parar el programa): ");
        String palabra = sc.nextLine();

        while (!palabra.equals(" ")) {

            int longitud = palabra.length();

            for (int posicionCaracter = 0; posicionCaracter < longitud; posicionCaracter++) {
                char caracter = palabra.toUpperCase().charAt(posicionCaracter);

                if (caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U') {
                    System.out.println("VOCALES");
                } else {
                    System.out.println("NO SON VOCALES");
                    break;
                }
            }
            System.out.print("Dime otros caracteres: ");
            palabra = sc.nextLine();
        }

        if (palabra.equals(" ")) {
            System.out.println("FIN");
        }
    }
}
