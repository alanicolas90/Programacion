package MAIN;

import java.util.Scanner;

public class Strings7 {
    public void media(Scanner sc) {
        System.out.println("Dime una frase cualquiera: ");
        String frase = sc.nextLine();

        System.out.println("La letra que quieres cambiar de la frase: ");
        String letraCambiar = sc.nextLine();
        if (letraCambiar.length() != 1) {
            do {
                System.out.println("VALOR INCORRECTO, porfavor introduzca solo 1 caracter porfavor:");
                letraCambiar = sc.nextLine();
            } while (letraCambiar.length() != 1);
        }

        System.out.println("Letra por la que quieres sustituir: ");
        String letraACambiar = sc.nextLine();
        if (letraACambiar.length() != 1) {
            do {
                System.out.println("VALOR INCORRECTO, porfavor introduzca solo 1 caracter porfavor:");
                letraACambiar = sc.nextLine();
            } while (letraACambiar.length() != 1);
        }
        System.out.println("La frase sería: ");
        System.out.println(frase.replace(letraCambiar, letraACambiar));
    }
}

