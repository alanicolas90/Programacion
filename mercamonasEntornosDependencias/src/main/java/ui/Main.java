package ui;

import common.Common;
import constantes.Constantes;
import ui.admin.UiMenuAdmin;
import ui.client.UiMenuClient;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    final SeContainer container = initializer.initialize();

    Scanner sc = new Scanner(System.in);
    Common common = new Common();

    UiMenuAdmin menuSwitchAdmin = container.select(UiMenuAdmin.class).get();
    UiMenuClient menuSwitchClient = container.select(UiMenuClient.class).get();

    System.out.println(Constantes.BIENVENIDA);
    int optionUser;

    do {
      System.out.println(Constantes.MENU_ELEGIR_USUARIO);
      optionUser = common.giveInt();

      switch (optionUser) {
        case 1:
          menuSwitchAdmin.menuSwitchAdmin(sc);
          break;
        case 2:
          menuSwitchClient.menuSwitchClient(sc);
          break;
        case 0:
          System.out.println(Constantes.HASTA_LA_PROXIMA);
          break;
        default:
          System.out.println(Constantes.ERROR_POR_FAVOR_TRY_AGAIN);
          break;
      }
    } while (optionUser != 0);

    container.close();
  }
}
