package servicios.impl;

import dao.DaoClientes;
import dao.DaoCompras;
import dao.DaoProducto;
import jakarta.inject.Inject;
import modelo.cliente.LineaCompra;
import servicios.ServicioClients;
import servicios.ServicioCompras;

import java.util.List;


public class ServicioComprasImpl implements ServicioCompras {

  private final DaoCompras daoCompras;
  private final DaoProducto daoProducto;
  private final DaoClientes daoClientes;
  private final ServicioClients servicioClients;

  @Inject
  public ServicioComprasImpl(DaoCompras daoCompras, DaoProducto daoProducto, DaoClientes daoClientes, ServicioClients servicioClients) {
    this.daoCompras = daoCompras;
    this.daoProducto = daoProducto;
    this.daoClientes = daoClientes;
    this.servicioClients = servicioClients;
  }

  @Override
  public boolean addToCart(String dniClient, LineaCompra productoAddCarrito) {
    boolean seHaMetido = false;

    boolean inCart = !daoCompras.alreadyInCart(productoAddCarrito.getProducto().getName(), dniClient);
    int stockTiendaProducto =
        daoProducto.getStockProduct(productoAddCarrito.getProducto().getName());

    if (inCart && productoAddCarrito.getQuantity() <= stockTiendaProducto) {
      daoCompras.addCart(dniClient, productoAddCarrito);
      daoCompras.cambiarStockComprar(productoAddCarrito.getProducto().getName(),
          productoAddCarrito.getQuantity());
      seHaMetido = true;
    }
    return seHaMetido;
  }

  @Override
  public boolean removeProductCart(String dniClient, String nombreProductoBorrar) {
    boolean isCart = daoCompras.alreadyInCart(nombreProductoBorrar, dniClient);
    if (isCart) {
      daoCompras.deleteProductCart(dniClient, nombreProductoBorrar);
    }
    return isCart;
  }

  @Override
  public void guardarHistorialCompra(String dniClient) {
    List<LineaCompra> lineaCompras = daoClientes.dameCarrito(dniClient);
    daoCompras.guardarCompra(dniClient, lineaCompras);
    daoClientes.emptyCart(dniClient);
  }

  @Override
  public List<List<LineaCompra>> showBuyHistory(String dniClient) {
    return daoClientes.showBuyHistory(dniClient);
  }

  @Override
  public boolean pagarCarrito(String dniClient, String nombreMonedero) {
    boolean seHaPagado = false;
    double precioTotalCarrito = servicioClients.getTotalPrice(dniClient);
    double dineroMonedero = daoClientes.getTodoDineroMonedero(dniClient, nombreMonedero);

    if (dineroMonedero >= precioTotalCarrito) {
      // monedero quito dinero
      double dineroRestanteMonedero = dineroMonedero - precioTotalCarrito;
      daoCompras.ajustarDineroMonederoAfterCompra(dniClient, nombreMonedero,
          dineroRestanteMonedero);
      guardarHistorialCompra(dniClient);

      seHaPagado = true;
    }
    return seHaPagado;
  }


}
