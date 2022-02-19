package modelo;

import lombok.Data;

import java.util.*;

@Data
public class Cliente implements Clone<Cliente>{

    private String dni;
    private String nombre;
    private String apellido;
    private final Set<Monedero> monederos;

    private List<Ingrediente> alergenos;
    private List<LineaCompra> carrito;
    private List<List<LineaCompra>> buyHistory;

    public Cliente(String dni, String nombre, String apellido, Set<Monedero> monederos, List<Ingrediente> alergenos, List<LineaCompra> carrito, List<List<LineaCompra>> buyHistory) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.monederos = monederos;
        this.alergenos = alergenos;
        this.carrito = carrito;
        this.buyHistory = buyHistory;
    }

    private Cliente(){
        buyHistory = new ArrayList<>();
        monederos = new HashSet<>();
        carrito = new ArrayList<>();
    }

    public Cliente(String dni, String nombre, String apellido) {
        this();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String dni, String nombre, String apellido, Set<Monedero> monederos, List<LineaCompra> carrito, List<List<LineaCompra>> buyHistory) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.monederos = monederos;
        this.carrito = carrito;
        this.buyHistory = buyHistory;
    }

    public Set<Monedero> getMonederos() {
        return monederos;
    }

    public List<LineaCompra> getCarrito() {
        return carrito;
    }

    public List<List<LineaCompra>> getBuyHistory() {
        return buyHistory;
    }

    public void setCarrito(List<LineaCompra> carrito) {
        this.carrito = carrito;
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

    public List<Ingrediente> getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(List<Ingrediente> alergenos) {
        this.alergenos = alergenos;
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
        return "\nCliente{" +
                "\ndni='" + dni + '\'' +
                ",\nnombre='" + nombre + '\'' +
                ",\napellido='" + apellido + '\'' +
                ",\nmonederos=" + monederos +
                ",\ncarrito=" + carrito +
                ",\nbuyHistory=" + buyHistory +
                "}\n\n";
    }

    @Override
    public Cliente clone() {
        return new Cliente(this.dni,this.nombre,this.apellido
                ,this.monederos
                ,this.alergenos
                ,this.carrito
                ,this.buyHistory);
    }
}
