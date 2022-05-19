package ui.pantallas.carrito;

import domain.modelo.cliente.LineaCompra;
import jakarta.inject.Inject;
import servicios.ServicioCompras;
import servicios.impl.ServicioClientsImpl;
import servicios.impl.ServicioComprasImpl;

import java.util.List;

public class CarritoViewModel {

    private final String dniUser = "0001";
    private final ServicioClientsImpl servicioClients;
    private ServicioComprasImpl servicioCompras;

    @Inject
    public CarritoViewModel(ServicioClientsImpl servicioClients, ServicioComprasImpl servicioCompras) {
        this.servicioClients = servicioClients;
        this.servicioCompras = servicioCompras;
    }

    public List<LineaCompra> getCarrito() {
        return servicioClients.showCarrito(dniUser);
    }

    public boolean removeItem(LineaCompra lineaCompra) {
        return servicioCompras.removeProductCart(dniUser, lineaCompra.getProducto().getName());
    }
}
