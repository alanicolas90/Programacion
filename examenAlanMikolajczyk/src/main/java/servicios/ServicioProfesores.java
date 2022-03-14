package servicios;

import dao.DaoProfesor;

public class ServicioProfesores {

    public void cotizarALosQueHayQueCotizar() {

        DaoProfesor daoProfesor = new DaoProfesor();
        daoProfesor.cotizarProfes();


    }

}
