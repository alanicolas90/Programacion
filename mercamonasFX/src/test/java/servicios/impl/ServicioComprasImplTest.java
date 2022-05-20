package servicios.impl;

import dao.DaoClientes;
import dao.DaoCompras;
import dao.DaoProducto;
import dao.impl.DaoClientesImpl;
import dao.impl.DaoComprasImpl;
import dao.impl.DaoProductoCaducableImpl;
import dao.impl.DaoProductoImpl;
import domain.modelo.cliente.LineaCompra;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoNormal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import servicios.ServicioClients;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ServicioComprasImplTest {

    @InjectMocks
    ServicioComprasImpl servicioCompras;

    @Mock
    DaoComprasImpl daoCompras;
    @Mock
    DaoProductoImpl daoProducto;
    @Mock
    DaoClientesImpl daoClientes;
    @Mock
    ServicioClientsImpl servicioClients;

    @Test
    void addToCart() {
        //given
        String dni = "12345678A";
        Producto p = new ProductoNormal(dni, 10, 10);
        LineaCompra lineaCompra = new LineaCompra(p,1);
        when(!daoCompras.alreadyInCart(lineaCompra.getProducto().getName(), dni)).thenReturn(false);
        when(daoProducto.getStockProduct(lineaCompra.getProducto().getName())).thenReturn(11);
        //when
        boolean resultado= servicioCompras.addToCart(dni,lineaCompra);
        //then
        assertThat(resultado).isTrue();
        verify(daoCompras).addCart(dni,lineaCompra);
        verify(daoCompras).cambiarStockComprar(lineaCompra.getProducto().getName(),lineaCompra.getQuantity());
    }

    @Test
    void addToCartExisteProducto() {
        //given
        String dni = "12345678A";
        Producto p = new ProductoNormal(dni, 10, 10);
        LineaCompra lineaCompra = new LineaCompra(p,1);
        //when
        boolean resultado= servicioCompras.addToCart(dni,lineaCompra);
        //then
        assertThat(resultado).isFalse();
    }

    @Test
    void removeProductCart() {
        //given
        String dni = "12345678A";
        String nombreProducto = "Producto";
        when(daoCompras.alreadyInCart(nombreProducto, dni)).thenReturn(true);
        //when
        boolean respuesta = servicioCompras.removeProductCart(dni, nombreProducto);
        //then
        assertThat(respuesta).isTrue();
        verify(daoCompras).alreadyInCart(nombreProducto, dni);
    }

    @Test
    void guardarHistorialCompra() {
        //given
        String dni = "12345678A";
        LineaCompra lineaCompra = new LineaCompra(new ProductoNormal("12345678A", 10, 10),1);
        when(daoClientes.dameCarrito(dni)).thenReturn(List.of(lineaCompra));

        //when
        servicioCompras.guardarHistorialCompra(dni);
        //then
    }

    @Test
    void showBuyHistory() {
        //given
        String dni = "12345678A";
        List<LineaCompra> lista= List.of(new LineaCompra(new ProductoNormal("12345678A", 10, 10),1));
        List<List<LineaCompra>> historailCompra = List.of(lista);
        when(daoClientes.showBuyHistory(dni)).thenReturn(historailCompra);
                //when
        List<List<LineaCompra>> resultado = servicioCompras.showBuyHistory(dni);
        //then
        assertThat(resultado).contains(lista);
    }

    @Test
    void pagarCarrito() {
        //given
        String dni = "12345678A";
        String nombreProducto = "Producto";
        String nombreMonedero = "Monedero";
        when(servicioClients.getTotalPrice(dni)).thenReturn(10.0);
        when(daoClientes.getTodoDineroMonedero(dni, nombreMonedero)).thenReturn(20.0);

        //when
        boolean resultado=servicioCompras.pagarCarrito(dni, nombreMonedero);
        //then
        verify(daoCompras).ajustarDineroMonederoAfterCompra(dni, nombreMonedero, 10.0);
//        verify(servicioCompras,).guardarHistorialCompra(dni);
        assertThat(resultado).isTrue();
    }
}