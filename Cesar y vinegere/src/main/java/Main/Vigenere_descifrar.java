package Main;

import java.util.Scanner;

public class Vigenere_descifrar {
    public void media(Scanner sc){
        System.out.println("Introduzca aqui el texto para cifrarlo: ");
        String fraseCodificar = sc.nextLine();

        System.out.println("Ahora la palabra para cifrar: ");
        String cifrado = sc.nextLine();
        char letraNueva;
        char letraClave;
        int posClave;
        int cambio;
        int contador=0;

        for (int i = 0; i < fraseCodificar.length(); i++) {

            if (Character.isLowerCase(fraseCodificar.charAt(i))) {
                cifrado=cifrado.toLowerCase();
                posClave = (i+contador) % cifrado.length();
                letraClave = cifrado.charAt(posClave);
                cambio = letraClave - 97;
                letraNueva = fraseCodificar.charAt(i);
                int sumaChares = letraNueva - cambio - 97;
                letraNueva = (char) (((sumaChares+26) % 26) + 97);
                System.out.print(letraNueva);
            } else if (Character.isUpperCase(fraseCodificar.charAt(i))) {
                cifrado=cifrado.toUpperCase();
                posClave = (i+contador) % cifrado.length();
                letraClave = cifrado.charAt(posClave);
                cambio = letraClave - 65;
                letraNueva = fraseCodificar.charAt(i);
                int sumaChares = letraNueva - cambio - 65;
                letraNueva = (char) (((sumaChares +26) % 26) + 65);
                System.out.print(letraNueva);
            } else {
                contador--;
                System.out.print(fraseCodificar.charAt(i));
            }
        }
        System.out.println();

    }
}
