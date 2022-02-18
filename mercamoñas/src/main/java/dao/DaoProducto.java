package dao;

import modelo.Producto;

import java.util.List;
import java.util.stream.Collectors;

import static dao.BBDD.productos;

public class DaoProducto {

    public boolean productExists(String nombreProducto) {
        return productos.contains(new Producto(nombreProducto));
    }

    public void addProducto(Producto newProducto) {
        productos.add(new Producto(newProducto.getName(), newProducto.getPrice(), newProducto.getStock()));
    }

    public void removeProducto(String nombreProducto) {
        productos.remove(new Producto(nombreProducto));
    }

    public void updateNameProducto(String nombreProducto, String newNombreProducto) {
        int index = productos.indexOf(new Producto(nombreProducto));
        productos.get(index).setName(newNombreProducto);
    }

    public void updatePriceProducto(String nombreProducto, double newPriceProducto) {
        int index = productos.indexOf(new Producto(nombreProducto));
        productos.get(index).setPrice(newPriceProducto);
    }

    public void updateStockProducto(String nombreProducto, int newStockProducto) {
        int index = productos.indexOf(new Producto(nombreProducto));
        productos.get(index).setStock(newStockProducto);
    }

    public List<Producto> showAllProducts() {
        return productos.stream()
                .map(producto -> new Producto(producto.getName(), producto.getPrice(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Producto getProductoLista(String productoMeterCarrito) {
        return productos.get(productos.indexOf(new Producto(productoMeterCarrito)));
    }

    public double getPriceProducto(String nameProduct) {
        int productoBusco = productos.indexOf(new Producto(nameProduct));
        return productos.get(productoBusco).getPrice();
    }

    public int getStockProduct(String nombreProduct){
        int positionProductoBusco= productos.indexOf(new Producto(nombreProduct));
        return productos.get(positionProductoBusco).getStock();
    }

    public List<Producto> showAllProductosSinCaducables(){
return null;
    }


}
