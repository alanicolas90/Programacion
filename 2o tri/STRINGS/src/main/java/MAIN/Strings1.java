package MAIN;

import java.util.Scanner;

public class Strings1 {
    public void media(Scanner sc) {
        System.out.println("dime una frase.");
        String texto = sc.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            System.out.println(caracter);
        }
    }
}
