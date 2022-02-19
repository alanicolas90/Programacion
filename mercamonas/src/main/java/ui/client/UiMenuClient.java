package ui.client;

import common.Common;
import constantes.Constantes;
import servicios.ServicioClients;
import java.util.Scanner;

public class UiMenuClient {
  public void menuSwitchClient(Scanner sc) {
    ServicioClients servicioClients = new ServicioClients();
    Common common = new Common();
    int clientOption;
    String dniClient;
    boolean dniExiste;

    do {
      do {
        System.out.println("Dígame su dni");
        dniClient = sc.nextLine();

        if (servicioClients.existeCliente(dniClient)) {
          System.out.println("BIENVENIDO");
          dniExiste = true;
        } else {
          System.out.println("Error inténtelo de nuevo");
          dniExiste = false;
        }
      } while (!dniExiste);


      System.out
          .println("Que desea hacer?\n" + "1) Ajustes de usuario\n" + "2) Comprar\n\n" + "0) Exit");
      clientOption = common.giveInt();

      switch (clientOption) {
        case 1:
          UiClientSettings uiClientSettings = new UiClientSettings();
          uiClientSettings.settingsCliente(sc, dniClient);
          break;
        case 2:
          UiMenuClientBuy uiMenuClientBuy = new UiMenuClientBuy();
          uiMenuClientBuy.buyClient(sc, dniClient);

          System.out.println("Opciones de compra y ver historial");
          break;
        case 0:
          System.out.println("Hasta la próxima.");
          break;
        default:
          System.out.println(Constantes.ERROR);
      }

    } while (clientOption != 0);
  }


}
