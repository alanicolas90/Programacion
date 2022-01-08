package ui;

public class FilaTabla {

    private String nombreJuego;
    private float puntuacion;

    public FilaTabla(String nombreJuego, float puntuacion) {
        this.nombreJuego = nombreJuego;
        this.puntuacion = puntuacion;
    }
    public FilaTabla(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public FilaTabla(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "\n___________________________________________________________________________________________________________________________\n" +
                "nombreJuego = " + nombreJuego + " || " +
                " puntuacion = " + puntuacion + "\n" +
                "___________________________________________________________________________________________________________________________\n";
    }
}
