package MAIN;

import java.util.Scanner;

public class Strings9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pon una frase: ");
        String frase = sc.nextLine();

        System.out.println("Ahora el fragmento que buscas: ");
        String loQueBuscas = sc.nextLine();
        frase.contains(loQueBuscas);
        if (frase.contains(loQueBuscas)) {
            System.out.println("Si contiene ese fragmento.");
        } else {
            System.out.println("NO contiene ese fragmento.");
        }
    }
}
