package main_principal;

public class Ocultar {
    public static void extracted(StringBuilder palabraOcultada, String palabra) {
        for (int letraPalabra = 0; letraPalabra < palabra.length(); letraPalabra++) {
            if (Character.isLetter(palabra.charAt(letraPalabra))) {
                palabraOcultada.append("*");
            } else {
                palabraOcultada.append(palabra.charAt(letraPalabra));
            }
        }
    }
}
