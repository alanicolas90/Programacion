package ui;

import common.Common;
import constantes.Constantes;

import java.util.Scanner;

public class UiMenuAdmin {

    public void menuAdminSwitch(Scanner sc) {
        Common common = new Common();
        int optionMenuAdmin;

        do {
            System.out.println(Constantes.MENU_ADMIN);
            optionMenuAdmin = common.giveInt();

            switch (optionMenuAdmin) {
                case 1:
                    UIMenuProduct menuProductos = new UIMenuProduct();
                    menuProductos.getOption(sc);
                    break;
                case 2:
                    UiMenuClienteAdmin menuClienteAdmin = new UiMenuClienteAdmin();
                    menuClienteAdmin.menuClientesAdministrador(sc);

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
