package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import modelo.constantes.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor

public class Producto {

    private String name;
    private double price;
    private int stock;
    private List<Ingrediente> ingredientes;

    public Producto(String name) {
        this.name = name;
    }

    public Producto(String name, double price, int stock){
        this.name = name;
        this.price=price;
        this.stock=stock;
    }

    private Producto(){
        ingredientes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return name.equalsIgnoreCase(producto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return "\n" + Constantes.PRODUCTO +
                modelo.constantes.Constantes.NAME + name + modelo.constantes.Constantes.CHAR +
                Constantes.PRICE + price +
                Constantes.STOCK + stock +
                Constantes.CHAR;
    }
}
