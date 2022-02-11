package servicios;

import dao.DaoCompras;
import dao.DaoProducto;
import modelo.LineaCompra;
import modelo.Producto;

import java.util.List;



public class ServicioCompras {

    public boolean addToCart(Producto producto, int quantity) {
        DaoCompras daoCompras = new DaoCompras();
        DaoProducto daoProducto = new DaoProducto();
        boolean productExists = daoProducto.productExists(producto.getName());
        boolean inCart = !daoCompras.alreadyInCart(producto);
        if (inCart && productExists) {
            daoCompras.addCart(producto, quantity);

        }
        return inCart;
    }

    public boolean removeProductCart(Producto producto) {
        DaoCompras daoCompras = new DaoCompras();
        boolean isCart = daoCompras.alreadyInCart(producto);
        if (isCart) {
            daoCompras.deleteProductCart(producto);
        }
        return isCart;
    }

    public void guardarHistorialCompra(List<LineaCompra> lineaCompras){
        DaoCompras daoCompras = new DaoCompras();
        daoCompras.guardarCompra(lineaCompras);
    }

    public int precioCarrito(){
        DaoCompras daoCompras = new DaoCompras();
        return 1;
    }

    // public boolean pagarCarrito(){
    //   DaoProducto daoProducto = new DaoProducto();
    // boolean puedePagar = true;
    //if(puedePagar){
    //   daoProducto.updateStockProducto(producto.getName(), daoProducto.nuevoStock(producto,quantity));
    //  puedePagar = false;
    //}
    //return puedePagar;
    //}

}
