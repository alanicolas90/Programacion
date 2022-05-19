package servicios.impl;

import dao.impl.DaoClientesImpl;
import dao.impl.DaoMonederoImpl;
import dao.impl.DaoProductoImpl;
import domain.modelo.cliente.*;
import domain.modelo.producto.ProductoNormal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ServicioClientsImplTest {

    //class under test
    @InjectMocks
    ServicioClientsImpl servicioClients;
    @Mock
    DaoClientesImpl daoClientes;
    @Mock
    DaoProductoImpl daoProducto;
    @Mock
    DaoMonederoImpl daoMonedero;




    @Nested
    @DisplayName("Test de adds")
    class add{
        @Test
        void addClient() {
            //given
            Cliente c = new ClienteNormal("dni","nombre");
            when(daoClientes.addClient(c)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addClient(c);
            //then
            assertThat(respuesta).isTrue();
        }@Test
        void addClientPeroDaoFalse() {
            //given
            Cliente c = new ClienteNormal("dni","nombre");
            when(daoClientes.existClient(c.getDni())).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addClient(c);
            //then
            assertThat(respuesta).isFalse();
        }
        @Test
        void addMoney() {
            //given
            String dni = "dni";
            String nombreTarjeta = "nombreTarjeta";
            double dineroAgregar = 10.0;
            when(daoMonedero.monederoExists(nombreTarjeta,dni)).thenReturn(true);
            when(daoMonedero.addMoneyMonedero(dni,nombreTarjeta,dineroAgregar)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addMoney(dni,nombreTarjeta,dineroAgregar);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void addMoneyNoExisteMonedero() {
            //given
            String dni = "dni";
            String nombreTarjeta = "nombreTarjeta";
            double dineroAgregar = 10.0;
            when(daoMonedero.monederoExists(nombreTarjeta,dni)).thenReturn(false);
            //when
            boolean respuesta = servicioClients.addMoney(dni,nombreTarjeta,dineroAgregar);
            //then
            assertThat(respuesta).isFalse();
        }

        @Test
        void addMonedero() {
            //given
            String dni = "dni";
            Monedero monedero = new Monedero("nombreTarjeta");
            when(!daoMonedero.monederoExists(monedero.getName(), dni)).thenReturn(false);
            when(daoMonedero.addMonedero(monedero, dni)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addMonedero(monedero,dni);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void addMonederoMonederoNoExiste() {
            //given
            String dni = "dni";
            Monedero monedero = new Monedero("nombreTarjeta");
            when(!daoMonedero.monederoExists(monedero.getName(), dni)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addMonedero(monedero,dni);
            //then
            assertThat(respuesta).isFalse();
        }
        @Test
        void addIngredienteAlergia() {
            //given
            String dni = "dni";
            String nombreIngrediente = "nombreIngrediente";
            Map<String,Cliente> clientes = new HashMap<>();

            when(!daoClientes.ingredienteExisteCliente(dni, nombreIngrediente)).thenReturn(false);
            //when(daoClientes.addIngredienteAlergia(dni,nombreIngrediente)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addIngredienteAlergia(dni,nombreIngrediente);
            //then
            assertThat(respuesta).isTrue();
            verify(daoClientes).addIngredienteAlergia(dni,nombreIngrediente);
        }
        @Test
        void addIngredienteAlergiaExiste() {
            //given
            String dni = "dni";
            String nombreIngrediente = "nombreIngrediente";

            when(!daoClientes.ingredienteExisteCliente(dni, nombreIngrediente)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.addIngredienteAlergia(dni,nombreIngrediente);
            //then
            assertThat(respuesta).isFalse();
        }
    }

    @Nested
    @DisplayName("Test de removes y swaps")
    class remove{
        @Test
        void removeClientExiste() {
            //given
            String dni = "dni";
            when(daoClientes.existClient(dni)).thenReturn(true);
            when(daoClientes.removeClient(dni)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.removeClient(dni);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void removeClientNoExiste() {
            //given
            String dni = "dni";
            when(daoClientes.existClient(dni)).thenReturn(false);
            //when
            boolean respuesta = servicioClients.removeClient(dni);
            //then
            assertThat(respuesta).isFalse();
        }

        @Test
        void removeMonederoExiste() {
            //given
            String nombreTarjeta = "nombreTarjeta";
            String dni = "dni";
            when(daoMonedero.monederoExists(nombreTarjeta,dni)).thenReturn(true);
            when(daoMonedero.removeMonedero(dni, nombreTarjeta)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.removeMonedero(nombreTarjeta,dni);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void removeMonederoNoExiste() {
            //given
            String nombreTarjeta = "nombreTarjeta";
            String dni = "dni";
            when(daoMonedero.monederoExists(nombreTarjeta,dni)).thenReturn(false);
            //when
            boolean respuesta = servicioClients.removeMonedero(nombreTarjeta,dni);
            //then
            assertThat(respuesta).isFalse();
        }
        @Test
        void swapNameClientExiste() {
            //given
            String dni = "dni";
            String nombre = "nombre";
            String nuevoNombre = "nuevoNombre";
            Cliente c = new ClienteNormal(dni, nombre);

            when(daoClientes.existClient(c.getDni())).thenReturn(true);
            when(daoClientes.swapNameClient(c, nuevoNombre)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.swapNameClient(c,nuevoNombre);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void swapNameClientNoExiste() {
            //given
            String dni = "dni";
            String nombre = "nombre";
            String nuevoNombre = "nuevoNombre";
            Cliente c = new ClienteNormal(dni, nombre);

            when(daoClientes.existClient(c.getDni())).thenReturn(false);
            //when
            boolean respuesta = servicioClients.swapNameClient(c,nuevoNombre);
            //then
            assertThat(respuesta).isFalse();
        }

        @Test
        void swapDniExiste() {
            //given
            String dni = "dni";
            String nuevoDni = "nuevoDni";
            when(daoClientes.existClient(dni)).thenReturn(true);
            when(daoClientes.swapDni(dni, nuevoDni)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.swapDni(dni,nuevoDni);
            //then
            assertThat(respuesta).isTrue();

        }
        @Test
        void swapDniNoExiste() {
            //given
            String dni = "dni";
            String nuevoDni = "nuevoDni";
            when(daoClientes.existClient(dni)).thenReturn(false);
            //when
            boolean respuesta = servicioClients.swapDni(dni,nuevoDni);
            //then
            assertThat(respuesta).isFalse();

        }
    }


    @Nested
    @DisplayName("Test de comprobaciones")
    class comprobaciones{
        @Test
        void existeCliente() {
            //given
            String dni= "12345678A";
            when(daoClientes.existClient(dni)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.existeCliente(dni);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void noExisteCliente() {
            //given
            String dni= "12345678A";
            when(daoClientes.existClient(dni)).thenReturn(false);
            //when
            boolean respuesta = servicioClients.existeCliente(dni);
            //then
            assertThat(respuesta).isFalse();
        }

        @Test
        void tieneComprasAnteriores() {
            //given
            String dni= "12345678A";
            when(daoClientes.tieneComprasAnteriores(dni)).thenReturn(true);
            //when
            boolean respuesta = servicioClients.tieneComprasAnteriores(dni);
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void noTieneComprasAnteriores() {
            //given
            String dni= "12345678A";
            when(daoClientes.tieneComprasAnteriores(dni)).thenReturn(false);
            //when
            boolean respuesta = servicioClients.tieneComprasAnteriores(dni);
            //then
            assertThat(respuesta).isFalse();
        }

    }

    //como hacer un when con un map
    @Test
    void showListClients() {
        //given
        String dni = "12345678A";
        Cliente c = new ClienteNormal(dni);
        List<Cliente> clientes = List.of(c);
        when(daoClientes.showClientes()).thenReturn(clientes);
        //when
        List<Cliente> resultado = servicioClients.showListClients();
        //then
        assertThat(clientes).asList().contains(c);
    }

    @Test
    void getListClientes() {
        //given
        Cliente c = new ClienteNormal("12345678A","Pepe");
        when(daoClientes.showClientes()).thenReturn(List.of(c));
        //when
        List<Cliente> lista = servicioClients.getListClientes();
        //then
        assertThat(lista).asList().contains(c);
    }

    @Test
    void showTarjetasCliente() {
        //given
        String dni = "12345678A";
        Set<Monedero> monederos = new HashSet<>(List.of(new Monedero(dni,0.0)));
        when(daoMonedero.showTarjetasCliente(dni)).thenReturn(monederos);
        //when
        Set<Monedero> set = servicioClients.showTarjetasCliente(dni);

        //then
        assertThat(set).matches(monederos::containsAll);
    }

    @Test
    void verDataClienteDescuento() {
        //given
        String dni = "12345678A";
        ClienteDescuento c = new ClienteDescuento(dni,"Pepe",20);
        when(daoClientes.clienteTieneDescuento(dni)).thenReturn(true);
        when(daoClientes.seeSpecificClientDescuento(dni)).thenReturn(c);
        //when
        Cliente a = servicioClients.verDataCliente(dni);
        //then
        assertThat(a.getType()).isEqualTo(c.getType());
    }
    @Test
    void verDataClienteNormal() {
        //given
        String dni = "12345678A";
        Cliente c = new ClienteNormal(dni,"Pepe");
        when(daoClientes.clienteTieneDescuento(dni)).thenReturn(false);
        when(daoClientes.seeSpecificClient(dni)).thenReturn(c);
        //when
        Cliente a = servicioClients.verDataCliente(dni);
        //then
        assertThat(a.getType()).isEqualTo(c.getType());
    }

    @Test
    void showCarrito() {
        //given
        String dni = "12345678A";
        LineaCompra l = new LineaCompra(new ProductoNormal("12345678A",15,10),2);
        when(daoClientes.dameCarrito(dni)).thenReturn(List.of(l));
        //when
        List<LineaCompra> list= servicioClients.showCarrito(dni);
        //then
        assertThat(list).asList().contains(l);
    }

    @Test
    void getTotalPrice() {
        //given
        //when
        //then
    }

    @Test
    void showListClientsSortedDni() {
        //given
        Cliente c = new ClienteNormal("12345678A","Pepe");
        when(daoClientes.showListaClientesOrdenadaDni()).thenReturn(List.of(c));
        //when
        List<Cliente> list = servicioClients.showListClientsSortedDni();
        //then
        assertThat(list).asList().contains(c);
    }

    @Test
    void dineroTotalGastado() {
        //given
        //when
        //then
    }

    @Test
    void showClientesSortedDineroGastado() {
        //given
        Cliente c = new ClienteNormal("12345678A","Pepe");
        when(daoClientes.showListaClientesSortedDineroGastado()).thenReturn(List.of(c));
        //when
        List<Cliente> list = servicioClients.showClientesSortedDineroGastado();
        //then
        assertThat(list).asList().contains(c);
    }
    @Test
    void getMonederosCliente() {
        //given
        String dni = "12345678A";
        String nombreMonedero = "monedero1";
        when(daoClientes.getMonederosCliente(dni)).thenReturn(List.of(new Monedero(nombreMonedero,0.0)));
        //when
        List<Monedero> resultado = servicioClients.getMonederosCliente(dni);
        //then
        assertThat(resultado).asList().contains(new Monedero(nombreMonedero,0.0));
    }
}