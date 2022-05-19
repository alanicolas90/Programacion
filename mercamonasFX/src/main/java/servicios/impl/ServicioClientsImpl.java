package servicios.impl;


import dao.DaoClientes;
import dao.DaoMonedero;
import dao.DaoProducto;
import jakarta.inject.Inject;
import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.LineaCompra;
import domain.modelo.cliente.Monedero;
import servicios.ServicioClients;

import java.util.List;
import java.util.Set;


public class ServicioClientsImpl implements ServicioClients {

  private final DaoClientes daoClientes;
  private final DaoProducto daoProducto;
  private final DaoMonedero daoMonedero;

  @Inject
  public ServicioClientsImpl(DaoClientes daoClientes, DaoProducto daoProducto, DaoMonedero daoMonedero) {
    this.daoClientes = daoClientes;
    this.daoProducto = daoProducto;
    this.daoMonedero = daoMonedero;
  }
  @Override
  public boolean addClient(Cliente newClient) {
    boolean canBeAdded = !daoClientes.existClient(newClient.getDni());
    if (canBeAdded) {
       return daoClientes.addClient(newClient);
    }
    return false;
  }
  @Override
  public boolean removeClient(String dniClient) {
    boolean exists = daoClientes.existClient(dniClient);
    if (exists) {
      return daoClientes.removeClient(dniClient);
    }
    return false;
  }
  @Override
  public boolean swapNameClient(Cliente c, String nuevoNombreCliente) {
    boolean exists = daoClientes.existClient(c.getDni());
    if (exists) {
      return daoClientes.swapNameClient(c, nuevoNombreCliente);
    }
    return false;
  }
  @Override
  public boolean swapDni(String dniClient, String nuevoDniCliente) {
    boolean exists = daoClientes.existClient(dniClient);
    if (exists) {
      return daoClientes.swapDni(dniClient, nuevoDniCliente);
    }
    return false;
  }
  @Override
  public boolean existeCliente(String dniClient) {
    return daoClientes.existClient(dniClient);}
  @Override
  public List<Cliente> showListClients() {
    return daoClientes.verListaClientes();
  }
  @Override
  public List<Cliente> getListClientes() {
    return daoClientes.showClientes();
  }
  @Override
  public boolean addMoney(String dniCliente, String nombreTarjeta, double dineroAgregar) {
    boolean exists = daoMonedero.monederoExists(nombreTarjeta, dniCliente);
    if (exists)
      return daoMonedero.addMoneyMonedero(dniCliente, nombreTarjeta, dineroAgregar);
    return false;
  }
  @Override
  public boolean addMonedero(Monedero monedero, String dniClient) {
    boolean canBeAdded = !daoMonedero.monederoExists(monedero.getName(), dniClient);
    if (canBeAdded) {
      return daoMonedero.addMonedero(monedero, dniClient);
    }
    return false;
  }
  @Override
  public boolean removeMonedero(String nombreMonedero, String dniClient) {
    boolean exists = daoMonedero.monederoExists(nombreMonedero, dniClient);
    if (exists) {
      return daoMonedero.removeMonedero(dniClient, nombreMonedero);
    }
    return false;
  }
  @Override
  public Set<Monedero> showTarjetasCliente(String dniClient) {
    return daoMonedero.showTarjetasCliente(dniClient);
  }
  @Override
  public Cliente verDataCliente(String dniClient) {
    boolean esClienteConDescuento = daoClientes.clienteTieneDescuento(dniClient);
    if (esClienteConDescuento) {
      return daoClientes.seeSpecificClientDescuento(dniClient);
    } else {
      return daoClientes.seeSpecificClient(dniClient);
    }
  }
  @Override
  public List<LineaCompra> showCarrito(String dniClient) {
    return daoClientes.dameCarrito(dniClient);
  }
  @Override
  public double getTotalPrice(String dniClient) {
    boolean esClienteConDescuento = daoClientes.clienteTieneDescuento(dniClient);
    double precioTotalCarrito = 0;

    List<LineaCompra> carrito = daoClientes.dameCarrito(dniClient);
    for (LineaCompra lineaCompra : carrito) {
      double precioProducto = daoProducto.getPriceProducto(lineaCompra.getProducto().getName());
      double cantidadProducto = lineaCompra.getQuantity();
      precioTotalCarrito = precioTotalCarrito + (cantidadProducto * precioProducto);
    }

    if (esClienteConDescuento) {
      precioTotalCarrito =
          (precioTotalCarrito * (1 - (daoClientes.getDescuentoCliente(dniClient) / 100)));
    }
    return precioTotalCarrito;
  }


  @Override
  public List<Cliente> showListClientsSortedDni() {
    return daoClientes.showListaClientesOrdenadaDni();
  }

  @Override
  public boolean addIngredienteAlergia(String dniClient, String ingrediente) {
    boolean ingredienteExisteCliente = !daoClientes.ingredienteExisteCliente(dniClient, ingrediente);
    if (ingredienteExisteCliente) {
      daoClientes.addIngredienteAlergia(dniClient, ingrediente);
    }
    return ingredienteExisteCliente;
  }

  @Override
  public boolean tieneComprasAnteriores(String dniClient) {
    return daoClientes.tieneComprasAnteriores(dniClient);
  }

  @Override
  public double dineroTotalGastado(String dniClient) {
    boolean esClienteConDescuento = daoClientes.clienteTieneDescuento(dniClient);

    double precioTotalCarrito = 0;
    List<List<LineaCompra>> historial = daoClientes.showBuyHistory(dniClient);
    for (int i = 0; i < historial.size(); i++) {
      List<LineaCompra> carrito = daoClientes.getLineaCompra(dniClient, i);
      for (LineaCompra lineaCompra : carrito) {
        double precioProducto = daoProducto.getPriceProducto(lineaCompra.getProducto().getName());
        double cantidadProducto = carrito.get(i).getQuantity();
        precioTotalCarrito += (cantidadProducto * precioProducto);
      }
    }
    if (esClienteConDescuento) {
      precioTotalCarrito =
          (precioTotalCarrito * (1 - (daoClientes.getDescuentoCliente(dniClient) / 100)));
    }
    return precioTotalCarrito;
  }

  @Override
  public List<Cliente> showClientesSortedDineroGastado() {
    return daoClientes.showListaClientesSortedDineroGastado();
  }

  @Override
  public List<Monedero> getMonederosCliente(String dniUser) {
    return daoClientes.getMonederosCliente(dniUser);
  }
}
