package servicios;

import domain.modelo.producto.Ingrediente;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoCaducable;

import java.util.List;

public interface ServicioProductos {
    boolean addProduct(Producto newProduct);

    boolean removeProduct(String nombreProducto);

    boolean updateNameProduct(String nombreProducto, String newNombreProducto);

    boolean updatePriceProduct(String nombreProducto, double newPriceProducto);

    boolean updateStockProduct(String nombreProducto, int newStockProducto);

    List<Producto> showAllProducts();

    Producto getProductoLista(String productoAgregarCarrito);

    boolean existProduct(String nombreProducto);

    boolean addProductCaducable(ProductoCaducable productoCaducable);

    List<Producto> showAllProductsSinCaducados();

    List<Producto> showAllProductsOrdenadosName();

    List<Producto> showAllProductsConIngredientes();

    boolean addIngredienteAlProducto(String nombreProducto, Ingrediente nuevoIngrediente);

    List<Producto> showAllProductsSinAlergiasCliente(String dniClient);

    List<String> showAllProductsSortedCantidadComprada();
}
