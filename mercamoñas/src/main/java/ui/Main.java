package ui;

import common.Common;
import constantes.Constantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Common common = new Common();

        UiMenuAdmin menuSwitchAdmin = new UiMenuAdmin();

        System.out.println(Constantes.BIENVENIDA);
        int optionUser;

        // int optionMenuClienteNormal; es para el futuro

        do {
            System.out.println(Constantes.MENU_ELEGIR_USUARIO);
            optionUser = common.giveInt();

            switch (optionUser) {
                case 1:
                    menuSwitchAdmin.menuAdminSwitch(sc);
                    break;
                case 2:
                    System.out.println(Constantes.UNAVAILABLE);
                    break;

                default:
                    System.out.println(Constantes.ERROR_POR_FAVOR_TRY_AGAIN);
                    break;
            }
        } while (optionUser != 0);
    }

}
