package dao.impl;

import config.Configuration;
import dao.DaoLogin;
import domain.modelo.Usuario;
import jakarta.inject.Inject;

public class DaoLoginImpl implements DaoLogin {


    private Configuration configuracion;

    @Inject
    public DaoLoginImpl(Configuration configuracion) {
        this.configuracion = configuracion;
    }

    @Override
    public boolean doLogin(Usuario user) {

        // buscar usuario
        if (user.getNombre().equals("admin") || user.getNombre().equals("user"))
            return true;
        return false;
    }
}
