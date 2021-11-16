package main;

import servicios.ServiciosCartas;

import static constantes.Constantes.FELICIDADES;
import static constantes.Constantes.SEPARATION;

public class Ejercicio17 {

    public void juegoEjercicio17() {
        ServiciosCartas servicios = new ServiciosCartas();
        int[] cartas = new int[20];
        int[] jugador1 = new int[10];
        int[] jugador2 = new int[10];
        int position = 0;
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;
        servicios.crearBarajaEj17(cartas);
        servicios.shuffleBaraja(cartas);

        //repartimos las barajas entre los jugadores
        for (int i = 0; i < cartas.length; i++, position++) {
            jugador1[position] = cartas[i];
            i++;
            jugador2[position] = cartas[i];
        }

        for (int i = 0; i < jugador1.length; i++) {
            System.out.println("El jugador 1 saca:                El jugador 2 saca:");
            System.out.println(jugador1[i] + "                                 " + jugador2[i]);
            if (jugador1[i] > jugador2[i]) {
                System.out.println("              punto para jugador 1");
                puntosJugador1++;
            } else if (jugador2[i] > jugador1[i]) {
                System.out.println("              punto para jugador 2");
                puntosJugador2++;
            } else {
                System.out.println("        Ha sido empate nadie se lleva el punto");
            }
            System.out.println(SEPARATION);
        }

        puntajeFinal(puntosJugador1,puntosJugador2);
    }


    private void puntajeFinal(int puntosJugador1,int puntosJugador2){
        System.out.println("La puntación final: ");
        System.out.println("Jugador 1 tiene: " + puntosJugador1 + " puntos");
        System.out.println("Jugador 2 tiene: " + puntosJugador2 + " puntos");
        System.out.println();
        if (puntosJugador1 > puntosJugador2) {
            System.out.println("EL GANADOR ES EL JUGADOR 1.");
            System.out.println(FELICIDADES);
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println("EL GANADOR ES EL JUGADOR 2.");
            System.out.println(FELICIDADES);
        } else {
            System.out.println("HA SIDO UN EMPATE");
        }
        System.out.println(SEPARATION);
    }
}
