package ui.entered_account.menu_billeteras;

import common.Common;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.ServicioBilletera;
import servicios.ServicioUsuario;

import java.util.Scanner;

public class UiMenuBilletero {

    private final ServicioBilletera servicioBilletera;
    private final ServicioUsuario servicioUsuario;

    @Inject
    public UiMenuBilletero(ServicioBilletera servicioBilletera, ServicioUsuario servicioUsuario) {
        this.servicioBilletera = servicioBilletera;
        this.servicioUsuario = servicioUsuario;
    }

    public void menuBilletero(Scanner sc, Usuario user) {
        Common common = new Common();
        String nombreBilletera;

        if (servicioUsuario.tieneBilletera(user.getNombre())) {
            System.out.println("Ingrese el nombre de la billetera");
            nombreBilletera = sc.nextLine();
            if (servicioBilletera.billeteraExiste(nombreBilletera)) {
                int option;
                do {
                    System.out.println("Ajustes de la billetera:");
                    System.out.println("1. Ver datos de la billetera\n" +
                            "2. Ver solicitudes para entrar a la billetera\n" +
                            "3. Gestionar solicitudes\n" +
                            "4. Añadir dinero al billetero familiar\n" +
                            "5. Ver gastos del billetero\n" +
                            "6. Meter gastos al billetero\n" +
                            "7. Ver lista de gastos ordenada\n" +
                            "8. Ver balance billetero\n" +
                            "9. Salir");
                    option = common.giveInt();
                    switch (option) {
                        case 1:
                            verDatosBilletera(nombreBilletera);
                            break;
                        case 2:
                            verSolicitudesBilletera(nombreBilletera);
                            break;
                        case 3:
                            System.out.println("Gestionar solicitudes");
//                        System.out.println("Gestionar solicitudes");
//                        System.out.println("1. Aceptar solicitud\n" +
//                                "2. Rechazar solicitud\n" +
//                                "3. Salir");
//                        int option2 = common.giveInt();
                            break;
                        case 4:
//                        System.out.println("Añadir dinero al billetero");
//                        System.out.println("Ingrese el monto a añadir");
//                        double monto = common.giveDouble();
//                        servicioBilletera.añadirDineroBilletera(nombreBilletera, monto);
                            break;
                        case 5:
                            verGastosBilletero(nombreBilletera);
                            break;
                        case 6:
                            System.out.println("Meter gastos al billetero");
                            break;
                        case 7:
                            verGastosOrdenados(nombreBilletera);
                            break;
                        case 8:
                            verBalanceBilletera(nombreBilletera);
                            break;
                        case 9:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                } while (option != 9);
            } else {
                System.out.println("no existe billetera con tal nombre, intentelo de nuevo");
            }
        } else {
            System.out.println("no tiene billeteras");
        }
    }




    private void verBalanceBilletera(String nombreBilletera) {
        System.out.println(servicioBilletera.verBalanceBilletera(nombreBilletera));
    }

    private void verGastosOrdenados(String nombreBilletera) {
        if(servicioBilletera.billeteraTieneGastos(nombreBilletera)){
            System.out.println(servicioBilletera.verGastosOrdenadosBilletera(nombreBilletera));
        }else{
            System.out.println("No hay gastos en la billetera");
        }
    }

    private void verGastosBilletero(String nombreBilletera) {
        if(servicioBilletera.billeteraTieneGastos(nombreBilletera)){
            System.out.println(servicioBilletera.verGastosBilletera(nombreBilletera));
        }else{
            System.out.println("No hay gastos en la billetera");
        }
    }

    private void verSolicitudesBilletera(String nombreBilletera) {
        if(servicioBilletera.haySolicitudes(nombreBilletera)){
            System.out.println(servicioBilletera.verSolicitudesBilletera(nombreBilletera));
        }else{
            System.out.println("No hay solicitudes");
        }
    }

    private void verDatosBilletera(String nombreBilletera) {
        System.out.print(servicioBilletera.verDatosBilletera(nombreBilletera));
    }

}
