package modelo;

public class Asignatura {

    private String nombre;
    private int maxAlumnos;
    private double precio;

    public Asignatura(String nombre, int maxAlumnos, double precio) {
        this.nombre = nombre;
        this.maxAlumnos = maxAlumnos;
        this.precio = precio;
    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos -= maxAlumnos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", maxAlumnos=" + maxAlumnos +
                ", precio=" + precio +
                '}';
    }
}
