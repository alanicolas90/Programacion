package main;

public class Estaenlapalabraono {
    public static int getIntentosRestantes(StringBuilder palabraOcultada, int intentosRestantes, char letraPrueba, String intentoAdivinar, String palabra) {
        if (palabra.indexOf(intentoAdivinar) > -1) {
            System.out.println("esta letra si está en la palabra");
            // DIFICIL mostrar palabra ocultada *** ****   *A* *****
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letraPrueba) {
                    palabraOcultada.setCharAt(i, palabra.charAt(i));
                }
            }
        }
        //si la letra no está que me quite un intento
        else {
            System.out.println("la letra no está en la palabra");
            intentosRestantes--;
        }
        return intentosRestantes;
    }
}
