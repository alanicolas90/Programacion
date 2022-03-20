package dao;

import modelo.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BBDD {
    private BBDD() {
    }

    static LinkedHashMap<String, Persona> personas = new LinkedHashMap<>();
    static ArrayList<Cotizable> personasCotizables = new ArrayList<>();

    static {

        personasCotizables.add(0, new PersonaProfesor("1", "manuela", 4500, 15));
        personasCotizables.add(1, new PersonaProfesor("4", "oscar", 5000, 20));
        personasCotizables.add(2, new PersonaProfesor("5", "bea", 5000, 20));
        personasCotizables.add(3, new PersonaAdministrativo("2", "manolo", 1500, "secretaria"));
        personasCotizables.add(4, new PersonaAdministrativo("6", "jefa", 3000, "currar"));
        personasCotizables.add(5, new PersonaAdministrativo("7", "limpieza", 1500, "limpiar"));

        personas.put("1", new PersonaProfesor("1", "manuela", 4500, 15));
        personas.put("4", new PersonaProfesor("4", "oscar", 5000, 20));
        personas.put("5", new PersonaProfesor("5", "bea", 5000, 20));

        personas.values()
                .forEach(persona -> {
                    if (persona instanceof PersonaProfesor) {
                        switch (persona.getDni()) {
                            case "1":
                                ((PersonaProfesor) persona).setAsignaturas(List.of(new Asignatura("pragramacion", 2, 100), new Asignatura("base de datos", 30, 50)));
                                break;
                            case "4":
                                ((PersonaProfesor) persona).setAsignaturas(List.of(new Asignatura("PE", 20, 20)));
                                break;
                            case "5":
                                ((PersonaProfesor) persona).setAsignaturas(List.of(new Asignatura("IA", 35, 40)));
                                break;
                        }
                    }
                });

        personas.put("2", new PersonaAdministrativo("2", "manolo", 1500, "secretaria"));
        personas.put("6", new PersonaAdministrativo("6", "jefa", 3000, "currar"));
        personas.put("7", new PersonaAdministrativo("7", "limpieza", 1500, "limpiar"));

        personas.put("3", new PersonaAlumnos("3", "menealo", 150));
        personas.put("8", new PersonaAlumnos("8", "alan", 4500));
        personas.put("9", new PersonaAlumnos("9", "juan", 2000));
        personas.put("10", new PersonaAlumnos("10", "jose", 50));

    }

}
