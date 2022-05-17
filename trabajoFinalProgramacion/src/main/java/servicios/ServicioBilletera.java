package servicios;

import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.gasto.Gasto;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;

import java.util.List;

public interface ServicioBilletera {
    void crearBilletera(Usuario user, BilleteraFamiliar billeteraFamiliar);

    boolean billeteraExiste(String nombreBilletera);

    List<BilleteraFamiliar> getBilleteras(Usuario usuario);

    boolean billeteraExisteUsuarioSpecific(String nombreBilletera, Usuario user);

    boolean eliminarBilletera(Usuario usuario, BilleteraFamiliar billeteraFamiliar);

    BilleteraFamiliar getBilletera(String nombreBilletera);

    boolean solicitarEntrarBilletera(String nombreBilletera, Solicitud solicitud);

    boolean usuarioPerteneceBilletera(String user, String nombreBilletera);

    boolean esLider(String user, String nombreBilletera);

    BilleteraFamiliar verDatosBilletera(String nombreBilletera);

    List<Solicitud> verSolicitudesBilletera(String nombreBilletera);

    List<Gasto> verGastosBilletera(String nombreBilletera);

    List<Gasto> verGastosOrdenadosBilletera(String nombreBilletera);

    Double verBalanceBilletera(String nombreBilletera);

    boolean haySolicitudes(String nombreBilletera);

    boolean billeteraTieneGastos(String nombreBilletera);

    boolean aceptarSolicitud(String nombreBilletera, String usuario);

    boolean rechazarSolicitud(String nombreBilletera, String usuario);

    boolean meterGastoBilletera(String nombreBilletera, Gasto gasto);

    boolean addDineroBilletera(String nombreBilletera, double monto, Usuario user);
}
