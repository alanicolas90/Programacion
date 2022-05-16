package ui;

import common.Common;
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

        ServicioUsuario servicioUsuario = container.select(ServicioUsuario.class).get();
        UiLogin uiLogin = container.select(UiLogin.class).get();

        System.out.println("Bienvenido a la aplicacion");
        int option;
        do {
            System.out.println("Que desea hacer?\n" + "1. Ingresar a una cuenta existente\n" + "2. Crear una nueva cuenta\n" + "3. Salir");
            option = common.giveInt();
            switch (option) {
                case 1:
                    uiLogin.login(sc);
                    break;
                case 2:
                    registrarUsuario(common, sc, servicioUsuario);
                    break;
                case 3:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option != 3);
        container.close();
    }


    private static void registrarUsuario(Common common, Scanner sc, ServicioUsuario servicioUsuario) {
        String user;
        String password;
        String email;
        System.out.println("Por favor rellene el siguiente formulario");
        do {
            System.out.print("Ususario: ");
            user = sc.nextLine();
            if (servicioUsuario.existeUsuario(user)) {
                System.out.println("El usuario ya existe");
            }
        } while (servicioUsuario.existeUsuario(user));

        do {
            System.out.print("Contraseña: ");
            password = sc.nextLine();
            if (password.length() == 0) {
                System.out.println("La contraseña no puede estar vacia");
            }
        } while (password.length() == 0);

        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Apellido: ");
        String lastName = sc.nextLine();
        do {
            System.out.print("Correo: ");
            email = sc.nextLine();
            if (!email.contains("@gmail.com")) {
                System.out.println("Por favor ponga un correo valido");
            }
        } while (!email.contains("@gmail.com"));

        System.out.print("Sueldo: ");
        double money = common.giveDouble();

        Usuario usuario = new Usuario(user, password, name, lastName, email, money);

        if (servicioUsuario.registarUsuario(usuario)) {
            System.out.println("Usuario registrado con exito");
        } else {
            System.out.println("Usuario ya existe");
        }
    }
}
