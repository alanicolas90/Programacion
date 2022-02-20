package ui.client;

import common.Common;
import constantes.Constantes;
import modelo.LineaCompra;
import modelo.Producto;
import servicios.ServicioClients;
import servicios.ServicioCompras;
import servicios.ServicioProductos;
import java.util.Scanner;

public class UiMenuClientBuy {

  public void buyClient(Scanner sc, String dniClient) {
    Common common = new Common();
    int clientDecision;

    do {
      System.out.println("LISTA DE PRODUCTOS");
      System.out.println("Que deseas hacer\n" +
              "1) Añadir producto al carrito\n" +
              "2) Eliminar un producto del carrito\n" +
              "3) Pagar por el carrito\n" +
              "4) Mostrar listado de productos sin mis alergias\n\n" +
              "0) Exit");
      clientDecision = common.giveInt();

      switch (clientDecision) {
        case 1:
          addProductCart(sc, dniClient);
          break;
        case 2:
          deleteProductFromCart(sc, dniClient);
          break;
        case 3:
          pagarElCarrito(sc, dniClient);
          break;
        case 4:
          showAllProductsSinAlergiasCliente(dniClient);
          break;
        case 0:
          System.out.println("Muchas gracias y hasta luego.");
          break;
        default:
          System.out.println(Constantes.ERROR);

      }

    } while (clientDecision != 0);

  }

  private void showAllProductsSinAlergiasCliente(String dniClient) {
    ServicioProductos servicioProductos = new ServicioProductos();
    System.out.println(servicioProductos.showAllProductsSinAlergiasCliente(dniClient));
  }

  private void pagarElCarrito(Scanner sc, String dniClient) {
    ServicioClients servicioClients = new ServicioClients();
    ServicioCompras servicioCompras = new ServicioCompras();
    // pagar el carrito
    System.out.print("El precio de tu carrito es:");
    System.out.println(servicioClients.getTotalPrice(dniClient));
    // elegir que tarjeta con la que pagar
    System.out.println("Con que tarjeta desea pagar?");
    System.out.println(servicioClients.showTarjetasCliente(dniClient));

    System.out.println("Ponga el nombre de la tarjeta:");
    String nombreTarjetaPagar = sc.nextLine();

    // mensaje que bien o mal
    // hacer las deducciones
    if (servicioCompras.pagarCarrito(dniClient, nombreTarjetaPagar)) {
      System.out.println("Ha sido un éxito");
    } else {
      System.out.println(Constantes.ERROR);
    }
    System.out.println(servicioClients.verDataCliente(dniClient));
  }

  private void deleteProductFromCart(Scanner sc, String dniClient) {
    ServicioCompras servicioCompras = new ServicioCompras();
    ServicioClients servicioClients = new ServicioClients();

    // imprimir solo el carrito del cliente
    System.out.println(servicioClients.showCarrito(dniClient));
    System.out.println("Dime el producto que desea eliminar del carrito");
    String nombreProductoBorrar = sc.nextLine();

    if (servicioCompras.removeProductCart(dniClient, nombreProductoBorrar)) {
      System.out.println("Ha sido un éxito");
      System.out.println(servicioClients.showCarrito(dniClient));
    } else {
      System.out.println(Constantes.ERROR);
    }
  }

  private void addProductCart(Scanner sc, String dniClient) {
    Common common = new Common();
    ServicioCompras servicioCompras = new ServicioCompras();
    ServicioProductos servicioProductos = new ServicioProductos();
    ServicioClients servicioClients = new ServicioClients();

    System.out.println("Elija un producto de esta lista:");
    System.out.println(servicioProductos.showAllProductsSinCaducados());

    System.out.println("que producto desea agregar al carrito?");
    String productoMeterCarrito = sc.nextLine();

    if (servicioProductos.existProduct(productoMeterCarrito)) {

      Producto productoAddCart = servicioProductos.getProductoLista(productoMeterCarrito);
      System.out.println("cuanta cantidad quiere?");
      int quantity = common.giveInt();

      LineaCompra carritoAdd = new LineaCompra(productoAddCart, quantity);

      if (servicioCompras.addToCart(dniClient, carritoAdd)) {
        System.out.println("Éxito");
      } else {
        System.out.println(Constantes.ERROR);
      }
    } else {
      System.out.println("El producto no existe");
    }

    System.out.println(servicioClients.verDataCliente(dniClient));
    System.out.println(servicioClients.showCarrito(dniClient));
  }
}
