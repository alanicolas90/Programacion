package servicios;

import dao.DaoProducto;
import modelo.Producto;

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
}
