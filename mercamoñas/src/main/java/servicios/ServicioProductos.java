package servicios;

import dao.DaoProducto;
import dao.DaoProductoCaducable;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.List;

public class ServicioProductos {

    public boolean addProduct(Producto newProduct) {
        DaoProducto daoProducto = new DaoProducto();
        boolean contains = !daoProducto.productExists(newProduct.getName());
        if (contains && newProduct.getPrice() > 0 && newProduct.getStock() >= 0) {
            daoProducto.addProducto(newProduct);
        }
        return contains;
    }

    public boolean removeProduct(String nombreProducto){
        DaoProducto daoProducto = new DaoProducto();
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists) {
            daoProducto.removeProducto(nombreProducto);
        }
        return exists;
    }

    public boolean updateNameProduct(String nombreProducto, String newNombreProducto){
        DaoProducto daoProducto = new DaoProducto();
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists) {
            daoProducto.updateNameProducto(nombreProducto, newNombreProducto);
        }
        return exists;
    }

    public boolean updatePriceProduct(String nombreProducto, double newPriceProducto){
        DaoProducto daoProducto = new DaoProducto();
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists && newPriceProducto > 0) {
            daoProducto.updatePriceProducto(nombreProducto, newPriceProducto);
        }
        return exists;
    }

    public boolean updateStockProduct(String nombreProducto, int newStockProducto){
        DaoProducto daoProducto = new DaoProducto();
        boolean exists = daoProducto.productExists(nombreProducto);
        if (exists && newStockProducto >= 0) {
            daoProducto.updateStockProducto(nombreProducto, newStockProducto);
        }
        return exists;
    }

    public List<Producto> showAllProducts(){
        DaoProducto daoProducto = new DaoProducto();
        return daoProducto.showAllProducts();
    }

    public Producto getProductoLista(String productoMeterCarrito){
        DaoProducto daoProducto = new DaoProducto();
        return daoProducto.getProductoLista(productoMeterCarrito);
    }

    public boolean existProduct(String nombreProducto){
        DaoProducto daoProducto = new DaoProducto();
        return daoProducto.productExists(nombreProducto);
    }

    public boolean addProductCaducable(ProductoCaducable productoCaducable){
        DaoProductoCaducable daoProductoCaducable = new DaoProductoCaducable();
        boolean exist = !existProduct(productoCaducable.getName());
        boolean caducidad = LocalDateTime.parse(productoCaducable.getCaducidad().toString()).isAfter(LocalDateTime.now());
        boolean sePuede = false;
        if(exist && caducidad){
            daoProductoCaducable.addProductoCaducable(productoCaducable);
            sePuede = true;
        }
        return sePuede;
    }


}
