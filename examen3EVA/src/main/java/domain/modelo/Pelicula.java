package domain.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Pelicula {

    private String titulo;

    private List<Actor> actores;

    private Integer yearPelicula;

    private Integer valoracion;

    private Boolean visto;

    public String type;

    public Pelicula(String titulo, Integer yearPelicula) {
        this();
        this.titulo = titulo;
        this.yearPelicula = yearPelicula;
        valoracion = 0;
        type = "Pelicula";
        visto = false;
    }
    public Pelicula(){
        actores = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return titulo.equalsIgnoreCase(pelicula.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", actores=" + actores +
                ", yearPelicula=" + yearPelicula +
                '}';
    }
}
