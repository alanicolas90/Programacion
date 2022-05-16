package servicios;

import dao.DaoBilletera;
import dao.DaoUsuario;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.gasto.Gasto;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

import java.util.List;

public class ServicioBilletera {

    private final DaoBilletera daoBilletera;
    private final DaoUsuario daoUsuario;

    @Inject
    public ServicioBilletera(DaoBilletera daoBilletera,DaoUsuario daoUsuario) {
        this.daoBilletera = daoBilletera;
        this.daoUsuario = daoUsuario;
    }


    public void crearBilletera(Usuario user,BilleteraFamiliar billeteraFamiliar) {
        if(daoBilletera.crearBilletera(billeteraFamiliar)){
            daoUsuario.addBilletera(user, billeteraFamiliar);
        }
    }

    public boolean billeteraExiste(String nombreBilletera) {
        return daoBilletera.billeteraExiste(nombreBilletera);
    }

    public List<BilleteraFamiliar> getBilleteras(Usuario usuario) {
        return daoBilletera.getBilleteras(usuario);
    }

    public boolean billeteraExisteUsuarioSpecific(String nombreBilletera,Usuario user) {
        return daoBilletera.billeteraExisteUsuarioSpecific(nombreBilletera, user);
    }

    public boolean eliminarBilletera(Usuario usuario, BilleteraFamiliar billeteraFamiliar) {
        return daoBilletera.eliminarBilletera(usuario, billeteraFamiliar);
    }

    public BilleteraFamiliar getBilletera(String nombreBilletera) {
        return daoBilletera.getBilletera(nombreBilletera);
    }

    public boolean solicitarEntrarBilletera(String nombreBilletera, Solicitud solicitud) {
        return daoBilletera.solicitarEntrarBilletera(nombreBilletera, solicitud);
    }

    public boolean usuarioPerteneceBilletera(String user, String nombreBilletera) {
        return daoBilletera.usuarioPerteneceBilletera(user, nombreBilletera);
    }

    public boolean esLider(String user, String nombreBilletera) {
        return daoBilletera.esLider(user, nombreBilletera);
    }

    public BilleteraFamiliar verDatosBilletera(String nombreBilletera) {
        return daoBilletera.getBilletera(nombreBilletera);
    }

    public List<Solicitud> verSolicitudesBilletera(String nombreBilletera) {
        return daoBilletera.verSolicitudesBilletera(nombreBilletera);
    }

    public List<Gasto> verGastosBilletera(String nombreBilletera) {
        return daoBilletera.verGastosBilletera(nombreBilletera);
    }

    public List<Gasto> verGastosOrdenadosBilletera(String nombreBilletera) {
        return daoBilletera.verGastosOrdenadosBilletera(nombreBilletera);
    }

    public Double verBalanceBilletera(String nombreBilletera) {
        return daoBilletera.verBalanceBilletera(nombreBilletera);
    }

    public boolean haySolicitudes(String nombreBilletera) {
        return  daoBilletera.haySolicitudes(nombreBilletera);
    }

    public boolean billeteraTieneGastos(String nombreBilletera) {
        return daoBilletera.billeteraTieneGastos(nombreBilletera);
    }
}
