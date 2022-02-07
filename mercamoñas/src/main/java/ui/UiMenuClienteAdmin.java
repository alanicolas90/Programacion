package ui;

import common.Common;
import constantes.Constantes;
import modelo.Cliente;
import servicios.ServicioClients;

import java.util.Scanner;

public class UiMenuClienteAdmin {

    public void menuClientesAdministrador(Scanner sc) {
        Common common = new Common();
        int optionMenuClienteAdmin;

        do {
            System.out.println(Constantes.MENU_CLIENTE_ADMIN);
            optionMenuClienteAdmin = common.giveInt();


            switch (optionMenuClienteAdmin) {

                case 1:
                    createNewClient(sc);
                    break;
                case 2:
                    deleteClient(sc);
                    break;
                case 3:
                    changeDniClient(sc);
                    break;
                case 4:
                    changeNameClient(sc);
                    break;
                case 5:
                    changeSurnameClient(sc);
                    break;
                case 6:
                    showListClients();
                    break;
                case 0:
                    System.out.println(Constantes.HASTA_LA_NEXT);
                    break;
                default:
                    System.out.println(Constantes.ERROR_POR_FAVOR_TRY_AGAIN);
                    break;
            }
        } while (optionMenuClienteAdmin != 0);
    }

    private void showListClients() {
        ServicioClients servicioClients = new ServicioClients();
        System.out.println(servicioClients.showListClients());
    }

    private void changeSurnameClient(Scanner sc) {
        ServicioClients servicioClients = new ServicioClients();
        String dniClient;
        System.out.println(Constantes.DIME_EL_DNI_DEL_USUARIO);
        dniClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_NUEVO_APELLIDO_DEL_CLIENTE);
        String newSurnameClient = sc.nextLine();

        if (servicioClients.swapSurnameClient(dniClient, newSurnameClient)) {
            System.out.println(Constantes.EL_APELLIDO_SE_HA_CAMBIADO_CON_SUCCESS);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_HACER_LOS_CAMBIOS);
        }
    }

    private void changeNameClient(Scanner sc) {
        ServicioClients servicioClients = new ServicioClients();

        String dniClient;
        System.out.println(Constantes.DIME_EL_DNI_DEL_USUARIO);
        dniClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_NUEVO_NOMBRE_DEL_CLIENTE);
        String newNameClient = sc.nextLine();

        if (servicioClients.swapNameClient(dniClient, newNameClient)) {
            System.out.println(Constantes.EL_NOMBRE_HA_SIDO_CAMBIADO_CON_SUCCESS);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_HACER_LOS_CAMBIOS);
        }
    }

    private void changeDniClient(Scanner sc) {
        ServicioClients servicioClients = new ServicioClients();

        String dniClient;
        System.out.println(Constantes.DIME_EL_DNI_DEL_USUARIO);
        dniClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_NUEVO_DNI_DEL_CLIENTE);
        String newDniClient = sc.nextLine();
        if (servicioClients.swapDni(dniClient, newDniClient)) {
            System.out.println(Constantes.EL_DNI_SE_HA_CAMBIADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_HACER_LOS_CAMBIOS);
        }
    }

    private void deleteClient(Scanner sc) {
        ServicioClients servicioClients = new ServicioClients();

        String dniClient;
        System.out.println(Constantes.DIME_EL_DNI_DEL_CLIENTE_QUE_DESEA_BORRAR);
        dniClient = sc.nextLine();

        if (servicioClients.removeClient(dniClient)) {
            System.out.println(Constantes.EL_USUARIO_HA_SIDO_ELIMINADO_CON_SUCCESS);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_ELIMINAR_AL_CLIENTE);
        }
    }

    private void createNewClient(Scanner sc) {
        ServicioClients servicioClients = new ServicioClients();

        System.out.println(Constantes.DIME_EL_NOMBRE_DEL_CLIENTE);
        String nameClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_APELLIDO_DEL_CLIENTE);
        String surnameClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_DNI_DEL_CLIENTE);
        String dniClient = sc.nextLine();

        Cliente newClient = new Cliente(nameClient, surnameClient, dniClient);

        if (servicioClients.addClient(newClient)) {
            System.out.println(Constantes.SE_HA_AGREGADO_EL_CLIENTE_CON_SUCCESS);
        } else {
            System.out.println(Constantes.LO_SENTIMOS_NO_SE_HA_PODIDO_AGREGAR_AL_CLIENTE);
        }
    }
}
