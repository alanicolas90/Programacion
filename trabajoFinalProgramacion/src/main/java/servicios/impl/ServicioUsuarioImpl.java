package servicios.impl;

import dao.DaoUsuario;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.ServicioUsuario;

import java.util.List;

public class ServicioUsuarioImpl implements ServicioUsuario {

    private final DaoUsuario daoUsuarioImpl;

    @Inject
    public ServicioUsuarioImpl(DaoUsuario daoUsuarioImpl) {
        this.daoUsuarioImpl = daoUsuarioImpl;
    }

    @Override public boolean registarUsuario(Usuario u) {
        return daoUsuarioImpl.registrarUsuario(u);
    }

    @Override public boolean existeUsuario(String user) {
        return daoUsuarioImpl.existeUsuario(user);
    }

    @Override public boolean logIn(String user, String password) {
        return daoUsuarioImpl.logIn(user, password);
    }

    @Override public Usuario getUsuario(String user) {
        return daoUsuarioImpl.verPerfil(user);
    }

    @Override public String getNombreUsuario(String user) {
        return daoUsuarioImpl.getNombreUsuario(user);
    }

    @Override public boolean tieneBilletera(String user) {
        return daoUsuarioImpl.tieneBilletera(user);
    }

    @Override public boolean changePassword(Usuario user, String newPassword) {
        return daoUsuarioImpl.changePassword(user, newPassword);
    }

    @Override public boolean changeName(Usuario user, String newName) {
        return daoUsuarioImpl.changeName(user, newName);
    }

    @Override public boolean changeLastName(Usuario user, String newLastName) {
        return daoUsuarioImpl.changeLastName(user, newLastName);
    }

    @Override public boolean changeEmail(Usuario user, String newEmail) {
        return daoUsuarioImpl.changeEmail(user, newEmail);
    }

    @Override public boolean changeSalary(Usuario user, double newSalary) {
        return daoUsuarioImpl.changeSalary(user, newSalary);
    }

    @Override public boolean tieneSuficienteDinero(String nombre, double monto) {
        return daoUsuarioImpl.tieneSuficienteDinero(nombre, monto);
    }

    public boolean existeCorreo(String email) {
        return daoUsuarioImpl.existeCorreo(email);
    }

    public List<BilleteraFamiliar> getBilleteras(Usuario user) {
        return daoUsuarioImpl.getBilleteras(user);
    }

    public boolean updateUsuario(Usuario usuarioActualizado) {
        return daoUsuarioImpl.updateUsuario(usuarioActualizado);
    }

    public List<Solicitud> getSolicitudes(BilleteraFamiliar billetera, Usuario user) {
        return daoUsuarioImpl.getSolicitudes(billetera,user);
    }

}
