package dao;

import modelo.Asignatura;
import modelo.PersonaAlumnos;
import modelo.PersonaProfesor;

import java.util.List;
import java.util.stream.Collectors;

import static dao.BBDD.personas;

public class DaoAsignaturas {

    public boolean existeAsignatura(String asignatura) {
        return personas.values()
                .stream()
                .filter(persona -> persona instanceof PersonaProfesor)
                .allMatch(persona -> ((PersonaProfesor)persona).getAsignaturas().contains(new Asignatura(asignatura)));
    }

    public double costeMatricula(String asignatura) {
        return personas.values()
                .stream()
                .filter(persona -> persona instanceof PersonaProfesor)
                .flatMap(persona -> ((PersonaProfesor) persona).getAsignaturas().stream())
                .filter(asignatura1 -> asignatura1.getNombre().equals(asignatura))
                .findFirst().get().getPrecio();
    }

    public int plazasAsignatura(String asignatura) {
        return personas.values()
                .stream()
                .filter(persona -> persona instanceof PersonaProfesor)
                .flatMap(persona -> ((PersonaProfesor) persona).getAsignaturas().stream())
                .filter(asignatura1 -> asignatura1.getNombre().equals(asignatura))
                .findFirst().get().getMaxAlumnos();
    }
}
