package dao;

import algo.Palos;
import modelo.Carta;

import java.util.Arrays;
import java.util.Random;

public class Dao {

    //private Carta baraja[];
    private Carta[] baraja = new Carta[40];
    private int cardPos = 0;

    public void generarBaraja() {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            baraja[counter] = new Carta(i + 1, Palos.BASTOS);
            counter++;
            baraja[counter] = new Carta(i + 1, Palos.ESPADAS);
            counter++;
            baraja[counter] = new Carta(i + 1, Palos.COPAS);
            counter++;
            baraja[counter] = new Carta(i + 1, Palos.OROS);
            counter++;
        }
    }

    public void shuffle() {
        Random r = new Random();

        for (int i = 0; i < 100000; i++) {
            int index1 = r.nextInt(40);
            int index2 = r.nextInt(40);
            Carta swap = baraja[index1];
            baraja[index1] = baraja[index2];
            baraja[index2] = swap;
        }
    }

    public Carta[] imprimirBaraja() {
        return Arrays.copyOf(baraja, 40);
    }

    public Carta sacarCarta() {
        Carta c = baraja[cardPos];
        cardPos++;
        return c;
    }
}
