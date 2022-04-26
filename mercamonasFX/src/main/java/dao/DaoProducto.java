package dao;

import modelo.producto.Ingrediente;
import modelo.producto.Producto;

import java.util.List;

public interface DaoProducto {

    boolean addProducto(Producto newProducto);

    boolean removeProducto(String nombreProducto);

    boolean updateNameProducto(String nombreProducto, String newNombreProducto);

    boolean updatePriceProducto(String nombreProducto, double newPriceProducto);

    boolean updateStockProducto(String nombreProducto, int newStockProducto);

    Producto getProductoLista(String productoParaMeterCarrito);

    double getPriceProducto(String nameProduct);

    int getStockProduct(String nombreProduct);

    boolean addIngredienteAlProducto(Ingrediente nuevoIngrediente, String nombreDelProducto);

    boolean productExists(String nombreProducto);

    boolean ingredienteExisteEnProducto(Ingrediente nuevoIngrediente, String nombreProducto);

    List<Producto> showAllProducts();

    List<Producto> showAllProductosSinCaducables();

    List<Producto> showAllProductsSortedName();

    List<Producto> showAllProductsConIngrediente();

    List<Producto> showAllProductsSinAlergiasCliente(String dniClient);

    List<String> showCantidadProductosOrdenadaPorLaMasComprada();

    int indexProduct(String nameProduct);
}
