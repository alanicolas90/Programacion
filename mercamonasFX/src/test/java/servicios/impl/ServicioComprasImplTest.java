package servicios.impl;

import dao.DaoClientes;
import dao.DaoCompras;
import dao.DaoProducto;
import domain.modelo.cliente.LineaCompra;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoNormal;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import servicios.ServicioClients;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ServicioComprasImplTest {

    @InjectMocks
    ServicioComprasImpl servicioCompras;

    @Mock
    DaoCompras daoCompras;
    @Mock
    DaoProducto daoProducto;
    @Mock
    DaoClientes daoClientes;
    @Mock
    ServicioClients servicioClients;

    @Test
    void addToCart() {
        //given
        String dni = "12345678A";
        Producto p = new ProductoNormal("12345678A", 10, 10);
        LineaCompra lineaCompra = new LineaCompra(p,1);
        //when
        servicioCompras.addToCart(dni,lineaCompra);
        //then
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
        //when
        //then
    }

    @Test
    void pagarCarrito() {
        //given
        //when
        //then
    }
}