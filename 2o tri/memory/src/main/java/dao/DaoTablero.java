package dao;

import modelo.Tablero;

import java.util.Random;

public class DaoTablero {
    Random r = new Random();
    Tablero t = new Tablero();

    public void generateTablero(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                t.setCelda(x,y,0);
            }
        }
    }

}
