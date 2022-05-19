package domain.usecases;

import dao.DaoUsuarios;
import domain.modelo.Usuario;
import jakarta.inject.Inject;


public class LoginUseCaseImpl implements LoginUseCase {


    private DaoUsuarios daoUsuarios;

    @Inject
    public LoginUseCaseImpl(DaoUsuarios daoUsuarios) {
        this.daoUsuarios = daoUsuarios;
    }


    @Override
    public boolean doLogin(Usuario usuario) {

        return daoUsuarios.doLogin(usuario);

    }
}
