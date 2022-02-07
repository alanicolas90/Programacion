package modelo;

import modelo.constantes.Constantes;

import java.util.Objects;

public class Producto {

    private String name;
    private double price;
    private int stock;

    public Producto(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Producto(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        return Objects.hash(name);
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
