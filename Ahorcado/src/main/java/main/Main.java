package main;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder palabraOcultada = new StringBuilder();
        StringBuilder letrasUtilizadas = new StringBuilder();

        // definir valores iniciales
        int intentosRestantes = 2;
        String letraPrueba;

        //palabra a encontrar
        Faker crearPalabra = new Faker();
        String palabra = crearPalabra.animal().name();//palabra que queremos encontrar(serán animales)

        // la palabra ocultada.
        for (int letraPalabra = 0; letraPalabra < palabra.length(); letraPalabra++) {
            if (Character.isLetter(palabra.charAt(letraPalabra))) {
                palabraOcultada.append("*");
            } else {
                palabraOcultada.append(palabra.charAt(letraPalabra));
            }
        }
        System.out.println(letrasUtilizadas);

        // el numero de oportunidades
        do {
            System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
            System.out.println("Escribeme la siguiente letra(escriba solo un caracter): ");
            letraPrueba = sc.nextLine();
            do {
                //que sea una sola letra
                if (letraPrueba.length() != 1) {
                    System.out.println("VALOR INCORRECTO, porfavor introduzca solo 1 caracter porfavor:");
                    letraPrueba = sc.nextLine();
                }
                // pedirle letra, comprobar que la letra sea nueva
                //saber si la letra ha sido utilizado antes o no
                if (letrasUtilizadas.indexOf(letraPrueba) != -1) {
                    System.out.println("La letra escrita ya existe, porfavor pruebe con otro: ");
                    letraPrueba = sc.nextLine();
                }
            } while (letraPrueba.length() != 1 || letrasUtilizadas.indexOf(letraPrueba) != -1 || letraPrueba.length()==palabra.length());

            letrasUtilizadas.append(letraPrueba);




            System.out.println(letrasUtilizadas);

            //bucle hasta oportunidades o que acierte


            // DIFICIL mostrar palabra ocultada *** ****   *A* *****

            // o pedir frase  jugarsela

            // ver si esta  o no

            // si no esta saco ahorcado
/*
            if (intentosRestantes <= 7 && intentosRestantes > 0) {
                switch (intentosRestantes) {
                    case 7:
                        System.out.println(" ___________\n |         |\n |\n |\n |\n |\n/ \\");
                        break;
                    case 6:
                        System.out.println(" ___________\n |         |\n |        ( )\n |\n |\n |\n/ \\");
                        break;
                    case 5:
                        System.out.println(" ___________\n |         |\n |        ( )\n |         |\n |\n |\n/ \\");
                        break;
                    case 4:
                        System.out.println(" ___________\n |         |\n |        ( )\n |        /|\n |\n |\n/ \\");
                        break;
                    case 3:
                        System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |\n |\n/ \\");
                        break;
                    case 2:
                        System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |        /\n |\n/ \\");
                        break;
                    case 1:
                        System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |        / \\ \n |\n/ \\");
                        break;

                }
            }*/
            intentosRestantes--;
        } while (intentosRestantes != 0);
        // si esta saco palabra con caracteres descubiertos
    }

}
