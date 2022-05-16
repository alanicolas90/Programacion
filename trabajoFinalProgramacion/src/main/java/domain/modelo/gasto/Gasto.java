package domain.modelo.gasto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Gasto {

    private String nombre;
    private double cantidadGasto;

    public Gasto(String nombre, double cantidadGasto) {
        this.nombre = nombre;
        this.cantidadGasto = cantidadGasto;
    }


    @Override
    public String toString() {
        return "Gasto{\n" +
                "nombre='" + nombre + "\n" +
                "cantidad=" + cantidadGasto + "\n" +
                '}';
    }
}
