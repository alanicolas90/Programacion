package modelo;

public class Celda {

    private int x;
    private int y;
    private int valor;
    private boolean hidden;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValor() {
        return valor;
    }

    public boolean isHidden() {
        return hidden;
    }
}
