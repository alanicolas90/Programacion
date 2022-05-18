package ui.pantallas.monedero;

import domain.modelo.cliente.Monedero;
import jakarta.inject.Inject;
import servicios.impl.ServicioClientsImpl;
import servicios.impl.ServicioComprasImpl;

import java.util.List;

public class MonederoViewModel {

    private final ServicioComprasImpl servicioCompras;
    private final ServicioClientsImpl servicioClients;


    private final String dniUser = "0001";

    @Inject
    public MonederoViewModel(ServicioComprasImpl servicioCompras,ServicioClientsImpl servicioClients) {
        this.servicioCompras = servicioCompras;
        this.servicioClients = servicioClients;
    }

    public List<Monedero> getMonedero() {
        return servicioClients.getMonederosCliente(dniUser);
    }
}
