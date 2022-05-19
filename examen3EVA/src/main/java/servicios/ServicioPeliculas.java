package servicios;

import dao.DaoPeliculas;
import domain.modelo.Pelicula;
import jakarta.inject.Inject;

public class ServicioPeliculas {

    private DaoPeliculas daoPeliculas;

    @Inject
    public ServicioPeliculas(DaoPeliculas daoPeliculas) {
        this.daoPeliculas = daoPeliculas;
    }

    public boolean addPelicula(Pelicula pelicula) {
        if (!daoPeliculas.peliculaExists(pelicula)) {
            return daoPeliculas.addPelicula(pelicula);
        }else{
            return false;
        }
    }
}
