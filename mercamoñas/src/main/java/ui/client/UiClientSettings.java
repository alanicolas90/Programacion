package ui.client;

import common.Common;
import constantes.Constantes;
import servicios.ServicioClients;
import servicios.ServicioCompras;

import java.util.Scanner;

public class UiClientSettings {

    public void settingsCliente(Scanner sc, String dniClient) {
        Common common = new Common();
        int settingsClient;

        do {
            System.out.println("Que desea hacer?\n" +
                    "1) Cambiar nombre.\n" +
                    "2) Cambiar apellido.\n" +
                    "3) Agregar tarjeta\n" +
                    "4) Eliminar tarjeta\n" +
                    "5) Agregar money\n" +
                    "6) Mostrar datos del usuario\n" +
                    "7) Mostrar compras antiguas\n\n" +
                    "0) Exit");
            settingsClient= common.giveInt();

            switch (settingsClient){
                case 1:
                    changeName(sc, dniClient);
                    break;
                case 2:
                    changeSurname(sc, dniClient);
                    break;
                case 3:
                    System.out.println("Añadir tarjeta");
                    break;
                case 4:
                    System.out.println("Delete tarjeta");
                    break;
                case 5:
                    System.out.println("add money");
                    break;
                case 6:
                    //ver tarjetas
                    showSpecificDataUser(sc);
                    break;
                case 7:
                    ServicioCompras servicioCompras = new ServicioCompras();
                    servicioCompras.showBuyHistory();
                    System.out.println("mostrar compras antiguas");
                    break;
                case 0:
                    System.out.println(Constantes.BYE_BYE);
                    break;
                default:
                    System.out.println(Constantes.ERROR);
                    break;
            }
        } while (settingsClient != 0);
    }

    private void showSpecificDataUser(Scanner sc) {
        System.out.println("show client data(name surname and monedero)");
        ServicioClients servicioClients = new ServicioClients();
        System.out.println("Confirme su DNI");
        String dniClient= sc.nextLine();

        System.out.println(servicioClients.showSpecificClient(dniClient));
    }

    private void changeSurname(Scanner sc,String dniClient) {
        ServicioClients servicioClients = new ServicioClients();

        System.out.println(Constantes.DIME_EL_NUEVO_APELLIDO_DEL_CLIENTE);
        String newSurnameClient = sc.nextLine();

        if (servicioClients.swapSurnameClient(dniClient, newSurnameClient)) {
            System.out.println(Constantes.EL_APELLIDO_SE_HA_CAMBIADO_CON_SUCCESS);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_HACER_LOS_CAMBIOS);
        }
    }

    private void changeName(Scanner sc, String dniCliente) {
        ServicioClients servicioClients = new ServicioClients();

        System.out.println(Constantes.DIME_EL_NUEVO_NOMBRE_DEL_CLIENTE);
        String newNameClient = sc.nextLine();

        if (servicioClients.swapNameClient(dniCliente, newNameClient)) {
            System.out.println(Constantes.EL_NOMBRE_HA_SIDO_CAMBIADO_CON_SUCCESS);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_HACER_LOS_CAMBIOS);
        }
    }
}
