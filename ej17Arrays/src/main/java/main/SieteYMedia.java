package main;

import servicios.ServiciosCartas;

public class SieteYMedia {
    public void juegoSieteYMedia() {
        ServiciosCartas servicios = new ServiciosCartas();

        int[] cartas = new int[40];
        servicios.crearBarajaSpain(cartas);
        servicios.shuffleBaraja(cartas);
        int numJugadores=4;
        //1 vs 1?? o cuantos jugadores?
    }
}
