package main;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder palabraOcultada = new StringBuilder();
        StringBuilder letrasUtilizadas = new StringBuilder();

        // definir valores iniciales
        int intentosRestantes = 9;
        char letraPrueba = 0;
        boolean adivinado = false;
        String intentoAdivinar;

        //palabra a encontrar
        Faker crearPalabra = new Faker();
        String palabra = crearPalabra.animal().name();//palabra que queremos encontrar(serán animales en inglés)

        // la palabra ocultada.
        for (int letraPalabra = 0; letraPalabra < palabra.length(); letraPalabra++) {
            if (Character.isLetter(palabra.charAt(letraPalabra))) {
                palabraOcultada.append("*");
            } else {
                palabraOcultada.append(palabra.charAt(letraPalabra));
            }
        }

        // el numero de oportunidades
        System.out.println("Tienes " + intentosRestantes + " intentos restantes.");

        do {
            System.out.println(palabraOcultada);
            System.out.println("Las letras utilizadas y no están en la palabra:" + letrasUtilizadas);
            do {
                System.out.println("Escribeme la siguiente letra(escriba solo un caracter) o la solución: ");
                intentoAdivinar = sc.nextLine().toLowerCase();

                if (intentoAdivinar.length() == palabra.length()) {
                    if (intentoAdivinar.equals(palabra)) {
                        adivinado = true;
                    } else {
                        System.out.println("Esta no es la solución, se te va a restar un intento. ");
                        intentosRestantes--;
                        Dibujitos.extracted(intentosRestantes);
                    }
                } else if (intentoAdivinar.length() != 1) {
                    System.out.println("VALOR INCORRECTO, se te ca a restar un intento.");
                }
                //que sea una sola letra
                if (intentoAdivinar.length() == 1) {
                    letraPrueba = intentoAdivinar.charAt(0);
                }
                // pedirle letra, comprobar que la letra sea nueva
                //saber si la letra ha sido utilizado antes o no
                if (letrasUtilizadas.indexOf(String.valueOf(letraPrueba)) != -1) {
                    System.out.println("La letra escrita ya la has utilizado, porfavor pruebe con otro: ");
                    intentoAdivinar = sc.nextLine().toLowerCase();
                }
                System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
            } while (!adivinado && intentoAdivinar.length() != 1 || letrasUtilizadas.indexOf(intentoAdivinar) != -1);

            letrasUtilizadas.append(letraPrueba);
            //si la letra está o no en la palabra
            intentosRestantes = Estaenlapalabraono.getIntentosRestantes(palabraOcultada, intentosRestantes, letraPrueba, intentoAdivinar, palabra);

            //bucle hasta oportunidades o que acierte

            if (palabraOcultada.toString().equals(palabra)) {
                adivinado = true;
            }
            // si no esta saco ahorcado
            Dibujitos.extracted(intentosRestantes);

        } while (!adivinado && intentosRestantes > 0);
        if (adivinado) {
            System.out.println("FELICIDADES HAS GANADO");
        } else {
            System.out.println("HAS PERDIDO");
            System.out.println("La solución era: "+palabra);
        }
        System.out.println("Se acabó la partida.");
    }

}
