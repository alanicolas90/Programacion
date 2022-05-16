package dao;

import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

import java.util.LinkedHashMap;
import java.util.Map;

public class DaoUsuario {

    private final BBDD bbdd;

    @Inject
    public DaoUsuario(BBDD db) {
        this.bbdd = db;
    }

    //__________________________________________________________________________

    public boolean registrarUsuario(Usuario user) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        if (users==null) {
            users = new LinkedHashMap<>();
        }
        users.put(user.getUsername(), user);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    public boolean existeUsuario(String username) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.containsKey(username);
    }

    public boolean logIn(String user, String password) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(user).getPassword().equals(password);
    }

    public Usuario verPerfil(String user) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(user);
    }

    public String getNombreUsuario(String user) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(user).getUsername();
    }

    public boolean addBilletera(Usuario user, BilleteraFamiliar billetera) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).getBilleteras().add(billetera);
        bbdd.saveUsers(users);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    public boolean tieneBilletera(String user) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return !users.get(user).getBilleteras().isEmpty();
    }

    public boolean changePassword(Usuario user, String newPassword) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setPassword(newPassword);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    public boolean changeName(Usuario user, String newName) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setNombre(newName);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    public boolean changeLastName(Usuario user, String newLastName) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setApellido(newLastName);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    public boolean changeEmail(Usuario user, String newEmail) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setCorreo(newEmail);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    public boolean changeSalary(Usuario user, double newSalary) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setDinero(newSalary);
        ok = bbdd.saveUsers(users);
        return ok;
    }
}
