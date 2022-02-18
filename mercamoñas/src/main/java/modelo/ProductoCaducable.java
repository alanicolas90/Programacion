package modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductoCaducable extends Producto{

    private LocalDateTime caducidad;

    public ProductoCaducable(String name, double price, int stock, LocalDateTime caducidad) {
        super(name, price, stock);
        this.caducidad = caducidad;
    }

    public LocalDateTime getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(LocalDateTime caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductoCaducable that = (ProductoCaducable) o;
        return caducidad.equals(that.caducidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caducidad);
    }

    @Override
    public String toString() {
        return "ProductoCaducable{" +
                "caducidad=" + caducidad +
                '}';
    }
}
