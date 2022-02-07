package modelo;

public class Tablero {

    private int celdas[][];

    public int getCelda(int x, int y) {
        return celdas[x][y];
    }

    public int setCelda(int x , int y, int valor){
        return celdas[x][y]= valor;
    }
}
