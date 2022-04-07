package servicios;

import modelo.cliente.Cliente;
import modelo.cliente.LineaCompra;
import modelo.cliente.Monedero;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ServicioClients {
    boolean addClient(Cliente newClient);

    boolean removeClient(String dniClient);

    boolean swapNameClient(Cliente c, String nuevoNombreCliente);

    boolean swapDni(String dniClient, String nuevoDniCliente);

    boolean existeCliente(String dniClient);

    Map<String, Cliente> showListClients();

    boolean addMoney(String dniCliente, String nombreTarjeta, double dineroAgregar);

    boolean addMonedero(Monedero monedero, String dniClient);

    boolean removeMonedero(String nombreMonedero, String dniClient);

    Set<Monedero> showTarjetasCliente(String dniClient);

    Cliente verDataCliente(String dniClient);

    List<LineaCompra> showCarrito(String dniClient);

    double getTotalPrice(String dniClient);

    List<Cliente> showListClientsSotedDni();

    boolean addIngredienteAlergia(String dniClient, String ingrediente);

    boolean tieneComprasAnteriores(String dniClient);

    double dineroTotalGastado(String dniClient);

    List<Cliente> showClientesSortedDineroGastado();
}
