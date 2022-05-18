package ui.pantallas.clientes;

import domain.modelo.cliente.Cliente;
import jakarta.inject.Inject;
import servicios.impl.ServicioClientsImpl;

import java.util.List;

public class ClientesViewModel {

    private final ServicioClientsImpl servicioClients;

    @Inject
    public ClientesViewModel(ServicioClientsImpl servicioClients) {
        this.servicioClients = servicioClients;
    }

    public List<Cliente> allClients() {
        return servicioClients.getListClientes();
    }

    public boolean addClient(Cliente cliente) {
        return servicioClients.addClient(cliente);
    }

    public boolean removeClient(Cliente cliente) {
        return servicioClients.removeClient(cliente.getDni());
    }

    public Cliente getCliente(String dni) {
        return servicioClients.verDataCliente(dni);
    }

    public boolean updateNombreCliente(Cliente c, String nombre) {
    return servicioClients.swapNameClient(c, nombre);
    }

    public boolean updateDniCliente(Cliente cliente, String nuevoDni) {
        return servicioClients.swapDni(cliente.getDni(),nuevoDni);
    }
}
