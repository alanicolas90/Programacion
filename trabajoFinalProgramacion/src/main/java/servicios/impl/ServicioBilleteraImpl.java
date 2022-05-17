package servicios.impl;

import dao.DaoBilletera;
import dao.DaoUsuario;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.gasto.Gasto;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.ServicioBilletera;

import java.util.List;

public class ServicioBilleteraImpl implements ServicioBilletera {

    private final DaoBilletera daoBilletera;
    private final DaoUsuario daoUsuarioImpl;

    @Inject
    public ServicioBilleteraImpl(DaoBilletera daoBilletera,DaoUsuario daoUsuarioImpl) {
        this.daoBilletera = daoBilletera;
        this.daoUsuarioImpl = daoUsuarioImpl;
    }


    @Override public void crearBilletera(Usuario user,BilleteraFamiliar billeteraFamiliar) {
        if(daoBilletera.crearBilletera(billeteraFamiliar)){
            daoUsuarioImpl.addBilletera(user, billeteraFamiliar);
        }
    }

    @Override public boolean billeteraExiste(String nombreBilletera) {
        return daoBilletera.billeteraExiste(nombreBilletera);
    }

    @Override public List<BilleteraFamiliar> getBilleteras(Usuario usuario) {
        return daoBilletera.getBilleteras(usuario);
    }

    @Override public boolean billeteraExisteUsuarioSpecific(String nombreBilletera,Usuario user) {
        return daoBilletera.billeteraExisteUsuarioSpecific(nombreBilletera, user);
    }

    @Override public boolean eliminarBilletera(Usuario usuario, BilleteraFamiliar billeteraFamiliar) {
        return daoBilletera.eliminarBilletera(usuario, billeteraFamiliar);
    }

    @Override public BilleteraFamiliar getBilletera(String nombreBilletera) {
        return daoBilletera.getBilletera(nombreBilletera);
    }

    @Override public boolean solicitarEntrarBilletera(String nombreBilletera, Solicitud solicitud) {
        return daoBilletera.solicitarEntrarBilletera(nombreBilletera, solicitud);
    }

    @Override public boolean usuarioPerteneceBilletera(String user, String nombreBilletera) {
        return daoBilletera.usuarioPerteneceBilletera(user, nombreBilletera);
    }

    @Override public boolean esLider(String user, String nombreBilletera) {
        return daoBilletera.esLider(user, nombreBilletera);
    }

    @Override public BilleteraFamiliar verDatosBilletera(String nombreBilletera) {
        return daoBilletera.getBilletera(nombreBilletera);
    }

    @Override public List<Solicitud> verSolicitudesBilletera(String nombreBilletera) {
        return daoBilletera.verSolicitudesBilletera(nombreBilletera);
    }

    @Override public List<Gasto> verGastosBilletera(String nombreBilletera) {
        return daoBilletera.verGastosBilletera(nombreBilletera);
    }

    @Override public List<Gasto> verGastosOrdenadosBilletera(String nombreBilletera) {
        return daoBilletera.verGastosOrdenadosBilletera(nombreBilletera);
    }

    @Override public Double verBalanceBilletera(String nombreBilletera) {
        return daoBilletera.verBalanceBilletera(nombreBilletera);
    }

    @Override public boolean haySolicitudes(String nombreBilletera) {
        return  daoBilletera.haySolicitudes(nombreBilletera);
    }

    @Override public boolean billeteraTieneGastos(String nombreBilletera) {
        return daoBilletera.billeteraTieneGastos(nombreBilletera);
    }

    @Override public boolean aceptarSolicitud(String nombreBilletera, String usuario) {
        return daoBilletera.aceptarSolicitud(nombreBilletera, usuario);
    }

    @Override public boolean rechazarSolicitud(String nombreBilletera, String usuario) {
        return daoBilletera.rechazarSolicitud(nombreBilletera, usuario);
    }

    @Override public boolean meterGastoBilletera(String nombreBilletera, Gasto gasto) {
        return daoBilletera.meterGastoBilletera(nombreBilletera, gasto);
    }

    @Override public boolean addDineroBilletera(String nombreBilletera, double monto, Usuario user) {
        return daoBilletera.addDineroBilletera(nombreBilletera, monto, user);
    }
}
