package ui.pantallas.productos;

import dao.BBDD;
import domain.modelo.producto.Producto;
import servicios.ServicioProductos;

import java.util.List;

public class ProductoViewModel {
    private final ServicioProductos servicioProductos;
    private final BBDD db;

    public ProductoViewModel(ServicioProductos servicioProductos, BBDD db) {
        this.servicioProductos = servicioProductos;
        this.db = db;
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

    public List<Producto> allProducts() {
        return servicioProductos.showAllProducts();
    }
}
