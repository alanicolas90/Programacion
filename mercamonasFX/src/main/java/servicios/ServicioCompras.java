package servicios;

import modelo.cliente.LineaCompra;

import java.util.List;

public interface ServicioCompras {
    boolean addToCart(String dniClient, LineaCompra productoAddCarrito);

    boolean removeProductCart(String dniClient, String nombreProductoBorrar);

    void guardarHistorialCompra(String dniClient);

    List<List<LineaCompra>> showBuyHistory(String dniClient);

    boolean pagarCarrito(String dniClient, String nombreMonedero);
}
