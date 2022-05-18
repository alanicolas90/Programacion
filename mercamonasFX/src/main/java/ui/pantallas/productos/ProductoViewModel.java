package ui.pantallas.productos;

import domain.modelo.producto.Producto;
import jakarta.inject.Inject;
import servicios.impl.ServicioProductosImpl;

import java.util.List;

public class ProductoViewModel {
    private final ServicioProductosImpl servicioProductos;

    @Inject
    public ProductoViewModel(ServicioProductosImpl servicioProductos) {
        this.servicioProductos = servicioProductos;
    }

    public List<Producto> getProductos() {
        return servicioProductos.showAllProducts();
    }

    public void addProducto(Producto producto) {
        servicioProductos.addProduct(producto);
    }

    public boolean removeProducto(Producto productTabla) {
        return servicioProductos.removeProduct(productTabla.getName());
    }

    public boolean updateNombreProducto(Producto productTabla, Producto productoActualizado) {
        return servicioProductos.updateNameProduct(productTabla.getName(), productoActualizado.getName());
    }

    public boolean updatePriceProducto(Producto productTabla, Producto productoActualizado) {
        return servicioProductos.updatePriceProduct(productTabla.getName(), productoActualizado.getPrice());
    }

    public boolean updateStockProducto(Producto productTabla, Producto productoActualizado) {
        return servicioProductos.updateStockProduct(productTabla.getName(), productoActualizado.getStock());
    }

}

//    public void updateProducto(Producto producto) {
//        servicioProductos.updateProducto(producto);
//    }



