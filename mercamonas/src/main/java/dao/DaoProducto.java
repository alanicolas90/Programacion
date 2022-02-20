package dao;

import modelo.Ingrediente;
import modelo.LineaCompra;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static dao.BBDD.clientes;
import static dao.BBDD.productos;

public class DaoProducto {

    public boolean productExists(String nombreProducto) {
        return productos.contains(new Producto(nombreProducto));
    }

    public void addProducto(Producto newProducto) {
        productos
                .add(new Producto(newProducto.getName(), newProducto.getPrice(), newProducto.getStock()));
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

    public Producto getProductoLista(String productoMeterCarrito) {
        return productos.get(productos.indexOf(new Producto(productoMeterCarrito)));
    }

    public double getPriceProducto(String nameProduct) {
        int productoBusco = productos.indexOf(new Producto(nameProduct));
        return productos.get(productoBusco).getPrice();
    }

    public int getStockProduct(String nombreProduct) {
        int positionProductoBusco = productos.indexOf(new Producto(nombreProduct));
        return productos.get(positionProductoBusco).getStock();
    }


    //-----------------------------------------------------------------------------------------------------------------------------------
    //VER PRODUCTOS

    public List<Producto> showAllProducts() {
        return productos.stream()
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> showAllProductosSinCaducables() {
        return productos.stream()
                .filter(producto -> {
                    boolean noEstaCaducado = false;
                    if (!(producto instanceof ProductoCaducable)) noEstaCaducado = true;
                    else if (((ProductoCaducable) producto).getCaducidad().isAfter(LocalDateTime.now()))
                        noEstaCaducado = true;
                    return noEstaCaducado;
                }).map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> showAllProductsSortedName() {
        return productos.stream()
                .sorted(Comparator.comparing(Producto::getName))
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> showAllProductsConIngrediente() {
        return productos.stream()
                .filter(producto -> !producto.getIngredientes().isEmpty())
                .map(Producto::clone)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean ingredienteExisteEnProducto(String nombreProducto, Ingrediente nuevoIngrediente, int index) {
        return productos.get(index).getIngredientes().contains(nuevoIngrediente);
    }

    public void addIngredienteAlProducto(String nombreProducto, Ingrediente nuevoIngrediente, int index) {
        productos.get(index).getIngredientes().add(new Ingrediente(nuevoIngrediente.getNombre()));

    }

    //index de un producto por su nombrer
    public int indexProduct(String nameProduct){
        return productos.indexOf(new Producto(nameProduct));
    }
}
