package domain.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Usuario {
    private String username;
    private String password;
    private List<Pelicula> peliculasVistas;
    private List<Serie> seriesVistas;

    public String type;

    public Usuario(String username, String password) {
        this();
        type = "Usuario";
        this.username = username;
        this.password = password;
    }

    public Usuario(){
        peliculasVistas = new ArrayList<>();
        seriesVistas = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return username.equals(usuario.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", peliculasVistas=" + peliculasVistas +
                ", seriesVistas=" + seriesVistas +
                '}';
    }
}
