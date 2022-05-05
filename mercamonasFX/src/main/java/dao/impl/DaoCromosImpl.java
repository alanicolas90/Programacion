package dao.impl;

import config.Configuration;
import dao.DaoCromos;
import domain.modelo.Cromo;
import jakarta.inject.Inject;

import java.util.List;

public class DaoCromosImpl implements DaoCromos {

    private Configuration configuracion;

    @Inject
    public DaoCromosImpl(Configuration configuracion) {
        this.configuracion = configuracion;
    }

    @Override
    public List<Cromo> loadCromos() {
        return List.of(
                new Cromo("marvel",1,"descripcion"),
                new Cromo("marvel",2,"descripcion"),
                new Cromo("marvel",3,"descripcion"),
                new Cromo("marvel",4,"descripcion"));
    }
}
