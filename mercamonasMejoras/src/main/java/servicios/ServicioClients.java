package servicios;

import dao.DaoClientes;
import dao.DaoMonedero;
import dao.DaoProducto;
import modelo.Cliente;
import modelo.LineaCompra;
import modelo.Monedero;
import java.util.List;
import java.util.Set;


public class ServicioClients {
  private DaoClientes dao;

  public ServicioClients(DaoClientes dao) {
    this.dao = dao;
  }

  public boolean addClient(Cliente newClient) {

    boolean canBeAdded = !dao.existClient(newClient.getDni());
    if (canBeAdded) {
      dao.addClient(newClient);
    }
    return canBeAdded;
  }

  public boolean removeClient(String dniClient) {
    boolean exists = dao.existClient(dniClient);

    if (exists) {
      dao.removeClient(dniClient);
    }
    return exists;
  }

  public boolean swapNameClient(String dniClient, String nuevoNombreCliente) {
    boolean exists = dao.existClient(dniClient);
    if (exists) {
      dao.swapNameClient(dniClient, nuevoNombreCliente);
    }
    return exists;
  }


  public boolean swapDni(String dniClient, String nuevoDniCliente) {
    boolean exists = dao.existClient(dniClient);
    if (exists) {
      dao.swapDni(dniClient, nuevoDniCliente);
    }
    return exists;
  }

  public boolean existeCliente(String dniClient) {
    return dao.existClient(dniClient);
  }

  public List<Cliente> showListClients() {
    return dao.verListaClientes();
  }

  public boolean addMoney(String dniCliente, String nombreTarjeta, double dineroAgregar) {
    DaoMonedero daoMonedero = new DaoMonedero();
    boolean exists = daoMonedero.monederoExists(nombreTarjeta, dniCliente);
    if (exists)
      daoMonedero.addMoneyMonedero(dniCliente, nombreTarjeta, dineroAgregar);
    return exists;
  }

  public boolean addMonedero(Monedero monedero, String dniClient) {
    DaoMonedero daoMonedero = new DaoMonedero();
    boolean canBeAdded = !daoMonedero.monederoExists(monedero.getName(), dniClient);
    if (canBeAdded) {
      daoMonedero.addMonedero(monedero, dniClient);
    }
    return canBeAdded;
  }

  public boolean removeMonedero(String nombreMonedero, String dniClient) {
    DaoMonedero daoMonedero = new DaoMonedero();
    boolean exists = daoMonedero.monederoExists(nombreMonedero, dniClient);
    if (exists) {
      daoMonedero.removeMonedero(dniClient, nombreMonedero);
    }
    return exists;
  }

  public Set<Monedero> showTarjetasCliente(String dniClient) {
    DaoMonedero daoMonedero = new DaoMonedero();
    return daoMonedero.showTarjetasCliente(dniClient);
  }

  public Cliente verDataCliente(String dniClient) {
    boolean esClienteConDescuento = dao.clienteTieneDescuento(dniClient);
    if (esClienteConDescuento) {
      return dao.seeSpecificClientDescuento(dniClient);
    } else {
      return dao.seeSpecificClient(dniClient);
    }
  }

  public List<LineaCompra> showCarrito(String dniClient) {
    return dao.dameCarrito(dniClient);
  }

  public double getTotalPrice(String dniClient) {
    DaoProducto daoProducto = new DaoProducto();
    boolean esClienteConDescuento = dao.clienteTieneDescuento(dniClient);
    double precioTotalCarrito = 0;

    List<LineaCompra> carrito = dao.dameCarrito(dniClient);
    for (LineaCompra lineaCompra : carrito) {
      double precioProducto = daoProducto.getPriceProducto(lineaCompra.getProducto().getName());
      double cantidadProducto = lineaCompra.getQuantity();
      precioTotalCarrito = precioTotalCarrito + (cantidadProducto * precioProducto);
    }

    if (esClienteConDescuento) {
      precioTotalCarrito =
          (precioTotalCarrito * (1 - (dao.getDescuentoCliente(dniClient) / 100)));
    }
    return precioTotalCarrito;
  }


  public List<Cliente> showListClientsSotedDni() {
    return dao.showListaClientesOrdenadaDni();
  }

  public boolean addIngredienteAlergia(String dniClient, String ingrediente) {
    boolean ingredienteExisteCliente =
        !dao.ingredienteExisteCliente(dniClient, ingrediente);
    if (ingredienteExisteCliente) {
      dao.addIngredienteAlergia(dniClient, ingrediente);
    }
    return ingredienteExisteCliente;
  }

  public boolean tieneComprasAnteriores(String dniClient) {
    return dao.tieneComprasAnteriores(dniClient);
  }

  public double dineroTotalGastado(String dniClient) {
    DaoProducto daoProducto = new DaoProducto();
    boolean esClienteConDescuento = dao.clienteTieneDescuento(dniClient);

    double precioTotalCarrito = 0;
    List<List<LineaCompra>> historial = dao.dameHistorialCompra(dniClient);
    for (int i = 0; i < historial.size(); i++) {
      List<LineaCompra> carrito = dao.getLineaCompra(dniClient, i);
      for (LineaCompra lineaCompra : carrito) {
        double precioProducto = daoProducto.getPriceProducto(lineaCompra.getProducto().getName());
        double cantidadProducto = carrito.get(i).getQuantity();
        precioTotalCarrito += (cantidadProducto * precioProducto);
      }
    }
    if (esClienteConDescuento) {
      precioTotalCarrito =
          (precioTotalCarrito * (1 - (dao.getDescuentoCliente(dniClient) / 100)));
    }
    return precioTotalCarrito;
  }

  public List<Cliente> showClientesSortedDineroGastado() {
    return dao.showListaClientesSortedDineroGastado();
  }
}
