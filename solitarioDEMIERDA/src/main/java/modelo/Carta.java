package modelo;

import algo.Palos;

public class Carta {

    private int valorCarta;
    private Palos palo;

    public Carta(int valorCarta, Palos palo) {
        this.valorCarta = valorCarta;
        this.palo = palo;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public Palos getPalo() {
        return palo;
    }

    public void setPalo(Palos palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "valorCarta=" + valorCarta +
                ", palo=" + palo +
                '}';
    }
}
