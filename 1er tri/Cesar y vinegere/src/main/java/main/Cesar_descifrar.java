package main;

import java.util.Scanner;

public class Cesar_descifrar {
    public void media(Scanner sc) {
        System.out.println("Pongame a continuacion la frase que desea descifrar con Cesar:");
        String fraseDescodificar = sc.nextLine();
        System.out.println("pongame el numero: ");
        int numeroSaltos = sc.nextInt();
        char letraNueva;

        for (int i = 0; i < fraseDescodificar.length(); i++) {
            if (Character.isLowerCase(fraseDescodificar.charAt(i))) {
                letraNueva = fraseDescodificar.charAt(i);
                letraNueva = (char) (letraNueva - 97);
                letraNueva = (char) (((letraNueva - numeroSaltos + 26) % 26) + 97);
                System.out.print(letraNueva);

            } else if (Character.isUpperCase(fraseDescodificar.charAt(i))) {
                letraNueva = fraseDescodificar.charAt(i);
                letraNueva = (char) (letraNueva - 65);
                letraNueva = (char) (((letraNueva - numeroSaltos + 26) % 26) + 65);
                System.out.print(letraNueva);
            } else {
                System.out.print(fraseDescodificar.charAt(i));
            }
        }
        System.out.println();
    }
}
