package main;

import servicios.ServiciosCartas;

public class Ejercicio17 {
    public void juegoEjercicio17() {
        ServiciosCartas servicios = new ServiciosCartas();
        int[] cartas = new int[20];
        int[] jugador1 = new int[10];
        int[] jugador2 = new int[10];
        int position = 0;
        servicios.crearBarajaEj17(cartas);
        servicios.shuffleBaraja(cartas);

        //repartimos las barajas entre los jugadores
        for (int i = 0; i < cartas.length; i++, position++) {
            jugador1[position] = cartas[i];
            i++;
            jugador2[position] = cartas[i];
        }
        System.out.println("JUGADOR 1");
        for (int i = 0; i < jugador1.length; i++) {
            System.out.print(jugador1[i] + " ");
        }
        System.out.println();
        System.out.println("JUGADOR 2");
        for (int i = 0; i < jugador2.length; i++) {
            System.out.print(jugador2[i] + " ");
        }


    }
}
