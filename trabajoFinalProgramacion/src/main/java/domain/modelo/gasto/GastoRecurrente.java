package domain.modelo.gasto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GastoRecurrente extends Gasto {

    private Integer recurrencia;

    public GastoRecurrente(String nombre, double cantidad, Integer recurrencia) {
        super(nombre, cantidad);
        this.recurrencia = recurrencia;
    }


    @Override
    public String toString() {
        return "GastoRecurrente{\n" +
                "nombre = " + getNombre() + "\n" +
                "cantidad = " + getCantidadGasto() + "\n" +
                "recurrencia = " + recurrencia + "\n" +
                '}';
    }
}
