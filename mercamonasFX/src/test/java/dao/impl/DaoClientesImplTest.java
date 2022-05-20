package dao.impl;

import dao.BBDD;
import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.ClienteNormal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DaoClientesImplTest {

    //class under test
    @InjectMocks
    DaoClientesImpl daoClientes;

    //mocks
    @Mock
    BBDD db;

    @Captor
    ArgumentCaptor<Map<String, Cliente>> captor;


    @Test
    void addClientNormal() {
        //given
        Cliente cliente = new ClienteNormal( "dni","name");
        when(db.loadClientes()).thenReturn(new HashMap<>());
        Map<String, Cliente> map = new HashMap<>();
        doAnswer(invocation -> {
            map.putAll(invocation.getArgument(0));
            return null;
        }).when(db).saveClientes(anyMap());

        //when
        daoClientes.addClient(cliente);


        assertAll(() -> assertThat(map).containsEntry("dni", cliente),
                () -> {
                    verify(db).saveClientes(captor.capture());
                    Map<String, Cliente> clientes = captor.getValue();
                    assertThat(clientes).containsEntry("dni", cliente);
                }
        );
    }

    @Test
    void removeClient() {
    }

    @Test
    void swapNameClient() {
    }

    @Test
    void swapDni() {
    }

    @Test
    void getTodoDineroMonedero() {
    }

    @Test
    void getMonederosCliente() {
    }

    @Test
    void getDescuentoCliente() {
    }

    @Test
    void getCosteCompras() {
    }

    @Test
    void clienteTieneDescuento() {
    }

    @Test
    void existClient() {
    }

    @Test
    void emptyCart() {
    }

    @Test
    void addIngredienteAlergia() {
    }

    @Test
    void ingredienteExisteCliente() {
    }

    @Test
    void tieneComprasAnteriores() {
    }

    @Test
    void showListaClientesSortedDineroGastado() {
    }

    @Test
    void getLineaCompra() {
    }

    @Test
    void showBuyHistory() {
    }

    @Test
    void showListaClientesOrdenadaDni() {
    }

    @Test
    void verListaClientes() {
    }

    @Test
    void showClientes() {
    }

    @Test
    void dameCarrito() {
    }

    @Test
    void seeSpecificClient() {
    }

    @Test
    void seeSpecificClientDescuento() {
    }
}