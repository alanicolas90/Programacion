package ui.client;

import common.Common;
import constantes.Constantes;
import jakarta.inject.Inject;
import servicios.ServicioClients;

import java.util.Scanner;

public class UiMenuClient {

    private final ServicioClients servicioClients;
    private final UiClientSettings uiClientSettings;
    private final UiMenuClientBuy uiMenuClientBuy;

    @Inject
    public UiMenuClient(ServicioClients servicioClients, UiClientSettings uiClientSettings, UiMenuClientBuy uiMenuClientBuy) {
        this.servicioClients = servicioClients;
        this.uiClientSettings = uiClientSettings;
        this.uiMenuClientBuy = uiMenuClientBuy;
    }

    public void menuSwitchClient(Scanner sc) {
        Common common = new Common();
        int clientOption;
        String dniClient;
        boolean dniExiste;

        do {
            System.out.println(Constantes.DIGAME_SU_DNI);
            dniClient = sc.nextLine();

            if (servicioClients.existeCliente(dniClient)) {
                System.out.println(Constantes.BIENVENIDO);
                dniExiste = true;
            } else {
                System.out.println(Constantes.ERROR_INTENTELO_DE_NUEVO);
                dniExiste = false;
            }
        } while (!dniExiste);

        do {

            System.out.println(Constantes.MENUCLIENTE);
            clientOption = common.giveInt();

            switch (clientOption) {
                case 1:
                    uiClientSettings.settingsCliente(sc, dniClient);
                    break;
                case 2:
                    uiMenuClientBuy.buyClient(sc, dniClient);
                    break;
                case 0:
                    System.out.println(Constantes.HASTA_LA_NEXT);
                    break;
                default:
                    System.out.println(Constantes.ERROR);
            }

        } while (clientOption != 0);
    }


}
