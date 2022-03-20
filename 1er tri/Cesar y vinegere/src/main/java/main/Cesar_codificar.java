package main;

import java.util.Scanner;

public class Cesar_codificar {

    public void media(Scanner sc) {
        System.out.println("Pongame a continuacion la frase que desea cifrar con Cesar:");
        String fraseCodificar = sc.nextLine();
        System.out.println("pongame el numero: ");
        int numeroSaltos = sc.nextInt();
        char letraNueva;

        //ñ- 241 y Ñ- 209

        for (int i = 0; i < fraseCodificar.length(); i++) {
            if (Character.isLowerCase(fraseCodificar.charAt(i))) {

                letraNueva = fraseCodificar.charAt(i);
                letraNueva = (char) (letraNueva - 97);
                letraNueva = (char) (((letraNueva + (numeroSaltos) % 26) + 97));
                System.out.print(letraNueva);

            } else if (Character.isUpperCase(fraseCodificar.charAt(i))) {
                letraNueva = fraseCodificar.charAt(i);
                letraNueva = (char) (letraNueva - 65);
                letraNueva = (char) (((letraNueva + numeroSaltos) % 26) + 65);
                System.out.print(letraNueva);
            } else {
                System.out.print(fraseCodificar.charAt(i));
            }
        }
        System.out.println();

    }
}
