package servicios;

import dao.DaoProfesor;
import modelo.Persona;

import java.util.List;

public class ServicioListas {

    public List<Persona> listaProfesoresOrdenado() {
        DaoProfesor daoProfesor = new DaoProfesor();
        return daoProfesor.listaProfesoresOrdenado();
    }
}
