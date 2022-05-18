package ui.pantallas.compra;

import domain.modelo.cliente.LineaCompra;
import domain.modelo.producto.Producto;
import jakarta.inject.Inject;
import servicios.impl.ServicioComprasImpl;
import servicios.impl.ServicioProductosImpl;

import java.util.List;

public class CompraViewModel {

    private final String dniUser = "0001";
    private final ServicioProductosImpl servicioProductos;
    private final ServicioComprasImpl servicioCompras;

    @Inject
    public CompraViewModel(ServicioProductosImpl servicioProductos,ServicioComprasImpl servicioCompras) {
        this.servicioProductos = servicioProductos;
        this.servicioCompras = servicioCompras;
    }

    public List<Producto> getProductos() {
        return servicioProductos.showAllProducts();
    }

    public boolean meterAlCarrito(Producto p, int cantidad) {
        LineaCompra lineaCompra = new LineaCompra(p, cantidad);
        return servicioCompras.addToCart(dniUser,lineaCompra);
    }
}
