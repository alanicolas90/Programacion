package ui.productos;

import dao.BBDD;
import modelo.producto.Producto;
import modelo.producto.ProductoNormal;
import servicios.ServicioProductos;

public class ProductoViewModel {

    private ServicioProductos servicioProductos;
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
}
