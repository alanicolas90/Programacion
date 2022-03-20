package ui;

import dao.DaoTablero;
import modelo.Tablero;

public class Main {
    public static void main(String[] args) {
        Tablero t = new Tablero();
        DaoTablero daoTablero = new DaoTablero();


        daoTablero.generateTablero(2,2);

        System.out.println(daoTablero.imprimirTablero(2,2));

        t.setCelda(0,0,4);





    }
}
