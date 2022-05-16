package ui.entered_account;

import common.Common;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.solicitud.Solicitud;
import jakarta.inject.Inject;
import servicios.ServicioBilletera;
import servicios.ServicioUsuario;
import ui.entered_account.ajustes_usuario.UiAjustesUsuario;
import ui.entered_account.menu_billeteras.UiMenuBilletero;

import java.util.Scanner;

public class UiLogin {
    private final ServicioUsuario servicioUsuario;
    private final UiAjustesUsuario uiAjustesUsuario;
    private final ServicioBilletera servicioBilletera;
    private final UiMenuBilletero uiMenuBilletero;

    @Inject
    public UiLogin(ServicioUsuario servicioUsuario, ServicioBilletera servicioBilletera, UiAjustesUsuario uiAjustesUsuario, UiMenuBilletero uiMenuBilletero) {
        this.servicioUsuario = servicioUsuario;
        this.servicioBilletera = servicioBilletera;
        this.uiAjustesUsuario = uiAjustesUsuario;
        this.uiMenuBilletero = uiMenuBilletero;
    }

    public void login(Scanner sc) {
        Common common = new Common();

        int option;
        String user;
        String password;

        System.out.println("Ingrese los datos:");
        do {
            do {
                System.out.print("Usuario: ");
                user = sc.nextLine();
                servicioUsuario.existeUsuario(user);
            } while (!servicioUsuario.existeUsuario(user));
            System.out.print("Contraseña: ");
            password = sc.nextLine();
            if (!servicioUsuario.existeUsuario(user)) {
                System.out.println("contraseña incorrecta");
            }
        } while (!servicioUsuario.logIn(user, password));
        if (servicioUsuario.logIn(user, password)) {
            System.out.println("Bienvenido " + user);
            do {
                System.out.println("1. Ver perfil\n" +
                        "2. Crear Billetera familiar\n" +
                        "3. Eliminar Billetera familiar\n"+
                        "4. Entrar en una billetera\n" +
                        "5. Solicitar entrar en una billetera\n"+
                        "6. Ajustes de usuario\n" +
                        "7. Salir");
                option = common.giveInt();
                switch (option) {
                    case 1:
                        verPerfil(user);
                        break;
                    case 2:
                        crearBilletera(sc, user);
                        break;
                    case 3:
                        eliminarBilletera(sc, user);
                        break;
                    case 4:
                        uiMenuBilletero.menuBilletero(sc, servicioUsuario.getUsuario(user));
                        break;
                    case 5:
                        solicitarEntrarBilletera(sc, user);
                        break;
                    case 6:
                        uiAjustesUsuario.ajustesUsuario(sc, servicioUsuario.getUsuario(user));
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } while (option != 7);
        }
    }

    private void solicitarEntrarBilletera(Scanner sc, String user) {
        String nombreBilletera;
        System.out.println("Ingrese el id de la billetera a la que desea entrar");
        nombreBilletera = sc.nextLine();
        if (servicioBilletera.billeteraExiste(nombreBilletera)){
            if(!servicioBilletera.usuarioPerteneceBilletera(user,nombreBilletera)){
                if(!servicioBilletera.esLider(user,nombreBilletera)){
                    System.out.println("Ingrese el mensaje de invitacion para que le acpeten (recomendamos identificarse)");
                    String mensaje = sc.nextLine();
                    Solicitud solicitud = new Solicitud(user, mensaje);
                    if (servicioBilletera.solicitarEntrarBilletera(nombreBilletera, solicitud)) {
                        System.out.println("Solicitud enviada");
                    }
                }else{
                    System.out.println("No puede solicitar entrar a una billetera que es lider");
                }
            }else{
                System.out.println("Ya perteneces a esta billetera");
            }
        }else {
            System.out.println("Billetera no existe con ese nombre, intentelo de nuevo");
        }
    }


    private void eliminarBilletera(Scanner sc, String user) {
        if(!servicioBilletera.getBilleteras(servicioUsuario.getUsuario(user)).isEmpty()) {

            System.out.println(servicioBilletera.getBilleteras(servicioUsuario.getUsuario(user)));
            System.out.println("De la lista mostrada anteriormente, que billetera desea eliminar?");
            String nombreBilletera = sc.nextLine();

            if(servicioBilletera.billeteraExisteUsuarioSpecific(nombreBilletera,servicioUsuario.getUsuario(user))){
                if(servicioBilletera.eliminarBilletera(servicioUsuario.getUsuario(user),servicioBilletera.getBilletera(nombreBilletera))){
                    System.out.println("Billetera eliminada");
                }else{
                    System.out.println("No se pudo eliminar la billetera");
                }
            }
        }else{
            System.out.println("No tiene billeteras ");
        }
    }


    private void crearBilletera(Scanner sc, String user) {
        System.out.println("crear billetera");
        System.out.println("Nombre de la billetera: ");
        String nombreBilletera = sc.nextLine();

        BilleteraFamiliar billeteraFamiliar = new BilleteraFamiliar(nombreBilletera, servicioUsuario.getNombreUsuario(user));

        servicioBilletera.crearBilletera(servicioUsuario.getUsuario(user), billeteraFamiliar);
    }

    private void verPerfil(String user) {
        System.out.println("Tus datos: ");
        System.out.println(servicioUsuario.getUsuario(user));
    }
}
