package modelo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cliente {

    private String dni;
    private String nombre;
    private String apellido;
    private Set<Monedero> monederos;
    private List<LineaCompra> carrito;
    private List<List<LineaCompra>> buyHistory;


    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public Set<Monedero> getMonederos() {
        return monederos;
    }

    public void setMonederos(Set<Monedero> monederos) {
        this.monederos = monederos;
    }

    public List<LineaCompra> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<LineaCompra> carrito) {
        this.carrito = carrito;
    }

    public List<List<LineaCompra>> getBuyHistory() {
        return buyHistory;
    }

    public void setBuyHistory(List<List<LineaCompra>> buyHistory) {
        this.buyHistory = buyHistory;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni.equalsIgnoreCase(cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni.toLowerCase());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' + "\n" +
                ", nombre='" + nombre + '\'' + "\n" +
                ", apellido='" + apellido + '\'' + "\n" +
                ", monederos=" + monederos + "\n" +
                ", carrito=" + carrito + "\n" +
                "}\n";
    }
}
