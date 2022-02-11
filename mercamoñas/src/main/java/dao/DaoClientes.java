package dao;

import modelo.Cliente;
import modelo.LineaCompra;

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
                .map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getMonederos(), cliente.getCarrito(),cliente.getBuyHistory()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Cliente seeSpecificClient(String dniClient) {
        return clientes.get(dniClient);
    }

    public List<List<LineaCompra>> showBuyHistory(String dniClient){
        return clientes.get(dniClient).getBuyHistory();
    }
}
