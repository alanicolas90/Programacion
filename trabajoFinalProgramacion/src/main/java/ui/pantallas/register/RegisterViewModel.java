package ui.pantallas.register;

import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import servicios.impl.ServicioUsuarioImpl;

public class RegisterViewModel {

    ServicioUsuarioImpl servicioUsuario;

    @Inject
    public RegisterViewModel(ServicioUsuarioImpl servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }
    public boolean usernameExist(String username) {
        return servicioUsuario.existeUsuario(username);
    }

    public boolean emailExist(String email) {
        return servicioUsuario.existeCorreo(email);
    }

    public void registerUser(Usuario user) {
        servicioUsuario.registarUsuario(user);
    }
}
