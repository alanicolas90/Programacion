package dao.compras;

import dao.DaoClientes;
import dao.DaoCompras;
import modelo.Cliente;
import modelo.LineaCompra;
import modelo.Monedero;
import modelo.Producto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

import static org.junit.jupiter.api.Assertions.*;

class DaoComprasTest {

    @Test
    void alreadyInCartYEsta() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        Producto p = new Producto("coca");

        clientes.get("111").getCarrito().add(new LineaCompra(p, 10));
        //WHEN
        DaoCompras daoCompras = new DaoCompras(clientes);
        boolean estaEnCarrito = daoCompras.alreadyInCart(p, "111");
        //THEN
        assertTrue(estaEnCarrito);
    }

    @Test
    void alreadyInCartYNoEsta() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        Producto p = new Producto("coca");
        //WHEN
        DaoCompras daoCompras = new DaoCompras(clientes);
        boolean estaEnCarrito = daoCompras.alreadyInCart(p, "111");
        //THEN
        assertFalse(estaEnCarrito);
    }

    @Test
    void addCart() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        LineaCompra lineaCompra = new LineaCompra(new Producto("coca"), 10);

        //WHEN
        DaoCompras daoCompras = new DaoCompras(clientes);
        daoCompras.addCart("111", lineaCompra);

        //THEN
        assertIterableEquals(clientes.get("111").getCarrito(), List.of(lineaCompra));
    }

    @Test
    void deleteProductCart() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        LineaCompra lineaCompra = new LineaCompra(new Producto("coca"), 10);
        LineaCompra lineaCompra2 = new LineaCompra(new Producto("cocaina"), 10);

        clientes.get("111").getCarrito().add(lineaCompra);
        clientes.get("111").getCarrito().add(lineaCompra2);

        //WHEN
        DaoCompras daoCompras = new DaoCompras(clientes);
        daoCompras.deleteProductCart("111", "cocaina");

        //THEN
        assertIterableEquals(clientes.get("111").getCarrito(), List.of(lineaCompra));
    }

    @Test
    void guardarCompraEnHistorialCompras() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        List<LineaCompra> lineaCompra = List.of(new LineaCompra(new Producto("coca"), 10));
        //WHEN
        DaoCompras daoCompras = new DaoCompras(clientes);
        daoCompras.guardarCompra("111", lineaCompra);

        //THEN
        assertIterableEquals(List.of(lineaCompra), clientes.get("111").getBuyHistory());
    }

    @Test
    void cambiarStockComprar() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("coca", 20, 1000));
        //WHEN
        DaoCompras daoCompras = new DaoCompras(productos);
        daoCompras.cambiarStockComprar("coca", 250);

        //THEN
        assertIterableEquals(productos, List.of(new Producto("coca", 20, 750)));
    }

    @Test
    void ajustarDineroMonederoAfterCompra() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        clientes.get("111").getMonederos().add(new Monedero("ale", 500));
        //WHEN
        DaoCompras daoCompras = new DaoCompras(clientes);
        daoCompras.ajustarDineroMonederoAfterCompra("111","ale",200);

        //THEN
        Cliente c = new Cliente("111", "alain");
        c.getMonederos().add(new Monedero("ale", 300));

        assertEquals(c.getMonederos(), clientes.get("111").getMonederos());
    }
}