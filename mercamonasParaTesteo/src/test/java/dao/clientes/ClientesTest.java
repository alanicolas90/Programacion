package dao.clientes;

import dao.DaoClientes;
import modelo.Cliente;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientesTest {


    @Test
    void addCliente(){
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
    void removeCliente(){
        //Given
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111","alain"));
        clientes.put("112", new Cliente("112","alain2"));

        DaoClientes daoClientes = new DaoClientes(clientes);
        //When
        daoClientes.removeClient("111");
        //Then
        assertIterableEquals(clientes.values(), List.of(new Cliente("112","alain2")));
    }


    @Test
    void swapNameClient(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }


    @Test
    void swapDni(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }
    @Test
    void dineroDelMonederoCliente(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void descuentoClienteSeleccionado(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void costeCompra(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void comprobarEsClienteDescuento(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void comprobarNoEsClienteDescuento(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void clienteExiste(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void clienteNoExiste(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void vaciaCarrito(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void addIngredienteAlergiaCliente(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void ingredienteExisteCliente(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void ingredienteNoExisteCliente(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void clienteTieneComprasAnteriores(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void clienteNoTieneComprasAnteriores(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void listaClientesOrdenadoPorDineroGastado(){
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        clientes.put("111", new Cliente("111", "alain"));
        clientes.put("123", new Cliente("123", "alan"));

        DaoClientes daoClientes = new DaoClientes(clientes);

        //WHEN
        List<Cliente> clientesOrdenadosProbar = daoClientes.showListaClientesSortedDineroGastado();

        //THEN
        assertIterableEquals(clientesOrdenadosProbar,
                List.of(new Cliente("111", "alain"),new Cliente("123", "alan")));
    }

    @Test
    void getLineaCompras(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }


    @Test
    void historialComprasDeUnCliente(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void listaClientesOrdenadoPorDni(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void listaClientes(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void carritoClienteEspecifico(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void verClienteEspecifico(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

    @Test
    void historialCompraCliente(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }
    @Test
    void verClienteConDescuento(){

        //Given
        //When
        //Then
//        assertTrue();
//        assertFalse();
//        assertEquals();
//        assertNull();
    }

}
