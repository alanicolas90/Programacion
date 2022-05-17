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

    public void deleteProducto(Producto producto) {
        servicioProductos.removeProduct(producto.getName());
    }

//    public void updateProducto(Producto producto) {
//        servicioProductos.updateProducto(producto);
//    }

}

