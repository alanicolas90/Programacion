package MAIN;

import java.util.Locale;
import java.util.Scanner;

public class Strings3 {
    public void media(Scanner sc) {
        System.out.println("Ponga una frase: ");
        String frase = sc.nextLine().toLowerCase();

        System.out.println("Dime una letra para decir cuantas veces aparece (solo tomara la primera letra): ");
        char comprobacion = sc.next().toLowerCase().charAt(0);

        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == comprobacion) {
                contador++;
            }
        }
        System.out.println("aparece: " + contador + " veces.");
    }
}
