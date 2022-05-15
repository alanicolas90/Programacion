package ui.entered_account.menu_billeteras;

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

    public void menuBilletero(Scanner sc, Usuario user){
        String nombreBilletera;

        if (servicioUsuario.tieneBilletera(user.getNombre())) {
            System.out.println("Ingrese el nombre de la billetera");
            nombreBilletera = sc.nextLine();
            if (servicioBilletera.billeteraExiste(nombreBilletera)) {
                System.out.println("Ajustes de la billetera");
                System.out.println("1. Ver datos de la billetera\n2. Ver solicitudes para entrar a la billetera\n3. . Salir");
            } else {
                System.out.println("no existe billetera con tal nombre, intentelo de nuevo");
            }
        } else {
            System.out.println("no tiene billeteras");
        }
    }

}
