package dao.impl;

import dao.BBDD;
import dao.DaoProductoCaducable;
import jakarta.inject.Inject;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoCaducable;

import java.util.List;

public class DaoProductoCaducableImpl implements DaoProductoCaducable {

  private final BBDD db;

  @Inject
  public DaoProductoCaducableImpl(BBDD db) {
    this.db = db;
  }

  @Override
  public boolean addProductoCaducable(ProductoCaducable productoCaducable) {

    List<Producto> productos = db.loadProducto();

    productos.add(productoCaducable);

    return db.saveProducto(productos);
  }
}
