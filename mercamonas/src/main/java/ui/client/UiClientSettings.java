package ui.client;

import common.Common;
import constantes.Constantes;
import dao.DaoClientes;
import modelo.Monedero;
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
              "7) Mostrar compras antiguas\n" +
              "8) Añadir alergeno\n" +
              "9) Gasto total en la tienda\n" +
              "0) Exit");
      settingsClient = common.giveInt();

      switch (settingsClient) {
        case 1:
          changeName(sc, dniClient);
          break;
        case 2:
          changeSurname(sc, dniClient);
          break;
        case 3:
          addMonedero(sc, dniClient);
          break;
        case 4:
          deleteMonedero(sc, dniClient);
          break;
        case 5:
          agregarDineroMonederoExistente(sc, dniClient);
          break;
        case 6:
          showDataCliente(dniClient);
          break;
        case 7:
          showHistorialCompras(dniClient);
          break;
        case 8:
          addAlergiaCliente(sc, dniClient);
          break;
        case 9:
          ServicioClients servicioClients = new ServicioClients();
          if(servicioClients.tieneComprasAnteriores(dniClient)){
            System.out.println("Usted no ha comprado nunca en la tienda");
          }else{
            System.out.println(servicioClients.dineroTotalGastado(dniClient));
          }

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

  private void addAlergiaCliente(Scanner sc, String dniClient) {
    ServicioClients servicioClients = new ServicioClients();
    System.out.println("Dime el ingrediente al que tienes alergia");
    String ingrediente= sc.nextLine();
    if(servicioClients.addIngredienteAlergia(dniClient, ingrediente)){
      System.out.println("Ha sido un éxito");
    }else{
      System.out.println("ERROR");
    }
    return;
  }

  private void showHistorialCompras(String dniClient) {
    ServicioCompras servicioCompras = new ServicioCompras();
    System.out.println(servicioCompras.showBuyHistory(dniClient));
  }

  private void deleteMonedero(Scanner sc, String dniClient) {
    ServicioClients servicioClients = new ServicioClients();
    System.out.println("Como se llama el monedero?");
    String nombreMonedero = sc.nextLine();

    if (servicioClients.removeMonedero(nombreMonedero, dniClient)) {
      System.out.println("Eliminado con éxito");
      System.out.println(servicioClients.verDataCliente(dniClient));
    } else {
      System.out.println(Constantes.ERROR);
    }
  }

  private void addMonedero(Scanner sc, String dniClient) {
    Common common = new Common();
    ServicioClients servicioClients = new ServicioClients();
    System.out.println("Añadir monedero");
    System.out.println("Como desea que se llame el monedero?");
    String nombreMonedero = sc.nextLine();

    System.out.println("Cuanto dinero desea introducir al monedero?");
    double dineroAgregarTarjeta = common.giveDouble();

    Monedero monedero = new Monedero(nombreMonedero, dineroAgregarTarjeta);

    if (servicioClients.addMonedero(monedero, dniClient)) {
      System.out.println("Ha sido un éxito");
      System.out.println(servicioClients.verDataCliente(dniClient));
    } else {
      System.out.println(Constantes.ERROR);
    }
  }

  private void agregarDineroMonederoExistente(Scanner sc, String dniClient) {
    Common common = new Common();
    ServicioClients servicioClients = new ServicioClients();

    System.out.println("A que tarjeta desea agregarle dinero?");
    // mostrar tarjetas IMPORTANTE
    String nombreTarjeta = sc.nextLine();

    System.out.println("Cuanto dinero desea agregarle?");
    double dineroAgregar = common.giveDouble();

    if (servicioClients.addMoney(dniClient, nombreTarjeta, dineroAgregar)) {
      System.out.println("Logrado con éxito");
      System.out.println(servicioClients.verDataCliente(dniClient));
    } else {
      System.out.println(Constantes.ERROR);
    }
  }

  private void showDataCliente(String dniClient) {
    ServicioClients servicioClients = new ServicioClients();
    System.out.println(servicioClients.verDataCliente(dniClient));
  }

  private void changeSurname(Scanner sc, String dniClient) {
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
