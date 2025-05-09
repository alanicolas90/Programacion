package ui.admin;

import common.Common;
import constantes.Constantes;
import jakarta.inject.Inject;
import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.ClienteDescuento;
import domain.modelo.cliente.ClienteNormal;
import servicios.ServicioClients;

import java.util.Scanner;


public class UiMenuAdminCliente {

    private final ServicioClients servicioClients;
    private final Scanner sc;

    @Inject
    public UiMenuAdminCliente(ServicioClients servicioClients, Scanner sc) {
        this.servicioClients = servicioClients;
        this.sc = sc;
    }

    public void menuClientesAdministrador() {
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
                    addClienteConDescuento(sc);
                    break;
                case 3:
                    deleteClient(sc);
                    break;
                case 4:
                    changeDniClient(sc);
                    break;
                case 5:
                    changeNameClient(sc);
                    break;
                case 6:
                    showListClients();
                    break;
                case 7:
                    showListClientesSortedDnie();
                    break;
                case 8:
                    System.out.println(servicioClients.showClientesSortedDineroGastado());
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

    private void showListClientesSortedDnie() {
        System.out.println(servicioClients.showListClientsSortedDni());
    }

    private void addClienteConDescuento(Scanner sc) {
        Common common = new Common();

        System.out.println(Constantes.DIME_EL_NOMBRE_DEL_CLIENTE);
        String nameClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_DNI_DEL_CLIENTE);
        String dniClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_DESCUENTO_QUE_TIENE_NUMEROS_ENTEROS);
        double descuentoCliente = common.giveDouble();

        Cliente newClient =
                new ClienteDescuento(dniClient, nameClient, descuentoCliente);

        if (servicioClients.addClient(newClient)) {
            System.out.println(Constantes.SE_HA_AGREGADO_EL_CLIENTE_CON_SUCCESS);
        } else {
            System.out.println(Constantes.LO_SENTIMOS_NO_SE_HA_PODIDO_AGREGAR_AL_CLIENTE);
        }
    }

    private void showListClients() {
        System.out.println(servicioClients.showListClients());
    }

    private void changeNameClient(Scanner sc) {
        String dniClient;
        System.out.println(Constantes.DIME_EL_DNI_DEL_USUARIO);
        dniClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_NUEVO_NOMBRE_DEL_CLIENTE);
        String newNameClient = sc.nextLine();

        Cliente c= new ClienteNormal(dniClient);

        if (servicioClients.swapNameClient(c, newNameClient)) {
            System.out.println(Constantes.EL_NOMBRE_HA_SIDO_CAMBIADO_CON_SUCCESS);
        } else {
            System.out.println(Constantes.ERROR_NO_SE_HA_PODIDO_HACER_LOS_CAMBIOS);
        }
    }

    private void changeDniClient(Scanner sc) {
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
        System.out.println(Constantes.DIME_EL_NOMBRE_DEL_CLIENTE);
        String nameClient = sc.nextLine();

        System.out.println(Constantes.DIME_EL_DNI_DEL_CLIENTE);
        String dniClient = sc.nextLine();

        Cliente newClient = new ClienteNormal(dniClient,nameClient);

        if (servicioClients.addClient(newClient)) {
            System.out.println(Constantes.SE_HA_AGREGADO_EL_CLIENTE_CON_SUCCESS);
        } else {
            System.out.println(Constantes.LO_SENTIMOS_NO_SE_HA_PODIDO_AGREGAR_AL_CLIENTE);
        }
    }
}
