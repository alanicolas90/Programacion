package dao;

import ui.FilaTabla;

import java.util.Arrays;

public class DaoFilaTabla {

    private FilaTabla[] tabla = new FilaTabla[10];
    private int numeroJuegos = 0;

    public FilaTabla[] imprimirTabla() {
        return Arrays.copyOf(tabla, 10);
    }

    public boolean add(FilaTabla fila) {
        if (numeroJuegos > 10) {
            return false;
        }
        tabla[numeroJuegos] = fila;
        numeroJuegos++;
        return true;
    }

    public boolean searchJuego(FilaTabla tabla){

        return true;
    }


}
