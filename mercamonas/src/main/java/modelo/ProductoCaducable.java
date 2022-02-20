package modelo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class ProductoCaducable extends Producto {

    private LocalDateTime caducidad;


    public ProductoCaducable(String name, double price, int stock, List<Ingrediente> ingredientes, LocalDateTime caducidad) {
        super(name, price, stock, ingredientes);
        this.caducidad = caducidad;
    }

    public ProductoCaducable(String name, LocalDateTime caducidad) {
        super(name);
        this.caducidad = caducidad;
    }

    public ProductoCaducable(String name, double price, int stock, LocalDateTime caducidad) {
        super(name, price, stock);
        this.caducidad = caducidad;
    }


    public LocalDateTime getCaducidad() {
        return caducidad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        ProductoCaducable that = (ProductoCaducable) o;
        return caducidad.equals(that.caducidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caducidad);
    }

    @Override
    public String toString() {
        return super.toString() + "ProductoCaducable{" + "caducidad=" + caducidad + '}';
    }


}
