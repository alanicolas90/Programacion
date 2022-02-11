package dao;

import modelo.Cliente;

import java.util.List;
import java.util.stream.Collectors;

import static dao.BBDD.clientes;

public class DaoClientes {


    public boolean existClient(String clientDNI) {
        return clientes.containsKey(clientDNI);
    }

    public void addClient(Cliente newClient) {
        clientes.put(newClient.getDni(), newClient);
    }

    public void removeClient(String dniClient) {
        clientes.remove(dniClient);
    }

    public void swapNameClient(String dniClient, String nuevoNombreCliente) {
        clientes.get(dniClient).setNombre(nuevoNombreCliente);
    }

    public void swapSurnameClient(String dniClient, String newSurnameClient) {
        clientes.get(dniClient).setApellido(newSurnameClient);

    }

    public void swapDni(String dniClient, String nuevoDniCliente) {
        clientes.get(dniClient).setDni(nuevoDniCliente);
        clientes.put(nuevoDniCliente, clientes.get(dniClient));
        clientes.remove(dniClient);
    }

    public List<Cliente> verListaClientes() {
        return clientes.values().stream()
                .map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Cliente> seeSpecificClient(String dniClient) {
        return clientes.values().stream()
                .map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido()))
                .collect(Collectors.toUnmodifiableList());
    }

    public void addMoney(String dniClient, String nombreTarjeta, double dineroAgregar) {

    }
}
