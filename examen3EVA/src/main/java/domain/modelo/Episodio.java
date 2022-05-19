package domain.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Episodio {
    private String id;

    private List<Actor> actores;

    public Episodio(String id) {
        this();
        this.id = id;
    }
    public Episodio(){
        actores = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episodio episodio = (Episodio) o;
        return id == episodio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "id=" + id +
                ", actores=" + actores +
                '}';
    }
}
