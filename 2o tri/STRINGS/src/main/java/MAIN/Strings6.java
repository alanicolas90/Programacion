package MAIN;

import java.util.Scanner;

public class Strings6 {
    public void media(Scanner sc) {
        System.out.println("Dime una frase y te la devuelvo al reves: ");
        StringBuilder frase = new StringBuilder(sc.nextLine());

        System.out.println(frase.reverse());
    }
}
