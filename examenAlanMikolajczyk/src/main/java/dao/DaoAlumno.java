package dao;

import modelo.Asignatura;
import modelo.Persona;
import modelo.PersonaAlumnos;
import modelo.PersonaProfesor;

import java.util.stream.Collectors;

import static dao.BBDD.personas;

public class DaoAlumno {
    public boolean esAlumno(String dniAlumno) {
        return personas.get(dniAlumno) instanceof PersonaAlumnos;
    }


    public void agregarNota(String dniAlumno, String asignatura, int notaAlumno) {
        int indexAsignatura=((PersonaAlumnos) personas.get(dniAlumno)).getAsignaturasMatriculadas().indexOf(new Asignatura(asignatura));
        ((PersonaAlumnos)personas.get(dniAlumno)).getAsignaturasMatriculadas().get(indexAsignatura);
    }

    public void agregarAlumnoAsignatura(String dniAlumno, String asignatura) {
        Persona p = personas.values()
                .stream()
                .filter(persona -> persona instanceof PersonaProfesor)
                .filter(persona -> ((PersonaProfesor) persona).getAsignaturas().contains(new Asignatura(asignatura)))
                .findFirst().get();

        int index = ((PersonaProfesor)p).getAsignaturas().indexOf(new Asignatura(asignatura));
        int maxalumnos= ((PersonaProfesor)p).getAsignaturas().get(index).getMaxAlumnos();
        ((PersonaProfesor)p).getAsignaturas().get(index).setMaxAlumnos(maxalumnos);

       ((PersonaAlumnos)personas.get(dniAlumno)).getAsignaturasMatriculadas().add(new Asignatura(asignatura));

    }

    public double dineroTieneAlumno(String dniAlumno) {
        return ((PersonaAlumnos)personas.get(dniAlumno)).getDinero();
    }
}
