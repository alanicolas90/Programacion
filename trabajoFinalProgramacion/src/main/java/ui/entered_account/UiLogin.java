package ui.entered_account;

import common.Common;
import constantes.Constantes;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.solicitud.Solicitud;
import jakarta.inject.Inject;
import servicios.ServicioBilletera;
import servicios.ServicioUsuario;
import ui.entered_account.ajustes_usuario.UiAjustesUsuario;
import ui.entered_account.menu_billeteras.UiMenuBilletero;

import java.util.Scanner;

public class UiLogin {
    private final ServicioUsuario servicioUsuarioImpl;
    private final UiAjustesUsuario uiAjustesUsuario;
    private final ServicioBilletera servicioBilleteraImpl;
    private final UiMenuBilletero uiMenuBilletero;

    @Inject
    public UiLogin(ServicioUsuario servicioUsuarioImpl, ServicioBilletera servicioBilleteraImpl, UiAjustesUsuario uiAjustesUsuario, UiMenuBilletero uiMenuBilletero) {
        this.servicioUsuarioImpl = servicioUsuarioImpl;
        this.servicioBilleteraImpl = servicioBilleteraImpl;
        this.uiAjustesUsuario = uiAjustesUsuario;
        this.uiMenuBilletero = uiMenuBilletero;
    }

    public void login(Scanner sc) {
        Common common = new Common();

        int option;
        String user;
        String password;

        System.out.println(Constantes.INGRESE_LOS_DATOS);
        do {
            do {
                System.out.print(Constantes.USUARIO);
                user = sc.nextLine();
                servicioUsuarioImpl.existeUsuario(user);
            } while (!servicioUsuarioImpl.existeUsuario(user));
            System.out.print(Constantes.CONTRASENA);
            password = sc.nextLine();
            if (!servicioUsuarioImpl.existeUsuario(user)) {
                System.out.println(Constantes.CONTRASENA_INCORRECTA);
            }
        } while (!servicioUsuarioImpl.logIn(user, password));
        if (servicioUsuarioImpl.logIn(user, password)) {
            System.out.println(Constantes.BIENVENIDO + user);
            do {
                System.out.println(Constantes.VER_PERFIL_2_CREAR_BILLETERA_FAMILIAR_3_ELIMINAR_BILLETERA_FAMILIAR_4_ENTRAR_EN_UNA_BILLETERA_5_SOLICITAR_ENTRAR_EN_UNA_BILLETERA_6_AJUSTES_DE_USUARIO_7_SALIR);
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
                        uiMenuBilletero.menuBilletero(sc, servicioUsuarioImpl.getUsuario(user));
                        break;
                    case 5:
                        solicitarEntrarBilletera(sc, user);
                        break;
                    case 6:
                        uiAjustesUsuario.ajustesUsuario(sc, servicioUsuarioImpl.getUsuario(user));
                        break;
                    case 7:
                        System.out.println(Constantes.SALIENDO);
                        break;
                    default:
                        System.out.println(Constantes.OPCION_NO_VALIDA);
                        break;
                }
            } while (option != 7);
        }
    }

    private void solicitarEntrarBilletera(Scanner sc, String user) {
        String nombreBilletera;
        System.out.println(Constantes.INGRESE_EL_ID_DE_LA_BILLETERA_A_LA_QUE_DESEA_ENTRAR);
        nombreBilletera = sc.nextLine();
        if (servicioBilleteraImpl.billeteraExiste(nombreBilletera)){
            if(!servicioBilleteraImpl.usuarioPerteneceBilletera(user,nombreBilletera)){
                if(!servicioBilleteraImpl.esLider(user,nombreBilletera)){
                    System.out.println(Constantes.INGRESE_EL_MENSAJE_DE_INVITACION_PARA_QUE_LE_ACPETEN_RECOMENDAMOS_IDENTIFICARSE);
                    String mensaje = sc.nextLine();
                    Solicitud solicitud = new Solicitud(user, mensaje);
                    if (servicioBilleteraImpl.solicitarEntrarBilletera(nombreBilletera, solicitud)) {
                        System.out.println(Constantes.SOLICITUD_ENVIADA);
                    }
                }else{
                    System.out.println(Constantes.NO_PUEDE_SOLICITAR_ENTRAR_A_UNA_BILLETERA_QUE_ES_LIDER);
                }
            }else{
                System.out.println(Constantes.YA_PERTENECES_A_ESTA_BILLETERA);
            }
        }else {
            System.out.println(Constantes.BILLETERA_NO_EXISTE_CON_ESE_NOMBRE_INTENTELO_DE_NUEVO);
        }
    }


    private void eliminarBilletera(Scanner sc, String user) {
        if(!servicioBilleteraImpl.getBilleteras(servicioUsuarioImpl.getUsuario(user)).isEmpty()) {

            System.out.println(servicioBilleteraImpl.getBilleteras(servicioUsuarioImpl.getUsuario(user)));
            System.out.println(Constantes.DE_LA_LISTA_MOSTRADA_ANTERIORMENTE_QUE_BILLETERA_DESEA_ELIMINAR);
            String nombreBilletera = sc.nextLine();

            if(servicioBilleteraImpl.billeteraExisteUsuarioSpecific(nombreBilletera, servicioUsuarioImpl.getUsuario(user))){
                if(servicioBilleteraImpl.eliminarBilletera(servicioUsuarioImpl.getUsuario(user), servicioBilleteraImpl.getBilletera(nombreBilletera))){
                    System.out.println(Constantes.BILLETERA_ELIMINADA);
                }else{
                    System.out.println(Constantes.NO_SE_PUDO_ELIMINAR_LA_BILLETERA);
                }
            }
        }else{
            System.out.println(Constantes.NO_TIENE_BILLETERAS);
        }
    }


    private void crearBilletera(Scanner sc, String user) {
        System.out.println(Constantes.NOMBRE_DE_LA_BILLETERA);
        String nombreBilletera = sc.nextLine();

        BilleteraFamiliar billeteraFamiliar = new BilleteraFamiliar(nombreBilletera, servicioUsuarioImpl.getNombreUsuario(user));

        servicioBilleteraImpl.crearBilletera(servicioUsuarioImpl.getUsuario(user), billeteraFamiliar);
    }

    private void verPerfil(String user) {
        System.out.println(Constantes.TUS_DATOS);
        System.out.println(servicioUsuarioImpl.getUsuario(user));
    }
}
