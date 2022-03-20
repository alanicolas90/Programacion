package main;

import dao.DaoFilaTabla;
import ui.FilaTabla;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaoFilaTabla dao = new DaoFilaTabla();
        int option;
        String nombreDelJuego;

        do {
            System.out.println("Seleccione una de la siguientes opciones:\n" +
                    "1) Añadir juego.\n" +
                    "2) Cambiar puntuación de un juego.\n" +
                    "3) Borrar un juego.\n" +
                    "4) Obterner puntuación de un juego.\n" +
                    "5) Ver todos los juegos.\n\n" +
                    "0) Salir\n");

            System.out.print("Teclee el número de la opción: ");
            option = sc.nextInt();
            sc.nextLine();
            dao.add(new FilaTabla("queen", 0));


            switch (option) {
                case 1:

                    //pido el nombre del juego
                    System.out.println("digame el nombre del juego");
                    nombreDelJuego = sc.nextLine();


                    //pido la puntuacion del juego
                    System.out.println("Digame ahora la puntuación del juego");
                    float puntuacionDelJuego = sc.nextFloat();

                    //añadimos el juego
                    dao.add(new FilaTabla(nombreDelJuego, puntuacionDelJuego));
                    break;

                case 2:
                    do {
                        System.out.println("Díagme el nombre del juego del que busca");
                        nombreDelJuego = sc.nextLine();

                        if (dao.searchJuego(nombreDelJuego)) {
                            System.out.println("A que puntacion desea cambiar este juego?");
                            puntuacionDelJuego = sc.nextFloat();

                            dao.cambiarPuntuacion(nombreDelJuego, puntuacionDelJuego, new FilaTabla(puntuacionDelJuego));
                        }
                    } while (!dao.searchJuego(nombreDelJuego));
                    break;
                case 3:
                    System.out.println("Díagme el nombre del juego del que busca");
                    nombreDelJuego = sc.nextLine();

                    dao.deleteJuego(new FilaTabla(nombreDelJuego),nombreDelJuego);
                    break;
                case 4:
                    System.out.println("Díagme el nombre del juego del que busca");
                    nombreDelJuego = sc.nextLine();

                    //System.out.println(dao.damePuntuacion(new FilaTabla(nombreDelJuego)));
                    break;
                case 5:
                    System.out.println(Arrays.toString(dao.imprimirTabla()));
                    break;
                default:
                    System.out.println("Hasta la proxima");
                    break;
            }
        } while (option != 0);


    }
}
