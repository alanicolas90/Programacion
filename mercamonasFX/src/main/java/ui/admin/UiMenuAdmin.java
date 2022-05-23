package ui.admin;

import common.Common;
import constantes.Constantes;
import jakarta.inject.Inject;

import java.util.Scanner;

public class UiMenuAdmin {

  private final UiMenuAdminCliente menuClienteAdmin;
  private final UIMenuAdminProduct menuProductos;


  @Inject
  public UiMenuAdmin(UiMenuAdminCliente menuClienteAdmin, UIMenuAdminProduct menuProductos) {
    this.menuClienteAdmin = menuClienteAdmin;
    this.menuProductos = menuProductos;
  }

  public void menuSwitchAdmin() {
    Common common = new Common();
    int optionMenuAdmin;

    do {
      System.out.println(Constantes.MENU_ADMIN);
      optionMenuAdmin = common.giveInt();

      switch (optionMenuAdmin) {
        case 1:
          menuProductos.getOption();
          break;
        case 2:
          menuClienteAdmin.menuClientesAdministrador();
          break;
        case 0:
          System.out.println(Constantes.HASTA_LA_NEXT);
          break;
        default:
          System.out.println(Constantes.ERROR_POR_FAVOR_TRY_AGAIN);
          break;
      }
    } while (optionMenuAdmin != 0);
  }
}
