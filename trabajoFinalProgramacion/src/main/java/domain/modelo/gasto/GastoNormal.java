package domain.modelo.gasto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GastoNormal extends Gasto {

    private String descripcion;


    public GastoNormal(String nombre, double cantidad, String descripcion) {
        super(nombre, cantidad);
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "GastoNormal{\n" +
                "nombre = " + getNombre() + "\n" +
                "cantidad = " + getCantidadGasto() + "\n" +
                "descripcion = " + descripcion + "\n" +
                '}';
    }
}
