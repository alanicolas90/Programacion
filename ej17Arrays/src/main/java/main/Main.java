package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean seguirJugando = true;
        int elegirJuego;

        do {
            System.out.println("Selecciona una de las siguientes opciones(pulsando 1-3):\n" +
                    "1- Ejercicio 17\n" +
                    "2- Blackjack\n" +
                    "3- Siete y media\n\n" +
                    "0- Si desea salir");
            elegirJuego = sc.nextInt();
            if (elegirJuego == 0) {
                seguirJugando = false;
            }

            switch (elegirJuego) {
                case 0:
                    System.out.println("Adiós hasta la próxima :)");
                    break;
                case 1:
                    Ejercicio17 ej17 = new Ejercicio17();
                    ej17.juegoEjercicio17();
                    break;
                case 2:
                    BlackJack bj = new BlackJack();
                    bj.juegoBlackJack();
                    break;
                case 3:
                    SieteYMedia sym = new SieteYMedia();
                    sym.juegoSieteYMedia();
                    break;
                default:
                    System.out.println("ERROR, valor incorrecto. Inténtelo de nuevo.\n\n");
                    break;
            }
        } while (seguirJugando);
    }
}
