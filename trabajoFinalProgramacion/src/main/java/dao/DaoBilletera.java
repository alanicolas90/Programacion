package dao;

import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DaoBilletera {

    private final BBDD db;

    @Inject
    public DaoBilletera(BBDD db) {
        this.db = db;
    }

    public boolean crearBilletera(BilleteraFamiliar billeteraFamiliar) {
        boolean ok;
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        if(billeteras == null){
            billeteras = new LinkedHashMap<>();
        }
        billeteras.put(billeteraFamiliar.getNombreGrupoFamiliar(),billeteraFamiliar);
        ok = db.saveBilletera(billeteras);
        return ok;
    }

    public boolean billeteraExiste(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.containsKey(nombreBilletera);
    }

    public List<BilleteraFamiliar> getBilleteras(Usuario usuario) {
        Map<String,Usuario> usuarios = db.loadUsers();
        return usuarios.get(usuario.getUsername()).getBilleteras();

    }

    public boolean billeteraExisteUsuarioSpecific(String nombreBilletera,Usuario user) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String, Usuario> users = db.loadUsers();
        return users.get(user.getUsername()).getBilleteras().contains(billeteras.get(nombreBilletera));
    }

    public boolean eliminarBilletera(Usuario usuario,BilleteraFamiliar billeteraFamiliar) {
        Map<String,Usuario> usuarios = db.loadUsers();
        usuarios.get(usuario.getUsername()).getBilleteras().remove(billeteraFamiliar);
        return db.saveUsers(usuarios);
    }

//    public boolean esLider(Usuario usuario, String nombreBilleteraFamiliar) {
//        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
//        return billeteras.get(nombreBilleteraFamiliar).getLider().equals(usuario.getUsername());
//    }

//    public void eliminarBilleteras(String nombreBilletera) {
//        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
//        Map<String,Usuario> users= db.loadUsers();
//        users.forEach((username,user)-> user.getBilleteras().remove(billeteras.get(nombreBilletera)));
//        billeteras.remove(nombreBilletera);
//        db.saveBilletera(billeteras);
//        db.saveUsers(users);
//    }

    public BilleteraFamiliar getBilletera(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera);
    }
}
