package dao.clientes;

import dao.DaoClientes;
import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientesTest {


    @Test
    void addCliente() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        DaoClientes daoClientes = new DaoClientes(clientes);
        //WHEN
        daoClientes.addClient(new Cliente("111", "alain"));

        //THEN
        assertIterableEquals(clientes.values(),
                List.of(new Cliente("111", "alain")));
    }


    @Test
    void removeCliente() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        clientes.put("112", new Cliente("112", "alain2"));

        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        daoClientes.removeClient("111");
        //Then
        assertIterableEquals(clientes.values(), List.of(new Cliente("112", "alain2")));
    }


    @Test
    void swapNameClient() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        daoClientes.swapNameClient("111", "eren");
        //Then
        assertIterableEquals(clientes.values(), List.of(new Cliente("111", "eren")));
    }


    @Test
    void swapDni() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        daoClientes.swapDni("111", "001");
        //Then
        assertIterableEquals(clientes.values(), List.of(new Cliente("001", "alain")));
    }

    @Test
    void dineroDelMonederoCliente() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        clientes.get("111").getMonederos().add(new Monedero("ale", 1000));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        double dineroClienteMonedero = daoClientes.getTodoDineroMonedero("111", "ale");
        //Then
        assertEquals(1000, dineroClienteMonedero);

    }

    @Test
    void descuentoClienteSeleccionado() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new ClienteDescuento("111", "alain", 25));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        double descuentoClienteProbar = daoClientes.getDescuentoCliente("111");
        //Then
        assertEquals(25, descuentoClienteProbar);
    }

    @Test
    void costeCompra() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        clientes.put("111", new Cliente("111", "alain"));
        LineaCompra c = new LineaCompra(new Producto("zanahoria", 2, 200), 10);
        clientes.get("111").setBuyHistory(new ArrayList<>());
        clientes.get("111").getBuyHistory().add(List.of(c));

        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        double costeCompraProbar = daoClientes.getCosteCompras(clientes.get("111"));
        //Then
        assertEquals(20, costeCompraProbar);

    }

    @Test
    void comprobarEsClienteDescuentoYLoEs() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        clientes.put("111", new ClienteDescuento("111", "alain", 25));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertTrue(daoClientes.clienteTieneDescuento("111"));
    }

    @Test
    void comprobarEsClienteDescuentoYNoLoEs() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        clientes.put("111", new Cliente("111", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertFalse(daoClientes.clienteTieneDescuento("111"));
    }

    @Test
    void clienteExiste() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertTrue(daoClientes.existClient("111"));
    }

    @Test
    void clienteNoExiste() {

        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertFalse(daoClientes.existClient("112"));
    }

    @Test
    void vaciaCarrito() {

        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        clientes.get("111").getCarrito().add(new LineaCompra(new Producto("zanahoria")));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        daoClientes.emptyCart("111");
        //Then
        assertIterableEquals(List.of(new Cliente("111", "alain")), clientes.values());
    }

    @Test
    void addIngredienteAlergiaCliente() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        List<Ingrediente> ingredientes = List.of(new Ingrediente("coca"));

        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        daoClientes.addIngredienteAlergia("111", "coca");
        //Then
        assertIterableEquals(clientes.values(), List.of(new Cliente("111", "alain", ingredientes)));

    }

    @Test
    void ingredienteExisteCliente() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        clientes.get("111").getAlergenos().add(new Ingrediente("coca"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);

        //Then
        assertTrue(daoClientes.ingredienteExisteCliente("111", "coca"));

    }

    @Test
    void ingredienteNoExisteCliente() {
//Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        clientes.get("111").getAlergenos().add(new Ingrediente("coca"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);

        //Then
        assertFalse(daoClientes.ingredienteExisteCliente("111", "harina"));
    }

    @Test
    void tieneComprasAnterioresIsEmpty() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        List<LineaCompra> listaConProductos = List.of(new LineaCompra(new Producto("a")));
        clientes.get("111").getBuyHistory().add(listaConProductos);
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertFalse(daoClientes.tieneComprasAnterioresIsEmpty("111"));
    }

    @Test
    void tieneComprasAnterioresNoIsEmpty() {
//Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertTrue(daoClientes.tieneComprasAnterioresIsEmpty("111"));
    }

    @Test
    void listaClientesOrdenadoPorDineroGastado() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        clientes.put("111", new Cliente("111", "alain"));
        clientes.put("123", new Cliente("123", "alan"));
        //WHEN
        DaoClientes daoClientes = new DaoClientes(clientes);
        List<Cliente> clientesOrdenadosProbar = daoClientes.showListaClientesSortedDineroGastado();

        //THEN
        assertIterableEquals(clientesOrdenadosProbar,
                List.of(new Cliente("111", "alain"), new Cliente("123", "alan")));
    }

    @Test
    void getLineaCompras() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        List<LineaCompra> lineaCompra = List.of(new LineaCompra(new Producto("zanahoria"), 15));
        clientes.get("111").getBuyHistory().add(lineaCompra);

        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        List<LineaCompra> lineaCompraComprobar = daoClientes.getLineaCompra("111", 0);
        //Then
        assertIterableEquals(lineaCompraComprobar, List.of(new LineaCompra(new Producto("zanahoria"), 15)));
    }


    @Test
    void historialComprasDeUnCliente() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));

        List<LineaCompra> lineaCompra = List.of(new LineaCompra(new Producto("zanahoria")),
                new LineaCompra(new Producto("coca"), 10));

        clientes.get("111").getBuyHistory().add(lineaCompra);
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);

        //Then
        assertIterableEquals(daoClientes.showBuyHistory("111"), List.of(lineaCompra));
    }

    @Test
    void listaClientesOrdenadoPorDni() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("112", new Cliente("112", "alain"));
        clientes.put("111", new Cliente("111", "alain"));
        clientes.put("120", new Cliente("120", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        //Then
        assertIterableEquals(daoClientes.showListaClientesOrdenadaDni(),
                List.of(new Cliente("111", "alain"),
                        new Cliente("112", "alain"),
                        new Cliente("120", "alain")));
    }

    @Test
    void listaClientes() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("112", new Cliente("112", "alain"));
        clientes.put("111", new Cliente("111", "alain"));
        clientes.put("120", new Cliente("120", "alain"));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        List<Cliente> clientesProbar = daoClientes.verListaClientes();
        //Then
        assertIterableEquals(clientesProbar,
                List.of(new Cliente("112", "alain"),
                        new Cliente("111", "alain"),
                        new Cliente("120", "alain")));
    }

    @Test
    void carritoClienteEspecifico() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("112", new Cliente("112", "alain"));
        clientes.get("112").getCarrito().add(new LineaCompra(new Producto("zanahoria")));
        clientes.get("112").getCarrito().add(new LineaCompra(new Producto("coca")));

        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        List<LineaCompra> caritoClienteProbar = daoClientes.dameCarrito("112");

        //Then
        assertIterableEquals(caritoClienteProbar,
                List.of(new LineaCompra(new Producto("zanahoria")),
                        new LineaCompra(new Producto("coca"))));
    }

    @Test
    void verClienteEspecifico() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("112", new Cliente("112", "alain"));

        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        Cliente c = daoClientes.seeSpecificClient("112");

        //Then
        assertEquals(c, new Cliente("112", "alain"));

    }

    @Test
    void verClienteConDescuento() {
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("112", new ClienteDescuento("112", "alain",20));
        //When
        DaoClientes daoClientes = new DaoClientes(clientes);
        ClienteDescuento c = daoClientes.seeSpecificClientDescuento("112");
        //Then
        assertEquals(c,new ClienteDescuento("112", "alain",20));
    }

}
