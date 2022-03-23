package modelo;

import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class ClienteNormal extends Cliente{
    private String type;
    public ClienteNormal(String dni, String nombre, Set<Monedero> monederos, List<Ingrediente> alergenos, List<LineaCompra> carrito, List<List<LineaCompra>> buyHistory) {
        super(dni, nombre, monederos, alergenos, carrito, buyHistory);
        this.type="clienteNormal";
    }

    public ClienteNormal(String dni, String nombre) {
        super(dni, nombre);
        this.type="clienteNormal";
    }

    public ClienteNormal(String dni, String nombre, Set<Monedero> monederos, List<LineaCompra> carrito, List<List<LineaCompra>> buyHistory) {
        super(dni, nombre, monederos, carrito, buyHistory);
        this.type="clienteNormal";
    }

    @Override
    public String toString() {
        return "ClienteNormal{" +
                "type='" + type + '\'' +
                '}';
    }

}
