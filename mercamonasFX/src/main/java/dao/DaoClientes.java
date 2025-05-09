package dao;

import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.ClienteDescuento;
import domain.modelo.cliente.LineaCompra;
import domain.modelo.cliente.Monedero;

import java.util.List;
import java.util.Map;

public interface DaoClientes {
    boolean addClient(Cliente newClient);

    boolean removeClient(String dniCliente);

    boolean swapNameClient(Cliente c, String nuevoNombreCliente);

    boolean swapDni(String dniClient, String nuevoDniCliente);

    double getTodoDineroMonedero(String dniClient, String nombreMonedero);

    double getDescuentoCliente(String dniClient);

    Double getCosteCompras(Cliente cliente);

    boolean clienteTieneDescuento(String dniClient);

    boolean existClient(String clientDNI);

    void emptyCart(String dniClient);

    void addIngredienteAlergia(String dniClient, String ingrediente);

    boolean ingredienteExisteCliente(String dniClient, String ingrediente);

    boolean tieneComprasAnteriores(String dniClient);
    List<Cliente> showClientes();

    List<Cliente> showListaClientesSortedDineroGastado();

    List<LineaCompra> getLineaCompra(String dniClient, int index);

    List<List<LineaCompra>> showBuyHistory(String dniClient);

    List<Cliente> showListaClientesOrdenadaDni();

    List<Cliente> verListaClientes();

    List<LineaCompra> dameCarrito(String dniClient);

    Cliente seeSpecificClient(String dniClient);

    ClienteDescuento seeSpecificClientDescuento(String dniClient);

    List<Monedero> getMonederosCliente(String dniClient);
}
