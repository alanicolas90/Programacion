package dao;

import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.gasto.Gasto;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        usuarios.get(usuario.getUsername()).getBilleteras().remove(billeteraFamiliar);
        billeteras.remove(billeteraFamiliar.getNombreGrupoFamiliar());
        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);
    }

    public boolean esLider(String usuario, String nombreBilleteraFamiliar) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilleteraFamiliar).getLider().equals(usuario);
    }
    public BilleteraFamiliar getBilletera(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera);
    }

    public boolean solicitarEntrarBilletera(String nombreBilletera, Solicitud solicitud) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String,Usuario> usuarios = db.loadUsers();
        usuarios.forEach((s, usuario) -> usuario.getBilleteras()
                .stream()
                .filter(billeteraFamiliar -> billeteraFamiliar.getNombreGrupoFamiliar().equals(nombreBilletera))
                .forEach(billeteraFamiliar -> billeteraFamiliar.getSolicitudes().add(solicitud)));
        billeteras.get(nombreBilletera).getSolicitudes().add(solicitud);
        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);
    }

    public boolean usuarioPerteneceBilletera(String user, String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getIntegrantes().stream().anyMatch(usuario -> usuario.getUsername().equals(user));
    }

    public List<Solicitud> verSolicitudesBilletera(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getSolicitudes();
    }

    public List<Gasto> verGastosBilletera(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getGastos();
    }


    public List<Gasto> verGastosOrdenadosBilletera(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getGastos().stream().sorted(Comparator.comparing(Gasto::getCantidadGasto)).collect(Collectors.toList());
    }

    public Double verBalanceBilletera(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getDineroBilletera();
    }

    public boolean haySolicitudes(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return !billeteras.get(nombreBilletera).getSolicitudes().isEmpty();
    }

    public boolean billeteraTieneGastos(String nombreBilletera) {
        Map<String,BilleteraFamiliar> billeteras = db.loadBilletera();
        return !billeteras.get(nombreBilletera).getGastos().isEmpty();
    }
}
