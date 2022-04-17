package dao;

import modelo.Producto;
import modelo.ProductoCaducable;

import java.util.ArrayList;


public class DaoProductoCaducable {

  private ArrayList<Producto> productos;

  public DaoProductoCaducable(ArrayList<Producto> productos) {
    this.productos = productos;
  }

  public void addProductoCaducable(ProductoCaducable productoCaducable) {
    productos.add(new ProductoCaducable(productoCaducable.getName(), productoCaducable.getPrice(),
        productoCaducable.getStock(), productoCaducable.getCaducidad()));
  }
}
