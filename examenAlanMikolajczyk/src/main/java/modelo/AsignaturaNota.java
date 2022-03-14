package modelo;

public class AsignaturaNota extends Asignatura{

    private int nota;

    public AsignaturaNota(String nombre, int maxAlumnos, double precio) {
        super(nombre, maxAlumnos, precio);
    }

    public AsignaturaNota(String nombre) {
        super(nombre);
    }
}
