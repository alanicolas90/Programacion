package domain.usecases;

import dao.impl.DaoUsuarioImpl;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;


public class LoginUseCaseImpl implements LoginUseCase {


    private DaoUsuarioImpl daoUsuarios;

    @Inject
    public LoginUseCaseImpl(DaoUsuarioImpl daoUsuarios) {
        this.daoUsuarios = daoUsuarios;
    }


    @Override
    public boolean doLogin(Usuario usuario) {

        return daoUsuarios.doLogin(usuario);

    }
}
