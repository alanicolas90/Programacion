package ui.pantallas.funciones_usuario;


import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.impl.ServicioBilleteraImpl;
import servicios.impl.ServicioUsuarioImpl;
import ui.pantallas.principal.PrincipalController;

import java.util.List;

public class FuncionesUsuarioViewModel {

    private PrincipalController principalController;
    private final ServicioUsuarioImpl servicioUsuario;
    private final ServicioBilleteraImpl servicioBilletera;

    @Inject
    public FuncionesUsuarioViewModel(PrincipalController principalController, ServicioUsuarioImpl servicioUsuario, ServicioBilleteraImpl servicioBilletera) {
        this.principalController = principalController;
        this.servicioUsuario = servicioUsuario;
        this.servicioBilletera = servicioBilletera;
    }

    public Usuario getUsuario(Usuario user) {
        return servicioUsuario.getUsuario(user.getUsername());
    }

    public List<BilleteraFamiliar> getBilleteras(Usuario user) {
        return servicioBilletera.getBilleteras(user);
    }

    public boolean updateUsuario(Usuario usuarioActualizado) {
        return servicioUsuario.updateUsuario(usuarioActualizado);
    }

    public List<Solicitud> getSolicitudes(BilleteraFamiliar billetera, Usuario user) {
        return servicioUsuario.getSolicitudes(billetera, user);
    }

    public boolean aceptarSolicitud(Solicitud solicitud, BilleteraFamiliar billetera) {
        return servicioBilletera.aceptarSolicitud(billetera.getNombreGrupoFamiliar(), solicitud.getSolicitante());
    }

    public boolean rechazarSolicitud(Solicitud solicitud, BilleteraFamiliar billetera) {
        return servicioBilletera.rechazarSolicitud(billetera.getNombreGrupoFamiliar(), solicitud.getSolicitante());
    }
}




