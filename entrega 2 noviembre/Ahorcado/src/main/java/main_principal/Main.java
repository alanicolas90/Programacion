package main_principal;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder palabraOcultada = new StringBuilder();
        StringBuilder letrasUtilizadas = new StringBuilder();

        // definir valores iniciales
        int intentosRestantes = 9;
        char letraPrueba;
        boolean adivinado = false;
        String intentoAdivinar;

        //palabra a encontrar
        Faker crearPalabra = new Faker();
        String palabra = crearPalabra.animal().name();//palabra que queremos encontrar(serán animales en inglés)

        // la palabra ocultada.
        new Ocultar().extracted(palabraOcultada, palabra);

        do {
            System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
            System.out.println("Las letras utilizadas y no están en la palabra:" + letrasUtilizadas);
            System.out.println(palabraOcultada);
            System.out.println("Escríbeme la siguiente letra(escriba solo un carácter): ");
            intentoAdivinar = sc.nextLine().toLowerCase();
            do {
                //que sea una sola letra

                if (intentoAdivinar.length() == palabra.length()) {
                    if (intentoAdivinar.equals(palabra)) {
                        adivinado = true;
                    } else {
                        intentosRestantes--;
                        new Dibujitos().extracted(intentosRestantes);
                    }
                } else if (intentoAdivinar.length() != 1) {
                    System.out.println("VALOR INCORRECTO, por favor introduzca solo 1 carácter por favor o la palabra entera(que tenga la longitud de la palabra o será invalido:");
                    intentoAdivinar = sc.nextLine().toLowerCase();
                }
                // pedirle letra, comprobar que la letra sea nueva
                //saber si la letra ha sido utilizado antes o no
                do {
                    if (letrasUtilizadas.indexOf(intentoAdivinar) != -1) {
                        System.out.println("La letra escrita ya la has utilizado, por favor pruebe con otro: ");
                        System.out.println("Las letras utilizadas anteriormente:" + letrasUtilizadas);
                        intentoAdivinar = sc.nextLine().toLowerCase();
                    }
                } while(letrasUtilizadas.indexOf(intentoAdivinar)!=-1);
            } while (!adivinado && intentoAdivinar.length() != 1 || letrasUtilizadas.indexOf(intentoAdivinar) != -1);

            letrasUtilizadas.append(intentoAdivinar).append(" ");
            //si la letra está o no en la palabra
            if (palabra.contains(intentoAdivinar)) {
                // DIFÍCIL mostrar palabra ocultada *** ****   *A* *****
                if (intentoAdivinar.length() == 1) {
                    letraPrueba = intentoAdivinar.charAt(0);
                    for (int i = 0; i < palabra.length(); i++) {

                        if (palabra.charAt(i) == letraPrueba) {
                            palabraOcultada.setCharAt(i, palabra.charAt(i));
                        }
                    }
                    System.out.println(palabraOcultada);
                }
            }
            //si la letra no está que me quite un intento
            else {
                System.out.println("la letra no está en la palabra");
                intentosRestantes--;
                System.out.println(palabraOcultada);
            }
            //bucle hasta oportunidades o que acierte
            if (palabraOcultada.toString().equals(palabra)) {
                adivinado = true;
            }
            // si no esta saco ahorcado
            if (!adivinado) {
                new Dibujitos().extracted(intentosRestantes);
            }

        } while (!adivinado && intentosRestantes > 0);

        if (adivinado) {
            System.out.println("FELICIDADES HAS GANADO");
        } else {
            System.out.println("HAS PERDIDO");
            System.out.println("La solución era: " + palabra);
        }
        System.out.println("Se acabó la partida.");
    }
}