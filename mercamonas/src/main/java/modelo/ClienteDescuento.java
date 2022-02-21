package modelo;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ClienteDescuento extends Cliente {

  private double descuento;

  public ClienteDescuento(String dni, String nombre, String apellido, Set<Monedero> monederos, List<Ingrediente> alergenos, List<LineaCompra> carrito, List<List<LineaCompra>> buyHistory, double descuento) {
    super(dni, nombre, apellido, monederos, alergenos, carrito, buyHistory);
    this.descuento = descuento;
  }

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
  public Cliente clone() {
    return new ClienteDescuento(this.getDni(), this.getNombre(), this.getApellido(), this.getMonederos(), this.getAlergenos(),
            this.getCarrito(), this.getBuyHistory(), this.descuento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), descuento);
  }

  @Override
  public String toString() {
    return super.toString() + "ClienteDescuento{" + "descuento=" + descuento + "%" + "}\n";
  }
}
