package dao;

import domain.modelo.Pelicula;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class DaoPeliculas {

    private final BBDD db;

    @Inject
    public DaoPeliculas(BBDD db) {
        this.db = db;
    }

    public boolean addPelicula(Pelicula pelicula) {

        boolean ok;
        List<Pelicula> peliculas = db.loadPeliculas();
        if(peliculas == null) {
            peliculas = new ArrayList<>();
        }

        peliculas.add(pelicula);

        ok=db.savePeliculas(peliculas);

        return ok;
    }

    public boolean peliculaExists(Pelicula pelicula){
        boolean existe = false;
        List<Pelicula> peliculas = db.loadPeliculas();
        if(peliculas != null) {
            existe = peliculas.stream().anyMatch(pelicula1 -> pelicula1.equals(pelicula));
        }
        return existe;
    }
}
