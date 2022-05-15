package ui.entered_account.ajustes_usuario;

import common.Common;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class UiAjustesUsuario {
    private final ServicioUsuario servicioUsuario;

    @Inject
    public UiAjustesUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    public void ajustesUsuario(Scanner sc, Usuario user) {
        Common common = new Common();
        int option;
        do {
            System.out.println("Ajustes de usuario");
            System.out.println("1. Cambiar contraseña\n" +
                    "2. Cambiar nombre\n" +
                    "3. Cambiar apellido\n" +
                    "4. Cambiar correo\n" +
                    "5. Cambiar sueldo que gano\n" +
                    "7. Salir");
            option = common.giveInt();
            switch (option) {
                case 1:
                    changePassword(sc, user);
                    break;
                case 2:
                    changeName(sc, user);
                    break;
                case 3:
                    changeSurname(sc, user);
                    break;
                case 4:
                    changeEmail(sc, user);
                    break;
                case 5:
                    changeSueldo(user, common);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option != 6);
    }

    private void changeSueldo(Usuario user, Common common) {
        System.out.println("Ingrese el nuevo sueldo");
        double newSalary = common.giveDouble();
        if(servicioUsuario.changeSalary(user,newSalary)){
            System.out.println("Sueldo cambiado con éxito");
        }else{
            System.out.println("No se pudo cambiar el sueldo, inténtelo de nuevo");
        }
    }

    private void changeEmail(Scanner sc, Usuario user) {
        System.out.println("Ingrese el nuevo correo");
        String newEmail = sc.nextLine();
        if(newEmail.length() == 0){
            System.out.println("No se puede dejar el correo vacio, inténtelo de nuevo");
        }else if(!newEmail.contains("@gmail.com")){
            System.out.println("El correo debe ser de gmail, inténtelo de nuevo");
        }else{
            if(servicioUsuario.changeEmail(user,newEmail)){
                System.out.println("Correo cambiado con éxito");
            }else{
                System.out.println("No se pudo cambiar el correo, inténtelo de nuevo");
            }
        }
    }

    private void changeSurname(Scanner sc, Usuario user) {
        System.out.println("Ingrese el nuevo apellido");
        String newLastName = sc.nextLine();
        if (newLastName.length() == 0) {
            System.out.println("No se puede dejar el apellido vacio, inténtelo de nuevo");
        }else{
            if(servicioUsuario.changeLastName(user,newLastName)){
                System.out.println("Apellido cambiado con éxito");
            }else{
                System.out.println("No se pudo cambiar el apellido, inténtelo de nuevo");
            }
        }
    }

    private void changeName(Scanner sc, Usuario user) {
        System.out.println("Ingrese el nuevo nombre");
        String newName = sc.nextLine();
        if (newName.length() == 0) {
            System.out.println("No se puede dejar el nombre vacio, inténtelo de nuevo");
        }else{
            if(servicioUsuario.changeName(user,newName)){
                System.out.println("Nombre cambiado con éxito");
            }else{
                System.out.println("No se pudo cambiar el nombre, inténtelo de nuevo");
            }
        }
    }

    private void changePassword(Scanner sc, Usuario user) {
        System.out.println("Ingrese la nueva contraseña");
        String newPassword = sc.nextLine();
        if (newPassword.length() == 0) {
            System.out.println("No se puede dejar la contraseña vacia, inténtelo de nuevo");
        } else {
            if(servicioUsuario.changePassword(user,newPassword)){
                System.out.println("Contraseña cambiada con éxito");
            }else{
                System.out.println("No se pudo cambiar la contraseña, inténtelo de nuevo");
            }
        }
    }
}
