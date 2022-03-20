package modelo;

import java.util.ArrayList;
import java.util.List;

public class PersonaAlumnos extends Persona {

    private List<Asignatura> asignaturasMatriculadas;
    private double dinero;
    private List<AsignaturaNota> notasAlumno;

    public PersonaAlumnos(String dni, String nombre, double dinero) {
        super(dni, nombre);
        this.asignaturasMatriculadas= new ArrayList<>();
        this.notasAlumno = new ArrayList<>();
        this.dinero = dinero;
    }

    public List<Asignatura> getAsignaturasMatriculadas() {
        return asignaturasMatriculadas;
    }

    public void setAsignaturasMatriculadas(List<Asignatura> asignaturasMatriculadas) {
        this.asignaturasMatriculadas = asignaturasMatriculadas;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "PersonaAlumnos{" +
                "asignaturasMatriculadas=" + asignaturasMatriculadas +
                ", dinero=" + dinero +
                ", notasAlumno=" + notasAlumno +
                '}';
    }
}
