package dao.impl;

import dao.BBDD;
import dao.DaoMonedero;
import jakarta.inject.Inject;
import modelo.cliente.Cliente;
import modelo.cliente.Monedero;

import java.util.Map;
import java.util.Set;

public class DaoMonederoImpl implements DaoMonedero {

    private BBDD db;

    @Inject
    public DaoMonederoImpl(BBDD db) {
        this.db = db;
    }

    @Override
    public boolean monederoExists(String nombreMonedero, String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getMonederos().contains(new Monedero(nombreMonedero));
    }

    @Override
    public boolean addMonedero(Monedero monedero, String dniClient) {
        boolean ok;
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).getMonederos().add(monedero);
        ok = db.saveClientes(clientes);

        return ok;
    }

    @Override
    public boolean addMoneyMonedero(String dniCliente, String nombreMonedero, double quantity) {
        boolean ok;
        Map<String, Cliente> clientes = db.loadClientes();

        clientes.get(dniCliente).getMonederos().forEach(monedero -> {
            if (monedero.getName().equals(nombreMonedero)) {
                monedero.setMoney((monedero.getMoney() + quantity));
            }
        });

        ok = db.saveClientes(clientes);
        return ok;
    }

    @Override
    public boolean removeMonedero(String dniClient, String nombreMonedero) {
        boolean ok;
        Map<String, Cliente> clientes = db.loadClientes();

        clientes.get(dniClient).getMonederos().remove(new Monedero(nombreMonedero));

        ok = db.saveClientes(clientes);
        return ok;
    }

    @Override
    public Set<Monedero> showTarjetasCliente(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getMonederos();
    }


}
