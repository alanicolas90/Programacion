package ui.client;

import common.Common;
import constantes.Constantes;
import servicios.ServicioProductos;

import java.util.Scanner;

public class UiMenuClientBuy {

    public void buyClient(Scanner sc) {
        Common common = new Common();
        int clientDecision;

        do {
            System.out.println("LISTA DE PRODUCTOS");
            System.out.println("Que deseas hacer");
            clientDecision = common.giveInt();

            switch (clientDecision) {
                case 1:
                    System.out.println("meter un producto al carrito de la compra");
                    ServicioProductos servicioProductos = new ServicioProductos();
                    System.out.println(servicioProductos.showAllProducts());

                    System.out.println("que producto desea agregar al carrito");
                    String productoMeterCarrito = sc.nextLine();
                    break;
                case 2:
                    System.out.println("quitar un producto del carrito de compra");
                    break;
                case 3:
                    System.out.println("pagar el carrito");
                    break;
                case 0:
                    System.out.println("Muchas gracias y hasta luego.");
                    break;
                default:
                    System.out.println(Constantes.ERROR);

            }

        } while (clientDecision != 0);

    }
}
