package dao;

import modelo.Cliente;
import modelo.LineaCompra;
import modelo.Monedero;
import modelo.Producto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DaoCompras {

  private LinkedHashMap<String, Cliente> clientes;
  private ArrayList<Producto> productos;

  public DaoCompras(ArrayList<Producto> productos) {
    this.productos = productos;
  }

  public DaoCompras(LinkedHashMap<String, Cliente> clientes) {
    this.clientes = clientes;
  }

// -------------------------------------------------------------------------------------------------------------------
  public boolean alreadyInCart(Producto producto, String dniClient) {
    return clientes.get(dniClient).getCarrito().contains(new LineaCompra(producto));
  }

  public void addCart(String dniClient, LineaCompra productoNuevoCarrito) {
    clientes.get(dniClient).getCarrito().add(productoNuevoCarrito);
  }

  public void deleteProductCart(String dniClient, String nombreProductoBorrar) {
    clientes.get(dniClient).getCarrito()
        .remove(new LineaCompra(new Producto(nombreProductoBorrar)));
  }

  public void guardarCompra(String dniClient, List<LineaCompra> lineaCompras) {
    clientes.get(dniClient).getBuyHistory().add(lineaCompras);
  }

  public void cambiarStockComprar(String nombreProducto, int cantidadStockRestar) {
    int positionProductoBusco = productos.indexOf(new Producto(nombreProducto));
    productos.get(positionProductoBusco)
        .setStock((productos.get(positionProductoBusco).getStock()) - cantidadStockRestar);
  }

  public void ajustarDineroMonederoAfterCompra(String dniClient, String nombreMonedero, double precioRestar) {
    clientes.get(dniClient).getMonederos().forEach(monedero -> {
      if (monedero.equals(new Monedero(nombreMonedero))) {
        monedero.setMoney((monedero.getMoney() - precioRestar));
      }
    });
  }


}
