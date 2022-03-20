package MAIN;

import java.util.Scanner;

public class Strings8 {
    public void media(Scanner sc) {
        System.out.println("Pon una frase con mayusculas y minusculas: ");
        String frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLowerCase(frase.charAt(i))) {
                System.out.print(Character.toUpperCase(frase.charAt(i)));
            } else if (Character.isUpperCase(frase.charAt(i))) {
                System.out.print(Character.toLowerCase(frase.charAt(i)));
            } else {
                System.out.print(frase.charAt(i));
            }
        }
        System.out.println();
    }
}
