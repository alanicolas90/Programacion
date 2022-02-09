package ui.client;

import common.Common;
import constantes.Constantes;

import java.util.Scanner;

public class UiMenuClient {
    public void menuSwitchClient(Scanner sc) {
        Common common = new Common();

        int clientOption;
        do {
            System.out.println("Que desea hacer?\n" +
                    "1) Ajustes de usuario\n" +
                    "2) Comprar\n\n" +
                    "0) Exit");
            clientOption = common.giveInt();

            switch (clientOption) {
                case 1:
                    UiClientSettings uiClientSettings = new UiClientSettings();
                    uiClientSettings.settingsCliente(sc);
                    break;
                case 2:
                    UiMenuClientBuy uiMenuClientBuy = new UiMenuClientBuy();
                    uiMenuClientBuy.buyClient(sc);

                    System.out.println("Opciones de compra y ver historial");
                    break;
                case 0:
                    System.out.println("Hasta la proxima.");
                default:
                    System.out.println(Constantes.ERROR);
            }

        } while (clientOption != 0);
    }


}
