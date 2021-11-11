package main;

import servicios.ServiciosCartas;

public class SieteYMedia {
    public void juegoSieteYMedia() {
        ServiciosCartas servicios = new ServiciosCartas();

        int[] cartas = new int[40];
        servicios.crearBarajaSpain(cartas);
        servicios.shuffleBaraja(cartas);
        //1 vs 1?? o cuantos jugadores?
        System.out.println("Disculpe por las molestias, este juego está en mantenimiento ahora mismo.\n" +
                "Pruebe otra opción, muchas gracias.");
    }
}
