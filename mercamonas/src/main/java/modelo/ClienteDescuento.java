package modelo;

import lombok.Data;
import java.util.Objects;

@Data
public class ClienteDescuento extends Cliente {

    private double descuento;

    public ClienteDescuento(String dni, String nombre, String apellido, double descuento) {
        super(dni, nombre, apellido);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descuento);
    }

    @Override
    public String toString() {
        return super.toString() +"ClienteDescuento{" +
                "descuento=" + descuento + "%" +
                '}';
    }
}
