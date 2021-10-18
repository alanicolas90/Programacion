package MAIN;

import java.util.Scanner;

public class Strings4 {
    public void media(Scanner sc) {
        System.out.println("Introduce una frase a continuacion: ");
        String frase = sc.nextLine();
        int counter = 1;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
