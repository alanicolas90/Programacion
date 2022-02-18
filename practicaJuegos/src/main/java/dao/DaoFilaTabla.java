package dao;

import ui.FilaTabla;

import java.util.Arrays;

public class DaoFilaTabla {

    private final FilaTabla[] tabla = new FilaTabla[10];
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

    public boolean searchJuego(String nombreDelJuego) {
        boolean juegoExiste = false;
        for (int i = 0; i < numeroJuegos; i++) {
            if (tabla[i].getNombreJuego().equals(nombreDelJuego)) {
                juegoExiste = true;
            }
        }
        return juegoExiste;
    }

    public void cambiarPuntuacion(String nombreDelJuego, float nuevaPuntuacionJuego, FilaTabla fila) {
        if (fila.getNombreJuego().equals(nombreDelJuego))
            fila.setPuntuacion(nuevaPuntuacionJuego);
    }

    public boolean deleteJuego(FilaTabla fila, String nombreDelJuego) {
        boolean posibleBorrar = false;
        int posicionBorrar = -1;
        for (int i = 0; i < tabla.length && !posibleBorrar; i++) {
            if (fila.getNombreJuego().equals(nombreDelJuego)) {
                posibleBorrar = true;
                posicionBorrar = i;
                tabla[i]=null;
                numeroJuegos--;
            }
        }
        if (posibleBorrar) {
            for (int i = posicionBorrar; i < tabla.length - 1; i++) {
                tabla[i]=tabla[i+1];
            }
        }
        return posibleBorrar;
    }
    public void damePuntuacion(FilaTabla fila){
        fila.getPuntuacion();
    }
}
