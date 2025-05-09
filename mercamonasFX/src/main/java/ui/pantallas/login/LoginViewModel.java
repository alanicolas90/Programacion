package ui.pantallas.login;

import domain.modelo.Usuario;
import domain.usecases.LoginUseCase;
import jakarta.inject.Inject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class LoginViewModel {


    private LoginUseCase loginUseCase;

    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
        state = new SimpleObjectProperty<>(new LoginState(false,null));
    }

    private final ObjectProperty<LoginState> state;
    public ReadOnlyObjectProperty<LoginState> getState() {
        return state;
    }


    public void doLogin(Usuario usuario) {
        if (loginUseCase.doLogin(usuario))
        {
            state.setValue(new LoginState(true,null));
        }
        else
        {
            state.setValue(new LoginState(false,"usuario o pass no valido"));
        }
    }
}
