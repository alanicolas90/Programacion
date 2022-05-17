package dao;

import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.gasto.Gasto;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;

import java.util.List;

public interface DaoBilletera {
    boolean crearBilletera(BilleteraFamiliar billeteraFamiliar);

    boolean billeteraExiste(String nombreBilletera);

    List<BilleteraFamiliar> getBilleteras(Usuario usuario);

    boolean billeteraExisteUsuarioSpecific(String nombreBilletera, Usuario user);

    boolean eliminarBilletera(Usuario usuario, BilleteraFamiliar billeteraFamiliar);

    boolean esLider(String usuario, String nombreBilleteraFamiliar);

    BilleteraFamiliar getBilletera(String nombreBilletera);

    boolean solicitarEntrarBilletera(String nombreBilletera, Solicitud solicitud);

    boolean usuarioPerteneceBilletera(String user, String nombreBilletera);

    List<Solicitud> verSolicitudesBilletera(String nombreBilletera);

    List<Gasto> verGastosBilletera(String nombreBilletera);

    List<Gasto> verGastosOrdenadosBilletera(String nombreBilletera);

    Double verBalanceBilletera(String nombreBilletera);

    boolean haySolicitudes(String nombreBilletera);

    boolean billeteraTieneGastos(String nombreBilletera);

    boolean aceptarSolicitud(String nombreBilletera, String user);

    boolean rechazarSolicitud(String nombreBilletera, String users);

    boolean meterGastoBilletera(String nombreBilletera, Gasto gasto);

    boolean addDineroBilletera(String nombreBilletera, double monto, Usuario user);
}
