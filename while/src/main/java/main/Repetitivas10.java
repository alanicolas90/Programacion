package main;

import java.util.Scanner;

public class Repetitivas10 {
    public void media(Scanner sc,int i) {
        for (int tablaMultiplicar = 5; tablaMultiplicar != -1; tablaMultiplicar--) {
            System.out.println("TABLA DEL " + tablaMultiplicar);

            for (int numero = 10; numero != 0; numero--) {
                int multiplicar = tablaMultiplicar * numero;
                System.out.println(tablaMultiplicar + "*" + numero + " = " + multiplicar);
            }
        }
    }
}
