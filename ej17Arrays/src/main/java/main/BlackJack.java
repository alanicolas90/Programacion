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
        int positionCardBaraja = 0;
        int cartasRepartidas = 0;

        int[] cartas = new int[52];
        int[] crupier=new int[10];

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
        for (int i = 0; i < jugadores; i++,positionCardBaraja++) {
            cardsPlayers[i][0] = cartas[positionCardBaraja];
        }
        cartasRepartidas++;
        //repartimos segunda carta a todos los jugadores
        for (int i = 0; i < jugadores; i++, positionCardBaraja++) {
            cardsPlayers[i][1] = cartas[positionCardBaraja];
        }
        cartasRepartidas++;
        //reparte las cartas al CRUPIER
        for (int i = 0; i < 2; i++,positionCardBaraja++) {
            crupier[i]=cartas[positionCardBaraja];
        }

        //mostramos las cartas que tiene cada jugador
        for (int i = 0; i < cardsPlayers.length; i++) {
            System.out.println("jugador" + (i + 1));
            for (int j = 0; j < cartasRepartidas; j++) {
                System.out.print(cardsPlayers[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n-------------------------------------------------------------------------\n");

        //aquí cada jugador juega
        for (int i = 0; i < jugadores; i++) {
            boolean seguirJugando = true;
            int puntosJugador = 0;
            int cartasJugador = 2;
            System.out.println("Turno del jugador número " + (i + 1));

            //los puntos desde el principio.
            for (int k = 0; k < cartasJugador; k++) {
                if (cardsPlayers[i][k] >= 10) {
                    puntosJugador = puntosJugador + 10;
                } else if (cardsPlayers[i][k] < 10) {
                    puntosJugador = puntosJugador + cardsPlayers[i][k];
                }
            }

            System.out.println(puntosJugador);


            for (int j = 2; seguirJugando; j++, cartasJugador++) {
                //imprime las cartas del jugador1
                for (int k = 0; k < cartasJugador; k++) {
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
                                } else if (cardsPlayers[i][j] < 10) {
                                    puntosJugador = puntosJugador + cardsPlayers[i][j];
                                }
                                positionCardBaraja++;
                                cartasRepartidas++;
                                break;
                            case 2:
                                cardsPlayers[i][9] = puntosJugador;
                                System.out.println("Su puntuación final es: " + puntosJugador);
                                seguirJugando = false;
                                break;
                            default:
                                System.out.println("Valor incorrecto, por favor intentelo de nuevo.");
                        }
                        System.out.println();
                    } while (optionGame < 0 || optionGame > 4);
                }

                cardsPlayers[i][9] = puntosJugador;

                if (puntosJugador == 21) {
                    System.out.println("Felicidades usted tiene un BlackJack!!");
                    seguirJugando = false;
                } else if (puntosJugador > 21) {
                    seguirJugando = false;
                    System.out.println("Lo sentimos mucho,has perdido.\n" +
                            "Te has pasado con los puntos. Siendo estos: " + cardsPlayers[i][9]);
                }
            }
            System.out.println(puntosJugador);
        }
        //Puntos de cada jugador
        for (int i = 0; i < jugadores; i++) {
            System.out.println(cardsPlayers[i][9]);
        }
        //Ahora es turno de CRUPIER


        System.out.println(SEPARATION);
    }
}
