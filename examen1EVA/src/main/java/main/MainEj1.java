package main;

import java.util.Random;
import java.util.Scanner;

public class MainEj1 {

    public static void main(String[] args) {
        Utilidades utils = new Utilidades();
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] baraja = new int[40];
        int cantidadJugadores;
        int cartasRestantes;
        int cartasRepartidas = 0;
        utils.generarBaraja(baraja);
        utils.barajar(baraja);


        do {
            System.out.print("Cuantos jugadores vais a ser(mínimo 2 jugadores)? ");
            cantidadJugadores = sc.nextInt();
            if (cantidadJugadores < 2) {
                System.out.println("Valor incorrecto, prueba otra vez.\n");
            }
            else if(cantidadJugadores > 13){
                System.out.println("No se puede mas de 13 jugadores, si no, no se puede inicializar el juego.");
            }
        } while (cantidadJugadores < 2 || cantidadJugadores > 13);
        int cartasPorRonda = cantidadJugadores * 3;


        int[][] cartasJugadores = new int[cantidadJugadores][3];
        int[] cartasGanadasJugadores = new int[cantidadJugadores];

        do {

            //repartir 3 cartas a cada jugador
            for (int i = 0; i < cantidadJugadores; i++) {
                for (int j = 0; j < 3; j++) {
                    cartasJugadores[i][j] = baraja[cartasRepartidas];
                    baraja[cartasRepartidas] = 0;
                    cartasRepartidas++;
                }
            }
            int cartasBaza = 3;

            do {
                int[] cartasSacanJugadores = new int[cantidadJugadores];

                //cada jugador elige la carta que quiere sacar
                for (int i = 0; i < cantidadJugadores; i++) {
                    //que vea las cartas que tiene
                    System.out.println("Jugador número " + (i + 1));
                    System.out.print("{");
                    for (int j = 0; j < cartasBaza; j++) {
                        System.out.print(cartasJugadores[i][j] + " ");
                    }
                    System.out.println("}");
                    int cartaSacar = r.nextInt(cartasBaza);

                    System.out.println("El jugador " + (i + 1) + " ha elegido sacar la carta " + cartasJugadores[i][cartaSacar]);
                    cartasSacanJugadores[i] = cartasJugadores[i][cartaSacar];
                    cartasJugadores[i][cartaSacar] = 0;

                    //colocar que el 0 se vaya para atrás
                    for (int j = cartasBaza - 1; j >= 0; j--) {
                        if (cartasJugadores[i][j] == 0) {
                            int aux = cartasJugadores[i][cartasBaza - 1];
                            cartasJugadores[i][cartasBaza - 1] = cartasJugadores[i][j];
                            cartasJugadores[i][j] = aux;
                        }
                    }
                }


                //ver quien ha sacado la mayor carta
                int mayorCarta = cartasSacanJugadores[0];
                int mayorCartaJugador = 1;
                for (int i = 1; i < cartasSacanJugadores.length; i++) {
                    if (mayorCarta < cartasSacanJugadores[i]) {
                        mayorCarta = cartasSacanJugadores[i];
                        mayorCartaJugador = i + 1;
                    }
                }
                System.out.println("El ganador de esta ronda ha sido el jugador número: " + mayorCartaJugador);
                cartasGanadasJugadores[mayorCartaJugador - 1] += 3;
                System.out.println("Su carta ha sido: " + mayorCarta);


                cartasBaza--;
            } while (cartasBaza != 0);


            cartasRestantes = baraja.length - cartasRepartidas;
        } while (cartasRestantes > cartasPorRonda);


        //imprimir los resultados
        for (int i = 0; i < cartasGanadasJugadores.length; i++) {
            System.out.println("El jugador " + (i + 1) + " ha conseguido: " + cartasGanadasJugadores[i] + " cartas");
        }
        int mayorCantidadCartas = cartasGanadasJugadores[0];
        int jugadorConMasCartas = 1;
        for (int i = 1; i < cartasGanadasJugadores.length; i++) {
            if (mayorCantidadCartas < cartasGanadasJugadores[i]) {
                mayorCantidadCartas = cartasGanadasJugadores[i];
                jugadorConMasCartas = i + 1;
            }
        }
        int cantidadGanadores = 0;
        //ver si hay varios ganadores
        for (int i = 0; i < cartasGanadasJugadores.length; i++) {
            if (mayorCantidadCartas == cartasGanadasJugadores[i]) {
                cantidadGanadores++;
            }
        }

        if (cantidadGanadores == 1) {
            System.out.println("Por consiguiente el ganador del juego ha sido: el jugador número " + jugadorConMasCartas);
        } else {
            System.out.println("VAYA, hay " + cantidadGanadores + " ganadores, o sea hay empatados :(");
        }

    }
}

