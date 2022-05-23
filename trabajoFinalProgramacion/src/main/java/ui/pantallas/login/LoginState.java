package ui.pantallas.login;

import domain.modelo.usuario.Usuario;
import lombok.Data;

@Data
public class LoginState {

    private final boolean loginOK;
    private final String error;
    private final Usuario user;

    public Usuario getUsuario(){
        return user;
    }

}
