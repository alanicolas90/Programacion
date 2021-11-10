package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elegirJuego;
        do {
            System.out.println("Selecciona una de las siguientes opciones(pulsando 1-3):\n" +
                    "1- Ejercicio 17\n" +
                    "2- Blackjack\n" +
                    "3- Siete y media");
            elegirJuego = sc.nextInt();
            if (elegirJuego < 1 || elegirJuego > 3) {
                System.out.println("ERROR, valor incorrecto. Inténtelo de nuevo.\n\n");
            }

        } while (elegirJuego < 1 || elegirJuego > 3);
        switch (elegirJuego) {
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
                System.out.println(":)");
                break;
        }
    }
}
