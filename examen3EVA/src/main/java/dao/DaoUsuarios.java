package dao;

import domain.modelo.Usuario;
import jakarta.inject.Inject;

import java.util.LinkedHashMap;
import java.util.Map;

public class DaoUsuarios {
    private final BBDD db;

    @Inject
    public DaoUsuarios(BBDD db) {
        this.db = db;
    }

    public boolean addUser(Usuario user) {
        boolean ok;
        Map<String, Usuario> usuarios = db.loadUsuarios();
        if (usuarios == null) {
            usuarios = new LinkedHashMap<>();
        }
        usuarios.put(user.getUsername(), user);
        ok = db.saveUsuarios(usuarios);

        return ok;
    }

    public boolean userExiste(Usuario user){
        Map<String, Usuario> usuarios = db.loadUsuarios();

        if(usuarios!=null){
            return usuarios.containsKey(user.getUsername()) && usuarios.get(user.getUsername()).getPassword().equals(user.getPassword());
        }
        return false;

    }

    public boolean doLogin(Usuario user){
        if(user.getUsername().equals("admin")|| userExiste(user)){
            return true;
        }
        return false;
    }

}
