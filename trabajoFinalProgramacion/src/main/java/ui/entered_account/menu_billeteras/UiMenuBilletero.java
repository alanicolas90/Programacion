package ui.entered_account.menu_billeteras;

import common.Common;
import constantes.Constantes;
import domain.modelo.gasto.Gasto;
import domain.modelo.gasto.GastoNormal;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.ServicioBilletera;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class UiMenuBilletero {

    private final ServicioBilletera servicioBilleteraImpl;
    private final ServicioUsuario servicioUsuarioImpl;

    @Inject
    public UiMenuBilletero(ServicioBilletera servicioBilleteraImpl, ServicioUsuario servicioUsuarioImpl) {
        this.servicioBilleteraImpl = servicioBilleteraImpl;
        this.servicioUsuarioImpl = servicioUsuarioImpl;
    }

    public void menuBilletero(Scanner sc, Usuario user) {
        Common common = new Common();
        String nombreBilletera;

        if (servicioUsuarioImpl.tieneBilletera(user.getNombre())) {
            System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_BILLETERA);
            nombreBilletera = sc.nextLine();
            if (servicioBilleteraImpl.billeteraExiste(nombreBilletera)) {
                int option;
                do {
                    System.out.println(Constantes.AJUSTES_DE_LA_BILLETERA);
                    System.out.println(Constantes.VER_DATOS_DE_LA_BILLETERA_2_VER_SOLICITUDES_PARA_ENTRAR_A_LA_BILLETERA_3_GESTIONAR_SOLICITUDES_4_ANADIR_DINERO_AL_BILLETERO_FAMILIAR_5_VER_GASTOS_DEL_BILLETERO_6_METER_GASTOS_AL_BILLETERO_7_VER_LISTA_DE_GASTOS_ORDENADA_8_VER_BALANCE_BILLETERO_9_SALIR);
                    option = common.giveInt();
                    switch (option) {
                        case 1:
                            verDatosBilletera(nombreBilletera);
                            break;
                        case 2:
                            verSolicitudesBilletera(nombreBilletera);
                            break;
                        case 3:
                            gestionarSolicitudes(sc, nombreBilletera);
                            break;
                        case 4:
                            addDineroABilletera(user, common, nombreBilletera);
                            break;
                        case 5:
                            verGastosBilletero(nombreBilletera);
                            break;
                        case 6:
                            meterGastoAlBilletero(sc, common, nombreBilletera);
                            break;
                        case 7:
                            verGastosOrdenados(nombreBilletera);
                            break;
                        case 8:
                            verBalanceBilletera(nombreBilletera);
                            break;
                        case 9:
                            System.out.println(Constantes.SALIENDO);
                            break;
                        default:
                            System.out.println(Constantes.OPCION_NO_VALIDA);
                            break;
                    }
                } while (option != 9);
            } else {
                System.out.println(Constantes.NO_EXISTE_BILLETERA_CON_TAL_NOMBRE_INTENTELO_DE_NUEVO);
            }
        } else {
            System.out.println(Constantes.NO_TIENE_BILLETERAS);
        }
    }

    private void addDineroABilletera(Usuario user, Common common, String nombreBilletera) {
        System.out.println(Constantes.ANADIR_DINERO_AL_BILLETERO);
        System.out.println(Constantes.INGRESE_EL_MONTO_A_ANADIR);
        double monto = common.giveDouble();
        if(servicioUsuarioImpl.tieneSuficienteDinero(user.getNombre(), monto)){
            if(servicioBilleteraImpl.addDineroBilletera(nombreBilletera, monto, user)){
                System.out.println(Constantes.SE_ANADIO_EL_MONTO_A_LA_BILLETERA);
            }else{
                System.out.println(Constantes.NO_SE_PUDO_ANADIR_EL_MONTO_A_LA_BILLETERA);
            }
        }
    }

    private void meterGastoAlBilletero(Scanner sc, Common common, String nombreBilletera) {
        System.out.println(Constantes.METER_GASTOS_AL_BILLETERO);
        System.out.println(Constantes.DIME_EL_NOMBRE_DEL_GASTO);
        String nombreGasto = sc.nextLine();
        System.out.println(Constantes.DIME_EL_MONTO_DEL_GASTO);
        double montoGasto = common.giveDouble();
        System.out.println(Constantes.ALGUNA_DESCRIPCION_DEL_GASTO);
        String descripcionGasto = sc.nextLine();
        Gasto gasto = new GastoNormal(nombreGasto, montoGasto, descripcionGasto);
        if(servicioBilleteraImpl.meterGastoBilletera(nombreBilletera, gasto)){
            System.out.println(Constantes.GASTO_ANADIDO);
        }else{
            System.out.println(Constantes.NO_SE_PUDO_ANADIR_EL_GASTO);
        }
    }

    private void gestionarSolicitudes(Scanner sc, String nombreBilletera) {
        Common common = new Common();
        System.out.println(Constantes.GESTIONAR_SOLICITUDES);
        if(servicioBilleteraImpl.haySolicitudes(nombreBilletera)){
            System.out.println(Constantes.ELIJA_UNA_OPCION);
            System.out.println(Constantes.ACEPTAR_SOLICITUD_2_RECHAZAR_SOLICITUD_3_SALIR);
            int option = common.giveInt();
            switch (option){
                case 1:
                    System.out.println(servicioBilleteraImpl.verSolicitudesBilletera(nombreBilletera));
                    System.out.println(Constantes.INGRESE_EL_USUARIO_QUE_DESEA_ACEPTAR);
                    String usuario = sc.nextLine();
                    if(servicioBilleteraImpl.aceptarSolicitud(nombreBilletera, usuario)){
                        System.out.println(Constantes.SOLICITUD_ACEPTADA);
                    }else{
                        System.out.println(Constantes.NO_SE_PUDO_ACEPTAR_LA_SOLICITUD);
                    }
                    break;
                case 2:
                    System.out.println(servicioBilleteraImpl.verSolicitudesBilletera(nombreBilletera));
                    System.out.println(Constantes.INGRESE_EL_USUARIO_QUE_DESEA_RECHAZAR);
                    usuario = sc.nextLine();
                    if(servicioBilleteraImpl.rechazarSolicitud(nombreBilletera, usuario)){
                        System.out.println(Constantes.SOLICITUD_RECHAZADA);
                    }  else{
                        System.out.println(Constantes.NO_SE_PUDO_RECHAZAR_LA_SOLICITUD);
                    }
                    break;
                case 3:
                    System.out.println(Constantes.SALIENDO);
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
                    break;
            }
        }else{
            System.out.println(Constantes.NO_HAY_SOLICITUDES);
        }
    }


    private void verBalanceBilletera(String nombreBilletera) {
        System.out.println(servicioBilleteraImpl.verBalanceBilletera(nombreBilletera));
    }

    private void verGastosOrdenados(String nombreBilletera) {
        if(servicioBilleteraImpl.billeteraTieneGastos(nombreBilletera)){
            System.out.println(servicioBilleteraImpl.verGastosOrdenadosBilletera(nombreBilletera));
        }else{
            System.out.println(Constantes.NO_HAY_GASTOS_EN_LA_BILLETERA);
        }
    }

    private void verGastosBilletero(String nombreBilletera) {
        if(servicioBilleteraImpl.billeteraTieneGastos(nombreBilletera)){
            System.out.println(servicioBilleteraImpl.verGastosBilletera(nombreBilletera));
        }else{
            System.out.println(Constantes.NO_HAY_GASTOS_EN_LA_BILLETERA);
        }
    }

    private void verSolicitudesBilletera(String nombreBilletera) {
        if(servicioBilleteraImpl.haySolicitudes(nombreBilletera)){
            System.out.println(servicioBilleteraImpl.verSolicitudesBilletera(nombreBilletera));
        }else{
            System.out.println(Constantes.NO_HAY_SOLICITUDES);
        }
    }

    private void verDatosBilletera(String nombreBilletera) {
        System.out.print(servicioBilleteraImpl.verDatosBilletera(nombreBilletera));
    }

}
