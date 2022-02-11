package ui.client;

import common.Common;
import constantes.Constantes;
import modelo.LineaCompra;
import modelo.Producto;
import servicios.ServicioCompras;
import servicios.ServicioProductos;

import java.util.ArrayList;
import java.util.List;
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
                    "3) Pagar por el carrito\n\n" +
                    "0) Exit");
            clientDecision = common.giveInt();

            switch (clientDecision) {
                case 1:
                    //agregar producto al carro de compra
                    addProductCart(sc, dniClient);
                    break;
                case 2:
                    //quitar un producto del carrito de compra
                    deleteProductFromCart(sc, dniClient);
                    break;
                case 3:
                    System.out.println("pagar el carrito");
                    System.out.print("El precio de tu carrito es:");
                    break;
                case 0:
                    System.out.println("Muchas gracias y hasta luego.");
                    break;
                default:
                    System.out.println(Constantes.ERROR);

            }

        } while (clientDecision != 0);

    }

    private void deleteProductFromCart(Scanner sc, String dniClient) {
        ServicioCompras servicioCompras = new ServicioCompras();

        System.out.println("Imprimir carrito solo"); //no se como se hace :)
        System.out.println("Dime el producto que desea eliminar del carrito");
        String nombreProductoBorrar = sc.nextLine();
        Producto productoBorrar = new Producto(nombreProductoBorrar);

        if (servicioCompras.removeProductCart(dniClient, productoBorrar)) {
            System.out.println("Ha sido un éxito");
        } else {
            System.out.println(Constantes.ERROR);
        }
    }

    private void addProductCart(Scanner sc, String dniClient) {
        Common common = new Common();
        ServicioCompras servicioCompras = new ServicioCompras();
        ServicioProductos servicioProductos = new ServicioProductos();

        System.out.println("Elija un producto de esta lista:");
        System.out.println(servicioProductos.showAllProducts());

        System.out.println("que producto desea agregar al carrito?");
        String productoMeterCarrito = sc.nextLine();
        Producto producto = new Producto(productoMeterCarrito);

        System.out.println("cuanta cantidad quiere?");
        int quantity = common.giveInt();

        LineaCompra productoAddCart = new LineaCompra(producto, quantity);

        if (servicioCompras.addToCart(dniClient, productoAddCart)) {
            System.out.println("Éxito");
        } else {
            System.out.println(Constantes.ERROR);
        }
    }
}
