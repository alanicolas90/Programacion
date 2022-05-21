package domain.modelo.usuario;

import lombok.Getter;
import lombok.Setter;
import domain.modelo.billetera.BilleteraFamiliar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Usuario implements Comparable<Usuario> {

    private String username;
    private String password;
    public String type;
    private String nombre;
    private String apellido;
    private String correo;
    private Double dinero;
    private List<BilleteraFamiliar> billeteras;

    public Usuario(String nombre, String apellido, String correo, Double dinero, String password, String username, List<BilleteraFamiliar> billeteras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dinero = dinero;
        this.password = password;
        this.username = username;
        this.billeteras = billeteras;
    }

    public Usuario(String username, String password, String nombre, String apellido, String correo, Double dinero) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dinero = dinero;
        this.password = password;
        this.username = username;

    }

    public Usuario (String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public Usuario() {
        billeteras = new ArrayList<>();
        type="Usuario";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return username.equalsIgnoreCase(usuario.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public int compareTo(Usuario user) {
        return this.getUsername().toLowerCase().compareTo(user.getUsername().toLowerCase());
    }

    @Override
    public String toString() {
        return "Usuario{\n" +
                "nombre = " + nombre + "\n"+
                "apellido = " + apellido + "\n" +
                "correo = " + correo + "\n" +
                "dinero = " + dinero + "\n" +
                "password = " + password + "\n" +
                "username = " + username + "\n" +
                "billeteras = " + billeteras +"\n"+
                '}';
    }
}


