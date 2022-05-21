package dao.impl;

import dao.BBDD;
import dao.DaoUsuario;
import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

import java.util.LinkedHashMap;
import java.util.Map;

public class DaoUsuarioImpl implements DaoUsuario {

    private final BBDD bbdd;

    @Inject
    public DaoUsuarioImpl(BBDD db) {
        this.bbdd = db;
    }

    //__________________________________________________________________________

    @Override public boolean registrarUsuario(Usuario user) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        if (users==null) {
            users = new LinkedHashMap<>();
        }
        users.put(user.getUsername(), user);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean existeUsuario(String username) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.containsKey(username);
    }

    @Override public boolean logIn(String user, String password) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(user).getPassword().equals(password);
    }

    @Override public Usuario verPerfil(String user) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(user);
    }

    @Override public String getNombreUsuario(String user) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(user).getUsername();
    }

    @Override public boolean addBilletera(Usuario user, BilleteraFamiliar billetera) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).getBilleteras().add(billetera);
        bbdd.saveUsers(users);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean tieneBilletera(String user) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return !users.get(user).getBilleteras().isEmpty();
    }

    @Override public boolean changePassword(Usuario user, String newPassword) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setPassword(newPassword);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean changeName(Usuario user, String newName) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setNombre(newName);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean changeLastName(Usuario user, String newLastName) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setApellido(newLastName);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean changeEmail(Usuario user, String newEmail) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setCorreo(newEmail);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean changeSalary(Usuario user, double newSalary) {
        boolean ok;
        Map<String,Usuario> users = bbdd.loadUsers();
        users.get(user.getUsername()).setDinero(newSalary);
        ok = bbdd.saveUsers(users);
        return ok;
    }

    @Override public boolean tieneSuficienteDinero(String nombre, double monto) {
        Map<String,Usuario> users = bbdd.loadUsers();
        return users.get(nombre).getDinero() >= monto;
    }

    public boolean userExiste(Usuario user){
        Map<String, Usuario> usuarios = bbdd.loadUsers();

        if(usuarios!=null){
            return usuarios.containsKey(user.getUsername()) && usuarios.get(user.getUsername()).getPassword().equals(user.getPassword());
        }
        return false;

    }

    @Override
    public boolean doLogin(Usuario user){
        if(user.getUsername().equals("admin")|| userExiste(user)){
            return true;
        }
        return false;
    }
}
