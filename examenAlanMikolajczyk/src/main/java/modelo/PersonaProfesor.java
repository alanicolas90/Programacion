package modelo;

import java.util.ArrayList;
import java.util.List;

public class PersonaProfesor extends Persona implements Cotizable<PersonaProfesor>, Comparable<PersonaProfesor>{

    private double sueldo;
    private int yearsExperiencia;
    private List<Asignatura> asignaturasImparte;
    private List<Asignatura> notasAlumnos;


    public PersonaProfesor(String dni, String nombre, double sueldo, int yearsExperiencia) {
        super(dni, nombre);
        this.sueldo = sueldo;
        this.yearsExperiencia = yearsExperiencia;
        this.asignaturasImparte = new ArrayList<>();
    }


    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getYearsExperiencia() {
        return yearsExperiencia;
    }

    public void setYearsExperiencia(int yearsExperiencia) {
        this.yearsExperiencia = yearsExperiencia;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturasImparte;
    }

    public void setAsignaturas(List<Asignatura> asignaturasImparte) {
        this.asignaturasImparte = asignaturasImparte;
    }


    @Override
    public PersonaProfesor cotizable() {
        return new PersonaProfesor(this.getDni(),this.getNombre(),this.sueldo,this.yearsExperiencia);
    }

    @Override
    public String toString() {
        return "PersonaProfesor{" +
                "sueldo=" + sueldo +
                ", yearsExperiencia=" + yearsExperiencia +
                ", asignaturasImparte=" + asignaturasImparte +
                ", notasAlumnos=" + notasAlumnos +
                '}';
    }

    @Override
    public int compareTo(PersonaProfesor o) {
        return 0;
    }
}
