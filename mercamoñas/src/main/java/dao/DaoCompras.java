package dao;

import modelo.LineaCompra;
import modelo.Producto;

import java.util.List;

import static dao.BBDD.buyHistory;
import static dao.BBDD.carrito;


public class DaoCompras {

    public boolean alreadyInCart(Producto producto){
        return carrito.contains(new LineaCompra(producto));
    }

    public void addCart(Producto producto, int quantity) {
        carrito.add(new LineaCompra(producto, quantity));
    }

    public void deleteProductCart(Producto producto){
        carrito.remove(new LineaCompra(producto));
    }

    public void guardarCompra(List<LineaCompra> lineaCompras){
        buyHistory.add(lineaCompras);
    }

}
