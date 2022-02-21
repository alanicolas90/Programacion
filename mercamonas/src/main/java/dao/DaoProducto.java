package dao;

import modelo.Ingrediente;
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
    return productos.get(productoBusco).clone().getPrice();
  }

  public int getStockProduct(String nombreProduct) {
    int positionProductoBusco = productos.indexOf(new Producto(nombreProduct));
    return productos.get(positionProductoBusco).clone().getStock();
  }


  // -----------------------------------------------------------------------------------------------------------------------------------
  // VER PRODUCTOS

  public List<Producto> showAllProducts() {
    return productos.stream().map(Producto::clone).collect(Collectors.toUnmodifiableList());
  }

  public List<Producto> showAllProductosSinCaducables() {
    return productos.stream().filter(producto -> {
      boolean noEstaCaducado = false;
      if (!(producto instanceof ProductoCaducable)
          || ((ProductoCaducable) producto).getCaducidad().isAfter(LocalDateTime.now()))
        noEstaCaducado = true;
      return noEstaCaducado;
    }).map(Producto::clone).collect(Collectors.toUnmodifiableList());
  }

  public List<Producto> showAllProductsSortedName() {
    return productos.stream().sorted(Comparator.comparing(Producto::getName)).map(Producto::clone)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<Producto> showAllProductsConIngrediente() {
    return productos.stream().filter(producto -> !producto.getIngredientes().isEmpty())
        .map(Producto::clone).collect(Collectors.toUnmodifiableList());
  }

  public boolean ingredienteExisteEnProducto(Ingrediente nuevoIngrediente, int index) {
    return productos.get(index).clone().getIngredientes().contains(nuevoIngrediente);
  }

  public void addIngredienteAlProducto(Ingrediente nuevoIngrediente, int index) {
    productos.get(index).getIngredientes().add(new Ingrediente(nuevoIngrediente.getNombre()));

  }

  public List<Producto> showAllProductsSinAlergiasCliente(String dniClient) {
    return productos.stream()
        .filter(
            producto -> !producto.getIngredientes().equals(clientes.get(dniClient).getAlergenos()))
        .map(Producto::clone).collect(Collectors.toUnmodifiableList());

  }

  // index de un producto por su nombre
  public int indexProduct(String nameProduct) {
    return productos.indexOf(new Producto(nameProduct));
  }

  public List<Producto> showAllProductsSortedCantidadComprada() {
    return productos;
  }
}
