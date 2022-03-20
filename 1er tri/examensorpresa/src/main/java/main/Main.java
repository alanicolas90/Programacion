package main;

import java.util.Arrays;

public class Main {
    //sumar donde están los 1, donde están los 2 y así sucesivamente
    public static void main(String[] args) {
        int[] cartasJugador1 = new int[40];
        int[] cartasJugador2 = new int[40];

        int[] sumaCartasYPositionJugador1 = new int[10];
        int[] sumaCartasYPositionJugador2 = new int[10];

        int puntosJugador1 = 0;
        int puntosJugador2 = 0;

        //Generamos y mezclamos la baraja del jugador 1
        Utilities utilidad = new Utilities();
        utilidad.crearBaraja(cartasJugador1);
        utilidad.shuffleCartas(cartasJugador1);
        System.out.println("Las cartas del jugador 1 son las siguientes:");
        utilidad.imprimirBarajaJugador1(cartasJugador1);

        System.out.println();

        //Generamos y mezclamos la baraja del jugador 1
        utilidad.crearBaraja(cartasJugador2);
        utilidad.shuffleCartas(cartasJugador2);
        System.out.println("Las cartas del jugador 2 son las siguientes:");
        utilidad.imprimirBarajaJugador2(cartasJugador2);

        System.out.println();

        //Sumamos las posiciones con el valor de las posiciones y las guardamos en un array
        for (int i = 0; i < cartasJugador1.length; i++) {
            sumaCartasYPositionJugador1[(cartasJugador1[i] - 1)] = (i + 1) + sumaCartasYPositionJugador1[(cartasJugador1[i] - 1)];
            sumaCartasYPositionJugador2[(cartasJugador2[i] - 1)] = (i + 1) + sumaCartasYPositionJugador2[(cartasJugador2[i] - 1)];
        }

        //Comparamos de 1 en 1 las sumas y damos puntos al que más puntos tenga
        for (int i = 0; i < 10; i++) {
            if (sumaCartasYPositionJugador1[i] > sumaCartasYPositionJugador2[i]) {
                puntosJugador1++;
            } else if (sumaCartasYPositionJugador2[i] > sumaCartasYPositionJugador1[i]) {
                puntosJugador2++;
            } else {
                puntosJugador1++;
                puntosJugador2++;
            }
        }

        System.out.println("Los puntos finales del jugador 1 son: " + puntosJugador1);
        System.out.println("Los puntos finales del jugador 2 son: "+ puntosJugador2);
        System.out.println();

        if (puntosJugador1 > puntosJugador2) {
            System.out.println("EL GANADOR ES EL JUGADOR 1");
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println("EL GANADOR ES EL JUGADOR 2");
        } else {
            System.out.println("INCREÍBLE, LOS DOS JUGADORES HAN EMPATADO");
        }


    }
}
