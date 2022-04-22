package servicios.impl;

import dao.DaoProducto;
import dao.DaoProductoCaducable;
import jakarta.inject.Inject;
import modelo.producto.Ingrediente;
import modelo.producto.Producto;
import modelo.producto.ProductoCaducable;
import servicios.ServicioProductos;

import java.time.LocalDateTime;
import java.util.List;

public class ServicioProductosImpl implements ServicioProductos {

    private final DaoProducto daoProducto;
    private final DaoProductoCaducable daoProductoCaducable;

    @Inject
    public ServicioProductosImpl(DaoProducto daoProducto, DaoProductoCaducable daoProductoCaducable) {
        this.daoProducto = daoProducto;
        this.daoProductoCaducable = daoProductoCaducable;
    }

    @Override
    public boolean addProduct(Producto newProduct) {
        boolean contains = !daoProducto.productExists(newProduct.getName());
        if (contains && newProduct.getPrice() > 0 && newProduct.getStock() >= 0) {
            return daoProducto.addProducto(newProduct);
        }
        return false;
    }

    @Override
    public boolean removeProduct(String nombreProducto) {
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists) {
            return daoProducto.removeProducto(nombreProducto);
        }
        return false;
    }

    @Override
    public boolean updateNameProduct(String nombreProducto, String newNombreProducto) {
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists) {
            return daoProducto.updateNameProducto(nombreProducto, newNombreProducto);
        }
        return false;
    }

    @Override
    public boolean updatePriceProduct(String nombreProducto, double newPriceProducto) {
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists && newPriceProducto > 0) {
            return daoProducto.updatePriceProducto(nombreProducto, newPriceProducto);
        }
        return false;
    }

    @Override
    public boolean updateStockProduct(String nombreProducto, int newStockProducto) {
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists && newStockProducto >= 0) {
            return daoProducto.updateStockProducto(nombreProducto, newStockProducto);
        }
        return false;
    }

    @Override
    public List<Producto> showAllProducts() {
        return daoProducto.showAllProducts();
    }

    @Override
    public Producto getProductoLista(String productoAgregarCarrito) {
        return daoProducto.getProductoLista(productoAgregarCarrito);
    }

    @Override
    public boolean existProduct(String nombreProducto) {
        return daoProducto.productExists(nombreProducto);
    }

    @Override
    public boolean addProductCaducable(ProductoCaducable productoCaducable) {
        boolean exist = !existProduct(productoCaducable.getName());
        boolean caducidad = LocalDateTime.parse(productoCaducable.getCaducidad().toString())
                .isAfter(LocalDateTime.now());
        if (exist && caducidad) {
            return daoProductoCaducable.addProductoCaducable(productoCaducable);
        }
        return false;
    }


    @Override
    public List<Producto> showAllProductsSinCaducados() {
        return daoProducto.showAllProductosSinCaducables();
    }

    @Override
    public List<Producto> showAllProductsOrdenadosName() {
        return daoProducto.showAllProductsSortedName();
    }

    @Override
    public List<Producto> showAllProductsConIngredientes() {
        return daoProducto.showAllProductsConIngrediente();
    }

    @Override
    public boolean addIngredienteAlProducto(String nombreProducto, Ingrediente nuevoIngrediente) {
        int indexProduct = daoProducto.indexProduct(nombreProducto);
        boolean productoTieneEseIngrediente;
        if (indexProduct >= 0) {
            productoTieneEseIngrediente =
                    !daoProducto.ingredienteExisteEnProducto(nuevoIngrediente, nombreProducto);
            if (productoTieneEseIngrediente) {
                return daoProducto.addIngredienteAlProducto(nuevoIngrediente, nombreProducto);
            }
        }
        return false;
    }

    @Override
    public List<Producto> showAllProductsSinAlergiasCliente(String dniClient) {
        return daoProducto.showAllProductsSinAlergiasCliente(dniClient);
    }

    @Override
    public List<String> showAllProductsSortedCantidadComprada() {
        return daoProducto.showCantidadProductosOrdenadaPorLaMasComprada();
    }
}
