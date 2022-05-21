package domain.usecases;

import domain.modelo.usuario.Usuario;

public interface LoginUseCase {
    boolean doLogin(Usuario usuario);
}
