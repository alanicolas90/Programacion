package dao;

import modelo.Tablero;

public class DaoTablero {

    private Tablero tablero;

    public DaoTablero() {
        tablero = new Tablero(6, 7);
    }


    public String getCelda(int x, int y) {
        return tablero.getCelda(x, y);
    }


    private boolean celdaVacia(int x, int y) {
        return tablero.getCelda(x, y).equals("-");
    }

    public boolean setCelda(int x, int y, String valor) {
        boolean celdaVacia = false;
        do {


        } while (celdaVacia(x, y));

        if (celdaVacia(x, y))
            tablero.setCelda(x, y, valor);
        else
            celdaVacia = true;

        return celdaVacia;
    }


    public boolean tresLinea() {
        boolean bingo = false;

        if (tablero.getCelda(0, 0) != null &&
                tablero.getCelda(0, 0).equals(tablero.getCelda(0, 1)) &&
                tablero.getCelda(0, 2).equals(tablero.getCelda(0, 1)) ||

                tablero.getCelda(1, 0) != null &&
                        tablero.getCelda(1, 0).equals(tablero.getCelda(1, 1)) &&
                        tablero.getCelda(1, 2).equals(tablero.getCelda(1, 1)) ||

                tablero.getCelda(2, 0) != null &&
                        tablero.getCelda(2, 0).equals(tablero.getCelda(2, 1)) &&
                        tablero.getCelda(2, 2).equals(tablero.getCelda(2, 1)) ||

                tablero.getCelda(0, 0) != null &&
                        tablero.getCelda(0, 0).equals(tablero.getCelda(1, 0)) &&
                        tablero.getCelda(2, 0).equals(tablero.getCelda(1, 0)) ||

                tablero.getCelda(0, 1) != null &&
                        tablero.getCelda(0, 1).equals(tablero.getCelda(1, 1)) &&
                        tablero.getCelda(2, 1).equals(tablero.getCelda(1, 1)) ||

                tablero.getCelda(0, 2) != null &&
                        tablero.getCelda(0, 2).equals(tablero.getCelda(1, 2)) &&
                        tablero.getCelda(2, 2).equals(tablero.getCelda(1, 2)) ||

                tablero.getCelda(0, 0) != null &&
                        tablero.getCelda(0, 0).equals(tablero.getCelda(1, 1)) &&
                        tablero.getCelda(2, 2).equals(tablero.getCelda(1, 1)) ||

                tablero.getCelda(0, 2) != null &&
                        tablero.getCelda(0, 2).equals(tablero.getCelda(1, 1)) &&
                        tablero.getCelda(2, 0).equals(tablero.getCelda(1, 1))
        )
            bingo = true;

        return bingo;
    }

    public boolean estaOcupado(int x, int y) {
        boolean ocupado = false;

        if (tablero.getCelda(x, y).equals("X") || tablero.getCelda(x, y).equals("O")) {
            ocupado = true;
        }
        return ocupado;
    }

    public Tablero getTablero() {
        return tablero;
    }
}

