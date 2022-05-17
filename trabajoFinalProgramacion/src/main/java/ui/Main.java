package ui;

import common.Common;
import constantes.Constantes;
import domain.modelo.usuario.Usuario;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import servicios.ServicioUsuario;
import ui.entered_account.UiLogin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();

        Common common = new Common();
        Scanner sc = new Scanner(System.in);

        ServicioUsuario servicioUsuarioImpl = container.select(ServicioUsuario.class).get();
        UiLogin uiLogin = container.select(UiLogin.class).get();

        System.out.println(Constantes.BIENVENIDO_A_LA_APLICACION);
        int option;
        do {
            System.out.println(Constantes.QUE_DESEA_HACER_1_INGRESAR_A_UNA_CUENTA_EXISTENTE_2_CREAR_UNA_NUEVA_CUENTA_3_SALIR);
            option = common.giveInt();
            switch (option) {
                case 1:
                    uiLogin.login(sc);
                    break;
                case 2:
                    registrarUsuario(common, sc, servicioUsuarioImpl);
                    break;
                case 3:
                    System.out.println(Constantes.BYE_BYE);
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
                    break;
            }
        } while (option != 3);
        container.close();
    }


    private static void registrarUsuario(Common common, Scanner sc, ServicioUsuario servicioUsuarioImpl) {
        String user;
        String password;
        String email;
        System.out.println(Constantes.POR_FAVOR_RELLENE_EL_SIGUIENTE_FORMULARIO);
        do {
            System.out.print(Constantes.USUSARIO);
            user = sc.nextLine();
            if (servicioUsuarioImpl.existeUsuario(user)) {
                System.out.println(Constantes.EL_USUARIO_YA_EXISTE);
            }
        } while (servicioUsuarioImpl.existeUsuario(user));

        do {
            System.out.print(Constantes.CONTRASENA);
            password = sc.nextLine();
            if (password.length() == 0) {
                System.out.println(Constantes.LA_CONTRASENA_NO_PUEDE_ESTAR_VACIA);
            }
        } while (password.length() == 0);

        System.out.print(Constantes.NOMBRE);
        String name = sc.nextLine();
        System.out.print(Constantes.APELLIDO);
        String lastName = sc.nextLine();
        do {
            System.out.print(Constantes.CORREO);
            email = sc.nextLine();
            if (!email.contains(Constantes.GMAIL_COM)) {
                System.out.println(Constantes.POR_FAVOR_PONGA_UN_CORREO_VALIDO);
            }
        } while (!email.contains(Constantes.GMAIL_COM));

        System.out.print(Constantes.SUELDO);
        double money = common.giveDouble();

        Usuario usuario = new Usuario(user, password, name, lastName, email, money);

        if (servicioUsuarioImpl.registarUsuario(usuario)) {
            System.out.println(Constantes.USUARIO_REGISTRADO_CON_EXITO);
        } else {
            System.out.println(Constantes.USUARIO_YA_EXISTE);
        }
    }
}
