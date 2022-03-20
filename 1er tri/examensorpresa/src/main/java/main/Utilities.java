package main;

import java.util.Random;

public class Utilities {
    public void crearBaraja(int [] cartas) {
        for (int i = 0; i < 40; i++) {
            cartas[i] = (i % 10) + 1;
        }
    }


    public void shuffleCartas(int[] cartas) {
        Random r = getR();
        for (int i = 0; i < 10000; i++) {
            int randomPosition1 = r.nextInt(cartas.length);
            int randomPosition2 = r.nextInt(cartas.length);
            int saveCard = cartas[randomPosition1];

            cartas[randomPosition1] = cartas[randomPosition2];
            cartas[randomPosition2] = saveCard;
        }
    }

    private Random getR() {
        return new Random();
    }

    public void imprimirBarajaJugador1(int[] cartasJugador1){
        for (int i = 0; i < cartasJugador1.length; i++) {
            if (i < (cartasJugador1.length - 1)) {
                System.out.print(cartasJugador1[i] + "-");
            }else{
                System.out.println(cartasJugador1[i]);
            }
        }
    }
    public void imprimirBarajaJugador2(int[] cartasJugador2){
        for (int i = 0; i < cartasJugador2.length; i++) {
            if (i < (cartasJugador2.length - 1)) {
                System.out.print(cartasJugador2[i] + "-");
            }else{
                System.out.println(cartasJugador2[i]);
            }
        }
    }


}

