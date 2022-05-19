package servicios;

import dao.DaoUsuarios;
import domain.modelo.Usuario;
import jakarta.inject.Inject;

public class ServicioUsuarios {

    private DaoUsuarios daoUsuarios;

    @Inject
    public ServicioUsuarios(DaoUsuarios daoUsuarios) {
        this.daoUsuarios = daoUsuarios;
    }

    public boolean addUser(Usuario user){
        return daoUsuarios.addUser(user);
    }


}
