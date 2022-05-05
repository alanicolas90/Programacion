package dao.impl;

import dao.BBDD;
import dao.DaoCompras;
import jakarta.inject.Inject;
import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.LineaCompra;
import domain.modelo.cliente.Monedero;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoNormal;

import java.util.List;
import java.util.Map;


public class DaoComprasImpl implements DaoCompras {

    private final BBDD db;

    @Inject
    public DaoComprasImpl(BBDD db) {
        this.db = db;
    }


    @Override
    public boolean alreadyInCart(String nombreProducto, String dniClient) {
        Map<String, Cliente> clientes = db.loadClientes();
        Cliente clienteQueBuscamos = clientes.values().stream().filter(cliente -> cliente.getNombre().equals(dniClient)).findFirst().orElse(null);
        if (clienteQueBuscamos != null) {
            LineaCompra productoQueBuscamos = clienteQueBuscamos.getCarrito().stream().filter(lineaCompra -> lineaCompra.getProducto().equals(nombreProducto)).findFirst().orElse(null);
            return productoQueBuscamos != null;
        }
        return false;
    }

    @Override
    public void addCart(String dniClient, LineaCompra productoNuevoCarrito) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).getCarrito().add(productoNuevoCarrito);
        db.saveClientes(clientes);
    }

    @Override
    public void deleteProductCart(String dniClient, String nombreProductoBorrar) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).getCarrito()
                .remove(new LineaCompra(new ProductoNormal(nombreProductoBorrar)));
        db.saveClientes(clientes);
    }

    @Override
    public void guardarCompra(String dniClient, List<LineaCompra> lineaCompras) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).getBuyHistory().add(lineaCompras);
        db.saveClientes(clientes);
    }

    @Override
    public void cambiarStockComprar(String nombreProducto, int cantidadStockRestar) {
        List<Producto> productos = db.loadProducto();
        int positionProductoBusco = productos.indexOf(new ProductoNormal(nombreProducto));
        productos.get(positionProductoBusco)
                .setStock((productos.get(positionProductoBusco).getStock()) - cantidadStockRestar);
        db.saveProducto(productos);
    }

    @Override
    public void ajustarDineroMonederoAfterCompra(String dniClient, String nombreMonedero, double dineroRestante) {
        Map<String, Cliente> clientes = db.loadClientes();
        clientes.get(dniClient).getMonederos().forEach(monedero -> {
            if (monedero.equals(new Monedero(nombreMonedero))) {
                monedero.setMoney(dineroRestante);
            }
        });
        db.saveClientes(clientes);
    }


}
