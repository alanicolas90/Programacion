package dao.impl;

import dao.BBDD;
import dao.DaoBilletera;
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

public class DaoBilleteraImpl implements DaoBilletera {

    private final BBDD db;

    @Inject
    public DaoBilleteraImpl(BBDD db) {
        this.db = db;
    }

    @Override
    public boolean crearBilletera(BilleteraFamiliar billeteraFamiliar) {
        boolean ok;
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        if (billeteras == null) {
            billeteras = new LinkedHashMap<>();
        }
        billeteras.put(billeteraFamiliar.getNombreGrupoFamiliar(), billeteraFamiliar);
        ok = db.saveBilletera(billeteras);
        return ok;
    }

    @Override
    public boolean billeteraExiste(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.containsKey(nombreBilletera);
    }

    @Override
    public List<BilleteraFamiliar> getBilleteras(Usuario usuario) {
        Map<String, Usuario> usuarios = db.loadUsers();
        return usuarios.get(usuario.getUsername()).getBilleteras();

    }

    @Override
    public boolean billeteraExisteUsuarioSpecific(String nombreBilletera, Usuario user) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String, Usuario> users = db.loadUsers();
        return users.get(user.getUsername()).getBilleteras().contains(billeteras.get(nombreBilletera));
    }

    @Override
    public boolean eliminarBilletera(Usuario usuario, BilleteraFamiliar billeteraFamiliar) {
        Map<String, Usuario> usuarios = db.loadUsers();
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        usuarios.get(usuario.getUsername()).getBilleteras().remove(billeteraFamiliar);
        billeteras.remove(billeteraFamiliar.getNombreGrupoFamiliar());
        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);
    }

    @Override
    public boolean esLider(String usuario, String nombreBilleteraFamiliar) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilleteraFamiliar).getLider().equals(usuario);
    }

    @Override
    public BilleteraFamiliar getBilletera(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera);
    }

    @Override
    public boolean solicitarEntrarBilletera(String nombreBilletera, Solicitud solicitud) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String, Usuario> usuarios = db.loadUsers();
        usuarios.forEach((s, usuario) -> usuario.getBilleteras()
                .stream()
                .filter(billeteraFamiliar -> billeteraFamiliar.getNombreGrupoFamiliar().equals(nombreBilletera))
                .forEach(billeteraFamiliar -> billeteraFamiliar.getSolicitudes().add(solicitud)));
        billeteras.get(nombreBilletera).getSolicitudes().add(solicitud);
        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);
    }

    @Override
    public boolean usuarioPerteneceBilletera(String user, String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getIntegrantes().stream().anyMatch(usuario -> usuario.getUsername().equals(user));
    }

    @Override
    public List<Solicitud> verSolicitudesBilletera(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getSolicitudes();
    }

    @Override
    public List<Gasto> verGastosBilletera(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getGastos();
    }


    @Override
    public List<Gasto> verGastosOrdenadosBilletera(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getGastos().stream().sorted(Comparator.comparing(Gasto::getCantidadGasto)).collect(Collectors.toList());
    }

    @Override
    public Double verBalanceBilletera(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return billeteras.get(nombreBilletera).getDineroBilletera();
    }

    @Override
    public boolean haySolicitudes(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return !billeteras.get(nombreBilletera).getSolicitudes().isEmpty();
    }

    @Override
    public boolean billeteraTieneGastos(String nombreBilletera) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        return !billeteras.get(nombreBilletera).getGastos().isEmpty();
    }

    @Override
    public boolean aceptarSolicitud(String nombreBilletera, String user) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String, Usuario> usuarios = db.loadUsers();

        //Meter al solicitante como integrante de la billetera
        billeteras.get(nombreBilletera).getIntegrantes().add(usuarios.get(user));
        //Cambiar estado de la solicitud
        billeteras.get(nombreBilletera)
                .getSolicitudes()
                .forEach(solicitud -> {
                    if (solicitud.getSolicitante().equals(user)) {
                        solicitud.setAceptado(true);
                    }
                });

        //Todos los usuario se les avtualize el estado de la billetera de la solitud a aaceptado
        usuarios.forEach((s, usuario) -> usuario.getBilleteras()
                .stream()
                .filter(billeteraFamiliar -> billeteraFamiliar.getNombreGrupoFamiliar().equals(nombreBilletera))
                .forEach(billeteraFamiliar -> billeteraFamiliar.getSolicitudes().forEach(solicitud -> {
                    if (solicitud.getSolicitante().equals(user)) {
                        solicitud.setAceptado(true);
                    }
                })));

        usuarios.get(user).getBilleteras().add(billeteras.get(nombreBilletera));

        //Todos los usuarios se les actualize el nuevo integrante
        usuarios.forEach((s, usuario) -> usuario.getBilleteras()
                .forEach(billeteraFamiliar -> {
                    if (billeteraFamiliar.getNombreGrupoFamiliar().equals(nombreBilletera)) {
                        billeteraFamiliar.getIntegrantes().add(usuarios.get(user));
                    }
                }));


        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);
    }

    @Override
    public boolean rechazarSolicitud(String nombreBilletera, String users) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String, Usuario> usuarios = db.loadUsers();


        billeteras.get(nombreBilletera).getSolicitudes().remove(new Solicitud(users));

        usuarios.forEach((s, usuario1) -> usuario1.getBilleteras()
                .forEach(billeteraFamiliar -> {
                    if(billeteraFamiliar.getNombreGrupoFamiliar().equals(nombreBilletera)){
                        billeteraFamiliar.getSolicitudes().remove(new Solicitud(users));
                    }
                }));

        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);

    }

    @Override
    public boolean meterGastoBilletera(String nombreBilletera, Gasto gasto) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();

        billeteras.get(nombreBilletera).getGastos().add(gasto);

        return db.saveBilletera(billeteras);
    }

    @Override
    public boolean addDineroBilletera(String nombreBilletera, double monto, Usuario user) {
        Map<String, BilleteraFamiliar> billeteras = db.loadBilletera();
        Map<String, Usuario> usuarios = db.loadUsers();

        //Quitar dinero al usuario
        double dinero = usuarios.get(user.getUsername()).getDinero();
        usuarios.get(user.getUsername()).setDinero(dinero - monto);

        //añadir dinero a la billetera
        double cantidadAnterior= billeteras.get(nombreBilletera).getDineroBilletera();
        billeteras.get(nombreBilletera).setDineroBilletera(cantidadAnterior+monto);

        return db.saveBilletera(billeteras) && db.saveUsers(usuarios);
    }
}

