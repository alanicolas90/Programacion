package main;

import servicios.ServiciosCartas;

public class SieteYMedia {
    public void juegoSieteYMedia(){
        ServiciosCartas servicios = new ServiciosCartas();

        int[] cartas = new int[40];
        servicios.crearBarajaSpain(cartas);
    }
}
