package dao.impl;

import dao.BBDD;
import dao.DaoClientes;
import jakarta.inject.Inject;
import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.ClienteDescuento;
import domain.modelo.cliente.LineaCompra;
import domain.modelo.cliente.Monedero;
import domain.modelo.producto.Ingrediente;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class DaoClientesImpl implements DaoClientes {

    private final BBDD db;

    @Inject
    public DaoClientesImpl(BBDD db) {
        this.db = db;
    }
//ADD REMOVE Y ELIMINAR DE LO QUE SEA
    //-------------------------------------------------------------------------------------------------

    @Override
    public boolean addClient(Cliente newClient) {
        boolean ok;
        Map<String, Cliente> clientes = db.loadClientes();
        if (clientes == null) {
            clientes = new LinkedHashMap<>();
        }
        clientes.put(newClient.getDni(), newClient);
        ok = db.saveClientes(clientes);

        return ok;
    }

    @Override
    public boolean removeClient(String dniCliente) {
        boolean ok = false;
        Map<String, Cliente> clientes = db.loadClientes();

        if (clientes != null) {
            clientes.remove(dniCliente);
            ok = db.saveClientes(clientes);
        }
        return ok;
    }

    @Override
    public boolean swapNameClient(Cliente c, String nuevoNombreCliente) {
        boolean ok;
        Map<String, Cliente> clientes = db.loadClientes();

        clientes.get(c.getDni()).setNombre(nuevoNombreCliente);
        ok = db.saveClientes(clientes);

        return ok;
    }

    @Override
    public boolean swapDni(String dniClient, String nuevoDniCliente) {
        boolean ok;
        Map<String, Cliente> clientes = db.loadClientes();

        clientes.put(nuevoDniCliente, clientes.get(dniClient));
        clientes.remove(dniClient);
        clientes.get(nuevoDniCliente).setDni(nuevoDniCliente);

        ok = db.saveClientes(clientes);
        return ok;
    }

    @Override
    public double getTodoDineroMonedero(String dniClient, String nombreMonedero) {
        Map<String, Cliente> clientes = db.loadClientes();

        AtomicReference<Double> dineroTarjeta = new AtomicReference<>((double) 0);
        clientes.get(dniClient).getMonederos().forEach(monedero -> {
            if (monedero.equals(new Monedero(nombreMonedero))) {
                dineroTarjeta.set(monedero.getMoney());
            }
        });
        return dineroTarjeta.get();
    }

    @Override
    public double getDescuentoCliente(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();

        return ((ClienteDescuento)clientes.get(dniClient)).getDescuento();
    }

    @Override
    public Double getCosteCompras(Cliente cliente) {
        return cliente.getBuyHistory().stream()
                .flatMapToDouble(lineaCompras -> lineaCompras.stream()
                        .mapToDouble(value -> value.getProducto().getPrice() * value.getQuantity()))
                .sum();
    }


//COMPROBACIONES (booleans)
    //-------------------------------------------------------------------------------------------------

    @Override
    public boolean clienteTieneDescuento(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient) instanceof ClienteDescuento;
    }

    @Override
    public boolean existClient(String clientDNI) {
        Map<String, Cliente> clientes = db.loadClientes();
        if(clientes!=null)
            return clientes.containsKey(clientDNI);

        return false;
    }

    @Override
    public void emptyCart(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).setCarrito(new ArrayList<>());
        db.saveClientes(clientes);
    }

    @Override
    public void addIngredienteAlergia(String dniClient, String ingrediente) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).getAlergenos().add(new Ingrediente(ingrediente));
        db.saveClientes(clientes);
    }

    @Override
    public boolean ingredienteExisteCliente(String dniClient, String ingrediente) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getAlergenos().contains(new Ingrediente(ingrediente));
    }

    @Override
    public boolean tieneComprasAnteriores(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getBuyHistory().isEmpty();
    }


    //VER COSAS
    //-----------------------------------------------------------------------------------------------

    @Override
    public List<Cliente> showListaClientesSortedDineroGastado() {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.values()
                .stream()
                .sorted((o1, o2) -> getCosteCompras(o2).compareTo(getCosteCompras(o1)))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<LineaCompra> getLineaCompra(String dniClient, int index) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getBuyHistory().get(index);
    }

    @Override
    public List<List<LineaCompra>> showBuyHistory(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getBuyHistory();
    }

    @Override
    public List<Cliente> showListaClientesOrdenadaDni() {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.values()
                .stream()
                .sorted(Comparator.comparing(Cliente::getDni))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Map<String, Cliente> verListaClientes() {
        return db.loadClientes();
    }

    @Override
    public List<LineaCompra> dameCarrito(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient).getCarrito();
    }

    @Override
    public Cliente seeSpecificClient(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return clientes.get(dniClient);
    }

    @Override
    public ClienteDescuento seeSpecificClientDescuento(String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        return (ClienteDescuento) clientes.get(dniClient);
    }

}
