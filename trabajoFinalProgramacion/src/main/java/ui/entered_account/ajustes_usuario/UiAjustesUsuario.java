package ui.entered_account.ajustes_usuario;

import common.Common;
import constantes.Constantes;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class UiAjustesUsuario {
    private final ServicioUsuario servicioUsuarioImpl;

    @Inject
    public UiAjustesUsuario(ServicioUsuario servicioUsuarioImpl) {
        this.servicioUsuarioImpl = servicioUsuarioImpl;
    }

    public void ajustesUsuario(Scanner sc, Usuario user) {
        Common common = new Common();
        int option;
        do {
            System.out.println(Constantes.AJUSTES_DE_USUARIO);
            System.out.println(Constantes.CAMBIAR_CONTRASENA_2_CAMBIAR_NOMBRE_3_CAMBIAR_APELLIDO_4_CAMBIAR_CORREO_5_CAMBIAR_SUELDO_QUE_GANO_6_SALIR);
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
                    System.out.println(Constantes.SALIENDO);
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
                    break;
            }
        } while (option != 6);
    }

    private void changeSueldo(Usuario user, Common common) {
        System.out.println(Constantes.INGRESE_EL_NUEVO_SUELDO);
        double newSalary = common.giveDouble();
        if(servicioUsuarioImpl.changeSalary(user,newSalary)){
            System.out.println(Constantes.SUELDO_CAMBIADO_CON_EXITO);
        }else{
            System.out.println(Constantes.NO_SE_PUDO_CAMBIAR_EL_SUELDO_INTENTELO_DE_NUEVO);
        }
    }

    private void changeEmail(Scanner sc, Usuario user) {
        System.out.println(Constantes.INGRESE_EL_NUEVO_CORREO);
        String newEmail = sc.nextLine();
        if(newEmail.length() == 0){
            System.out.println(Constantes.NO_SE_PUEDE_DEJAR_EL_CORREO_VACIO_INTENTELO_DE_NUEVO);
        }else if(!newEmail.contains(Constantes.GMAIL_COM)){
            System.out.println(Constantes.EL_CORREO_DEBE_SER_DE_GMAIL_INTENTELO_DE_NUEVO);
        }else{
            if(servicioUsuarioImpl.changeEmail(user,newEmail)){
                System.out.println(Constantes.CORREO_CAMBIADO_CON_EXITO);
            }else{
                System.out.println(Constantes.NO_SE_PUDO_CAMBIAR_EL_CORREO_INTENTELO_DE_NUEVO);
            }
        }
    }

    private void changeSurname(Scanner sc, Usuario user) {
        System.out.println(Constantes.INGRESE_EL_NUEVO_APELLIDO);
        String newLastName = sc.nextLine();
        if (newLastName.length() == 0) {
            System.out.println(Constantes.NO_SE_PUEDE_DEJAR_EL_APELLIDO_VACIO_INTENTELO_DE_NUEVO);
        }else{
            if(servicioUsuarioImpl.changeLastName(user,newLastName)){
                System.out.println(Constantes.APELLIDO_CAMBIADO_CON_EXITO);
            }else{
                System.out.println(Constantes.NO_SE_PUDO_CAMBIAR_EL_APELLIDO_INTENTELO_DE_NUEVO);
            }
        }
    }

    private void changeName(Scanner sc, Usuario user) {
        System.out.println(Constantes.INGRESE_EL_NUEVO_NOMBRE);
        String newName = sc.nextLine();
        if (newName.length() == 0) {
            System.out.println(Constantes.NO_SE_PUEDE_DEJAR_EL_NOMBRE_VACIO_INTENTELO_DE_NUEVO);
        }else{
            if(servicioUsuarioImpl.changeName(user,newName)){
                System.out.println(Constantes.NOMBRE_CAMBIADO_CON_EXITO);
            }else{
                System.out.println(Constantes.NO_SE_PUDO_CAMBIAR_EL_NOMBRE_INTENTELO_DE_NUEVO);
            }
        }
    }

    private void changePassword(Scanner sc, Usuario user) {
        System.out.println(Constantes.INGRESE_LA_NUEVA_CONTRASENA);
        String newPassword = sc.nextLine();
        if (newPassword.length() == 0) {
            System.out.println(Constantes.NO_SE_PUEDE_DEJAR_LA_CONTRASENA_VACIA_INTENTELO_DE_NUEVO);
        } else {
            if(servicioUsuarioImpl.changePassword(user,newPassword)){
                System.out.println(Constantes.CONTRASENA_CAMBIADA_CON_EXITO);
            }else{
                System.out.println(Constantes.NO_SE_PUDO_CAMBIAR_LA_CONTRASENA_INTENTELO_DE_NUEVO);
            }
        }
    }
}
