package ui.pantallas.productos;

import jakarta.inject.Inject;
import modelo.producto.Producto;
import servicios.ServicioProductos;

import java.util.List;

public class ProductoViewModel {

    private final ServicioProductos servicioProductos;

    @Inject
    public ProductoViewModel(ServicioProductos servicioProductos) {
        this.servicioProductos = servicioProductos;
    }

    public List<Producto> getProductos(){
        return servicioProductos.showAllProducts();
    }

    public void agregarProducto(Producto producto) {
        servicioProductos.addProduct(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        servicioProductos.removeProduct(nombreProducto);
    }

    public void modificarNombreProducto(String nombre, String newNombre) {
        servicioProductos.updateNameProduct(nombre, newNombre);
    }

    public void modificarPrecioProducto(String nombre, double newPrice) {
        servicioProductos.updatePriceProduct(nombre, newPrice);
    }

    public void modificarStockProducto(String nombre, int newStock) {
        servicioProductos.updateStockProduct(nombre, newStock);
    }
}
