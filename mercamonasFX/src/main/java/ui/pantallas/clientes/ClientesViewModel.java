package ui.pantallas.clientes;

import domain.modelo.cliente.Cliente;
import jakarta.inject.Inject;
import servicios.impl.ServicioClientsImpl;

import java.util.List;
import java.util.Map;

public class ClientesViewModel {

    private ServicioClientsImpl servicioClients;

    @Inject
    public ClientesViewModel(ServicioClientsImpl servicioClients) {
        this.servicioClients = servicioClients;
    }

    public List<Cliente> allClients() {
        return servicioClients.getListClientes();
    }
}
