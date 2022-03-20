package MAIN;

import java.util.Scanner;

public class Strings5 {
    public void media(Scanner sc) {
        System.out.println("Dime tu nombre y apellido: ");
        String nombreApellido = sc.nextLine().trim().toUpperCase();

        System.out.print(nombreApellido.charAt(0));
        for (int i = 0; i < nombreApellido.length(); i++) {
            if (nombreApellido.charAt(i) == ' ') {
                System.out.print(nombreApellido.charAt(i + 1));
            }
        }
        System.out.println();
    }
}
