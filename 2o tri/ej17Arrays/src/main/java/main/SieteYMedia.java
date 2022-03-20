package main;

import servicios.ServiciosCartas;

import java.util.Scanner;

public class SieteYMedia {
    public void juegoSieteYMedia() {
        ServiciosCartas servicios = new ServiciosCartas();
        Scanner sc = new Scanner(System.in);
        int jugadores;

        int[] cartas = new int[40];
        servicios.crearBarajaSpain(cartas);
        servicios.shuffleBaraja(cartas);

        System.out.println("Disculpe por las molestias, este juego está en mantenimiento ahora mismo.\n" +
                "Pruebe otra opción, muchas gracias.");

        do{
            System.out.print("Cuantos jugadores vais a ser (2-6)? ");
            jugadores = sc.nextInt();
            if (jugadores < 2 || jugadores > 6) {
                System.out.println("Valor incorrecto, por favor inténtelo de nuevo.");
                System.out.println();
            }
        } while (jugadores < 2 || jugadores > 6);





    }
}
