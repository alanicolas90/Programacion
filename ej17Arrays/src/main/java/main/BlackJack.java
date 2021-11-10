package main;

import servicios.ServiciosCartas;

public class BlackJack {
    public void juegoBlackJack() {
        ServiciosCartas servicios = new ServiciosCartas();
        int[] cartas = new int[52];
        servicios.crearBarajaEnglish(cartas);
    }
}
