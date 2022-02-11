package dao;

import modelo.LineaCompra;
import modelo.Producto;

import java.util.List;
import java.util.stream.Collectors;

import static dao.BBDD.clientes;


public class DaoCompras {

    public boolean alreadyInCart(Producto producto, String dniClient){
        return clientes.get(dniClient).getCarrito().contains(new LineaCompra(producto));
    }

    public void addCart(String dniClient, LineaCompra productoNuevoCarrito) {
        clientes.get(dniClient).getCarrito().add(productoNuevoCarrito);
    }

    public void deleteProductCart(String dniClient, String nombreProductoBorrar){
        clientes.get(dniClient).getCarrito().remove(new LineaCompra(new Producto(nombreProductoBorrar)));
    }

    public void guardarCompra(String dniClient, List<LineaCompra> lineaCompras){
        clientes.get(dniClient).getBuyHistory().add(lineaCompras);
    }

}
