package domain.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Serie {

    private String nameSerie;

    private List<Episodio> episodios;

    private Integer valoracion;

    private boolean visto;

    public String type;

    public Serie(String nameSerie) {
        this();
        type = "Serie";
        this.nameSerie = nameSerie;
        valoracion = 0;
        visto = false;
    }
    public Serie() {
        episodios= new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nameSerie.equalsIgnoreCase(serie.nameSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSerie);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nameSerie='" + nameSerie + '\'' +
                ", episodios=" + episodios +
                ", type='" + type + '\'' +
                '}';
    }
}
