package dao;

import modelo.Persona;
import modelo.PersonaAdministrativo;
import modelo.PersonaProfesor;

import java.util.List;
import java.util.stream.Collectors;

import static dao.BBDD.personas;
import static dao.BBDD.personasCotizables;

public class DaoProfesor {

    public int cantidadAsignaturas(Persona p){
        return ((PersonaProfesor)p).getAsignaturas().size();
    }

    public List<Persona> listaProfesoresOrdenado() {
        return personas.values()
                .stream().
                filter(PersonaProfesor.class::isInstance)
                .sorted((o1,o2)-> Integer.compare(cantidadAsignaturas(o2), cantidadAsignaturas(o1)))
                .collect(Collectors.toUnmodifiableList());
    }

    public void cotizarProfes() {
        personas.values()
                .stream()
                .forEach(persona -> {
                    if(persona instanceof PersonaProfesor){
                        double sueldo = ((PersonaProfesor)persona).getSueldo();
                        ((PersonaProfesor)persona).setSueldo(sueldo * 1.38);
                    }else if(persona instanceof PersonaAdministrativo){
                        double sueldo= ((PersonaAdministrativo)persona).getSueldo();
                        ((PersonaAdministrativo)persona).setSueldo(sueldo * 1.38);
                    }
                });
        ;
    }
}
