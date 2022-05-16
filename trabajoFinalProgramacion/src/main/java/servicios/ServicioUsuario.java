package servicios;

import dao.DaoUsuario;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

public class ServicioUsuario {

    private final DaoUsuario daoUsuario;

    @Inject
    public ServicioUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public boolean registarUsuario(Usuario u) {
        return daoUsuario.registrarUsuario(u);
    }

    public boolean existeUsuario(String user) {
        return daoUsuario.existeUsuario(user);
    }

    public boolean logIn(String user, String password) {
        return daoUsuario.logIn(user, password);
    }

    public Usuario getUsuario(String user) {
        return daoUsuario.verPerfil(user);
    }

    public String getNombreUsuario(String user) {
        return daoUsuario.getNombreUsuario(user);
    }

    public boolean tieneBilletera(String user) {
        return daoUsuario.tieneBilletera(user);
    }

    public boolean changePassword(Usuario user, String newPassword) {
        return daoUsuario.changePassword(user, newPassword);
    }

    public boolean changeName(Usuario user, String newName) {
        return daoUsuario.changeName(user, newName);
    }

    public boolean changeLastName(Usuario user, String newLastName) {
        return daoUsuario.changeLastName(user, newLastName);
    }

    public boolean changeEmail(Usuario user, String newEmail) {
        return daoUsuario.changeEmail(user, newEmail);
    }

    public boolean changeSalary(Usuario user, double newSalary) {
        return daoUsuario.changeSalary(user, newSalary);
    }
}
