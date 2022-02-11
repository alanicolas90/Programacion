package servicios;

import dao.DaoClientes;
import dao.DaoCompras;
import dao.DaoProducto;
import modelo.LineaCompra;
import modelo.Producto;

import java.util.List;


public class ServicioCompras {

    public boolean addToCart(String dniClient, LineaCompra productoAddCarrito) {
        DaoCompras daoCompras = new DaoCompras();
        DaoProducto daoProducto = new DaoProducto();
        boolean seHaMetido= false;

        boolean productExists = daoProducto.productExists(productoAddCarrito.getProducto().getName());
        boolean inCart = !daoCompras.alreadyInCart(productoAddCarrito.getProducto(), dniClient);

        if (inCart && productExists) {
            daoCompras.addCart(dniClient, productoAddCarrito);
            seHaMetido = true;
        }
        return seHaMetido;
    }

    public boolean removeProductCart(String dniClient, String nombreProductoBorrar) {
        DaoCompras daoCompras = new DaoCompras();
        boolean isCart = daoCompras.alreadyInCart(new Producto(nombreProductoBorrar), dniClient);
        if (isCart) {
            daoCompras.deleteProductCart(dniClient, nombreProductoBorrar);
        }
        return isCart;
    }

    public void guardarHistorialCompra(String dniClient, List<LineaCompra> lineaCompras) {
        DaoCompras daoCompras = new DaoCompras();
        daoCompras.guardarCompra(dniClient, lineaCompras);
    }

    public int precioCarrito() {
        DaoCompras daoCompras = new DaoCompras();
        return 1;
    }

    public List<List<LineaCompra>> showBuyHistory(String dniClient){
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.showBuyHistory(dniClient);
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
