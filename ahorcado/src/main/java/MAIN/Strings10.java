package MAIN;

import java.util.Scanner;

public class Strings10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribeme una palabra palindroma (solo una palabra y sin espacios: ");
        String palindromo = sc.nextLine();
        boolean esPalindromo = true;
        int fin = palindromo.length();

        if (palindromo.contains(" ")) {
            do {
                System.out.println("Otra vez, escribe una palabra sin espacios.");
                palindromo = sc.nextLine();
            } while (!palindromo.contains(" "));
        }
        for (int principio = 0; principio < palindromo.length(); principio++) {
            if (palindromo.charAt(principio) == palindromo.charAt(fin - 1) || !esPalindromo) {
                fin--;
            } else {
                esPalindromo = false;
            }
        }
        if (esPalindromo) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindormo");
        }
    }
}
