package main;

import servicios.ServiciosCartas;

import static constantes.Constantes.SEPARATION;

public class BlackJack {
    public void juegoBlackJack() {
        ServiciosCartas servicios = new ServiciosCartas();
        int[] cartas = new int[52];
        servicios.crearBarajaEnglish(cartas);
        servicios.shuffleBaraja(cartas);









        System.out.println(SEPARATION);
    }
}
