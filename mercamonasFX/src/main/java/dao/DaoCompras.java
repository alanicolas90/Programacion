package dao;

import modelo.cliente.LineaCompra;

import java.util.List;

public interface DaoCompras {
    boolean alreadyInCart(String nombreProducto, String dniClient);

    void addCart(String dniClient, LineaCompra productoNuevoCarrito);

    void deleteProductCart(String dniClient, String nombreProductoBorrar);

    void guardarCompra(String dniClient, List<LineaCompra> lineaCompras);

    void cambiarStockComprar(String nombreProducto, int cantidadStockRestar);

    void ajustarDineroMonederoAfterCompra(String dniClient, String nombreMonedero, double dineroRestante);
}
