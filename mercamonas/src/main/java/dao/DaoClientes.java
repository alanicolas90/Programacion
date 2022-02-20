package dao;

import modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static dao.BBDD.clientes;

public class DaoClientes {


    public boolean clienteTieneDescuento(String dniClient) {
        return clientes.get(dniClient) instanceof ClienteDescuento;
    }

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
                .map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido(),
                        cliente.getMonederos(), cliente.getCarrito(), cliente.getBuyHistory()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Cliente seeSpecificClient(String dniClient) {
        return clientes.get(dniClient).clone();
    }

    public ClienteDescuento seeSpecificClientDescuento(String dniClient) {
        return (ClienteDescuento) clientes.get(dniClient);
    }

    public List<List<LineaCompra>> showBuyHistory(String dniClient) {
        return clientes.get(dniClient).getBuyHistory();
    }

    public List<LineaCompra> dameCarrito(String dniClient) {
        return clientes.get(dniClient).getCarrito();
    }

    public void emptyCart(String dniClient) {
        clientes.get(dniClient).setCarrito(new ArrayList<>());
    }

    public double getTodoDineroMonedero(String dniClient, String nombreMonedero) {
        AtomicReference<Double> dineroTarjeta = new AtomicReference<>((double) 0);
        clientes.get(dniClient).getMonederos().forEach(monedero -> {
            if (monedero.equals(new Monedero(nombreMonedero))) {
                dineroTarjeta.set(monedero.getMoney());
            }
        });
        return dineroTarjeta.get();
    }

    public double getDescuentoCliente(String dniClient) {
        return ((ClienteDescuento) clientes.get(dniClient)).getDescuento();
    }

}
