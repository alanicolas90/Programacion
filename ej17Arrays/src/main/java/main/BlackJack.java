package main;

import servicios.ServiciosCartas;

import java.util.Scanner;

import static constantes.Constantes.SEPARATION;

public class BlackJack {
    public void juegoBlackJack() {
        ServiciosCartas servicios = new ServiciosCartas();
        Scanner sc = new Scanner(System.in);
        int jugadores;
        int optionGame;
        int cartasRepartidasCrupier = 0;
        int positionCardBaraja = 0;
        int cartasRepartidas = 0;
        int puntosCrupier;
        boolean seguirJugando;

        int[] cartas = new int[52];
        int[] crupier = new int[10];

        servicios.crearBarajaEnglish(cartas);
        servicios.shuffleBaraja(cartas);

        do {
            System.out.print("Cuantos jugadores vais a ser (3-7)? ");
            jugadores = sc.nextInt();
            if (jugadores < 3 || jugadores > 7) {
                System.out.println("Valor incorrecto, por favor inténtelo de nuevo.");
                System.out.println();
            }
        } while (jugadores < 3 || jugadores > 7);

        int[][] cardsPlayers = new int[jugadores][10];

        //repartimos primera carta a todos los jugadores
        for (int i = 0; i < jugadores; i++, positionCardBaraja++) {
            cardsPlayers[i][0] = cartas[positionCardBaraja];
        }
        cartasRepartidas++;
        //repartimos segunda carta a todos los jugadores
        for (int i = 0; i < jugadores; i++, positionCardBaraja++) {
            cardsPlayers[i][1] = cartas[positionCardBaraja];
        }
        cartasRepartidas++;
        //reparte las cartas al CRUPIER
        for (int i = 0; i < 2; i++, positionCardBaraja++, cartasRepartidasCrupier++) {
            crupier[i] = cartas[positionCardBaraja];
        }

        //mostramos las cartas que tiene cada jugador
        for (int i = 0; i < cardsPlayers.length; i++) {
            System.out.println("Jugador" + (i + 1) + ":");
            for (int j = 0; j < cartasRepartidas; j++) {
                System.out.print(cardsPlayers[i][j] + " ");
            }
            System.out.println();
        }
        //mostramos una sola carta del crupier
        System.out.println("Crupier:\n " + crupier[0]);

        System.out.println("\n-------------------------------------------------------------------------\n");

        //aquí cada jugador juega
        for (int i = 0; i < jugadores; i++) {
            seguirJugando = true;
            int puntosJugador = 0;
            cartasRepartidas = 2;
            System.out.println("Turno del jugador número " + (i + 1));

            //los puntos desde el principio.
            for (int k = 0; k < cartasRepartidas; k++) {
                if (cardsPlayers[i][k] >= 10) {
                    puntosJugador = puntosJugador + 10;
                } else if (cardsPlayers[i][k] == 1) {
                    puntosJugador = puntosJugador + 11;
                } else if (cardsPlayers[i][k] < 10) {
                    puntosJugador = puntosJugador + cardsPlayers[i][k];
                }
            }

            System.out.println(puntosJugador);


            for (int j = 2; seguirJugando; j++, cartasRepartidas++) {
                //imprime las cartas del jugador1
                for (int k = 0; k < cartasRepartidas; k++) {
                    System.out.print(cardsPlayers[i][k] + " ");
                }
                System.out.println();

                if (puntosJugador < 21) {
                    do {
                        System.out.println("Que quiere seguir hacer adelante(use el valor numérico)\n" +
                                "1- sacar otra carta\n" +
                                "2- plantarse");
                        optionGame = sc.nextInt();

                        switch (optionGame) {
                            case 1:
                                cardsPlayers[i][j] = cartas[positionCardBaraja];
                                System.out.println(cardsPlayers[i][j]);

                                if (cardsPlayers[i][j] >= 10) {
                                    puntosJugador = puntosJugador + 10;
                                } else if (cardsPlayers[i][j] == 1) {
                                    puntosJugador = puntosJugador + 11;
                                } else if (cardsPlayers[i][j] < 10) {
                                    puntosJugador = puntosJugador + cardsPlayers[i][j];
                                }
                                positionCardBaraja++;
                                break;
                            case 2:
                                cardsPlayers[i][9] = puntosJugador;
                                System.out.println("Su puntuación final es: " + puntosJugador);
                                seguirJugando = false;
                                break;
                            default:
                                System.out.println("Valor incorrecto, por favor inténtelo de nuevo.");
                        }
                        System.out.println();
                    } while (optionGame < 0 || optionGame > 4);
                }

                cardsPlayers[i][9] = puntosJugador;

                if (puntosJugador == 21) {
                    System.out.println("Felicidades usted tiene 21 puntos(Blackjack)!!");
                    seguirJugando = false;
                } else if (puntosJugador > 21) {
                    seguirJugando = false;
                    for (int k = 0; k < cartasRepartidas && !seguirJugando; k++) {
                        if (cardsPlayers[i][k] == 1) {
                            puntosJugador = puntosJugador - 10;
                            seguirJugando = true;
                        }
                    }
                    if (!seguirJugando) {
                        System.out.println("Lo sentimos mucho,has perdido.\n" +
                                "Te has pasado con los puntos. Siendo estos: " + cardsPlayers[i][9]);
                    }
                }
            }
        }


        //Ahora es turno de CRUPIER
        do {
            seguirJugando = true;
            puntosCrupier = 0;

            //Mostramos las cartas del crupier
            System.out.println("Cartas del crupier: ");
            for (int i = 0; i < cartasRepartidasCrupier; i++) {
                System.out.print(crupier[i] + " ");
            }
            System.out.println();

            //Sumamos puntos del crupier
            for (int i = 0; i < cartasRepartidasCrupier; i++) {
                if (crupier[i] >= 10) {
                    puntosCrupier = puntosCrupier + 10;
                } else if (crupier[i] == 1) {
                    puntosCrupier = puntosCrupier + 11;
                } else {
                    puntosCrupier = puntosCrupier + crupier[i];
                }
            }

            //Normas crupier, siempre echar cartas cuando los puntos son 16 o menos y si es 17 o más no echar más.
            if (puntosCrupier <= 16) {
                System.out.println("Crupier decide pedir otra carta.");
                crupier[cartasRepartidasCrupier]=cartas[cartasRepartidas];
                System.out.println(cartas[cartasRepartidas]);
                cartasRepartidasCrupier++;
                cartasRepartidas++;
            } else {
                seguirJugando = false;
                for (int i = 0; i < cartasRepartidas && !seguirJugando; i++) {
                    if (crupier[i] == 1) {
                        puntosCrupier = puntosCrupier - 10;
                        seguirJugando = true;
                    }
                }
            }
            if(puntosCrupier>21){
                puntosCrupier=0;
            }
        } while (seguirJugando);
        System.out.println();
        System.out.println("Adelante los jugadores que se hayan pasado de 21, automáticamente han perdido.");
        System.out.println("Por lo que automáticamente gana la banca.");
        System.out.println("Recuento:");

        //Puntos de cada jugador
        for (int i = 0; i < jugadores; i++) {
            if(cardsPlayers[i][9]<=21){
                System.out.print("Jugador número " + (i + 1) + ": ");
                System.out.println(cardsPlayers[i][9] + " puntos");

                System.out.println("Crupier tiene: "+puntosCrupier+" puntos");
                //en el blackjack si empatas contra la banca, la banca gana
                if(puntosCrupier>=cardsPlayers[i][9]){
                    System.out.println("Ha ganado la banca");
                }else{
                    System.out.println("Felicidades al jugador "+(i+1)+" por ganar!!");
                }
            }
        }

        System.out.println(SEPARATION);
    }
}
