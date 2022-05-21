package servicios.impl;

import dao.DaoProducto;
import dao.DaoProductoCaducable;
import dao.impl.DaoProductoCaducableImpl;
import dao.impl.DaoProductoImpl;
import domain.modelo.producto.Ingrediente;
import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoCaducable;
import domain.modelo.producto.ProductoNormal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicioProductosImplTest {

    @InjectMocks
    ServicioProductosImpl servicioProductos;

    @Mock
    DaoProductoImpl daoProducto;
    @Mock
    DaoProductoCaducableImpl daoProductoCaducable;


    @Test
    void addProduct() {
        //given
        String name = "Producto";
        double price = 10.0;
        int stock = 10;
        Producto producto = new ProductoNormal(name, price, stock);

        when(!daoProducto.productExists(producto.getName())).thenReturn(false);
        when(daoProducto.addProducto(producto)).thenReturn(true);

        //when
        boolean resultado = servicioProductos.addProduct(producto);
                //then
        assertTrue(resultado);
    }
    @Test
    void addProductYaExiste() {
        //given
        String name = "Producto";
        double price = 10.0;
        int stock = 10;
        Producto producto = new ProductoNormal(name, price, stock);

        when(!daoProducto.productExists(producto.getName())).thenReturn(true);

        //when
        boolean resultado = servicioProductos.addProduct(producto);
        //then
        assertFalse(resultado);
    }

    @Test
    void removeProduct() {
        //given
        String name = "Producto";
        when(daoProducto.productExists(name)).thenReturn(true);
        when(daoProducto.removeProducto(name)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.removeProduct(name);
        //then
        assertTrue(resultado);
    }
    @Test
    void removeProductNoExiste() {
        //given
        String name = "Producto";
        when(daoProducto.productExists(name)).thenReturn(false);
        //when
        boolean resultado = servicioProductos.removeProduct(name);
        //then
        assertFalse(resultado);
    }
    @Test
    void updateNameProduct() {
        //given
        String name = "Producto";
        String newName = "Producto2";
        when(daoProducto.productExists(name)).thenReturn(true);
        when(daoProducto.updateNameProducto(name, newName)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.updateNameProduct(name, newName);
        //then
        assertTrue(resultado);
    }

    @Test
    void updateNameProductNoExiste() {
        //given
        String name = "Producto";
        String newName = "Producto2";
        when(daoProducto.productExists(name)).thenReturn(false);
        //when
        boolean resultado = servicioProductos.updateNameProduct(name, newName);
        //then
        assertFalse(resultado);
    }

    @Test
    void updatePriceProduct() {
        //given
        String name = "Producto";
        int newPrice = 10;
        when(daoProducto.productExists(name)).thenReturn(true);
        when(daoProducto.updatePriceProducto(name, newPrice)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.updatePriceProduct(name, newPrice);
        //then
        assertTrue(resultado);
    }

    @Test
    void updatePriceProductNoExiste() {
        //given
        String name = "Producto";
        int newPrice = 10;
        when(daoProducto.productExists(name)).thenReturn(false);
        //when
        boolean resultado = servicioProductos.updatePriceProduct(name, newPrice);
        //then
        assertFalse(resultado);
    }
    @Test
    void updatePriceProductPriceEsCero() {
        //given
        String name = "Producto";
        int newPrice = 0;
        when(daoProducto.productExists(name)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.updatePriceProduct(name, newPrice);
        //then
        assertFalse(resultado);
    }

    @Test
    void updateStockProduct() {
        //given
        String name = "Producto";
        int newStock = 10;
        when(daoProducto.productExists(name)).thenReturn(true);
        when(daoProducto.updateStockProducto(name, newStock)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.updateStockProduct(name, newStock);
        //then
        assertTrue(resultado);
    }

    @Test
    void updateStockProductNoExiste() {
        //given
        String name = "Producto";
        int newStock = 10;
        when(daoProducto.productExists(name)).thenReturn(false);
        //when
        boolean resultado = servicioProductos.updateStockProduct(name, newStock);
        //then
        assertFalse(resultado);
    }

    @Test
    void updateStockProductNewStockNegativo() {
        //given
        String name = "Producto";
        int newStock = -10;
        when(daoProducto.productExists(name)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.updateStockProduct(name, newStock);
        //then
        assertFalse(resultado);
    }

    @Test
    void showAllProducts() {
        //given
        Producto producto = new ProductoNormal("Producto", 10, 10);
        List<Producto> listaProductos = new ArrayList<>(List.of(producto));
        when(daoProducto.showAllProducts()).thenReturn(listaProductos);
        //when
        List<Producto> resultado = servicioProductos.showAllProducts();
        //thenç
        assertThat(resultado).contains(producto);
    }

    @Test
    void getProductoLista() {
        //given
        String name = "Producto";
        Producto producto = new ProductoNormal(name, 10, 10);
        when(daoProducto.getProductoLista(name)).thenReturn(producto);
        //when
        Producto p = servicioProductos.getProductoLista(name);
        //then
        assertThat(p).isEqualTo(producto);
    }

    @Test
    void existProduct() {
        //given
        String name = "Producto";
        when(daoProducto.productExists(name)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.existProduct(name);
        //then
        assertTrue(resultado);
    }
    @Test
    void existProductNo() {
        //given
        String name = "Producto";
        when(daoProducto.productExists(name)).thenReturn(false);
        //whenç
        boolean resultado = servicioProductos.existProduct(name);
        //then
        assertFalse(resultado);
    }

    @Test
    void addProductCaducable() {
        //given
        String name = "Producto";
        int price = 10;
        int stock = 10;
        String caducidades = "2026-11-09T11:44:44";

        LocalDateTime caducidad = LocalDateTime.parse(caducidades);
        ProductoCaducable producto = new ProductoCaducable(name, price, stock, caducidad);
        when(daoProductoCaducable.addProductoCaducable(producto)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.addProductCaducable(producto);
        //then
        assertTrue(resultado);
    }

    @Test
    void addProductCaducableNoExiste() {
        //given
        String name = "Producto";
        int price = 10;
        int stock = 10;
        String caducidades = "2016-11-09T11:44:44";

        LocalDateTime caducidad = LocalDateTime.parse(caducidades);
        ProductoCaducable producto = new ProductoCaducable(name, price, stock, caducidad);
        //when
        boolean resultado = servicioProductos.addProductCaducable(producto);
        //then
        assertFalse(resultado);
    }

    @Test
    void showAllProductsSinCaducados() {
        //given
        Producto producto = new ProductoNormal("Producto", 10, 10);
        Producto productoCaducado = new ProductoCaducable("Producto", 10, 10, LocalDateTime.now());
        List<Producto> listaSinCaducados = new ArrayList<>(List.of(producto));
        when(daoProducto.showAllProductosSinCaducables()).thenReturn(listaSinCaducados);
        //when
        List<Producto> resultado = servicioProductos.showAllProductsSinCaducados();
        //then
        assertThat(resultado).containsExactly(producto);
    }

    @Test
    void showAllProductsOrdenadosName() {
        //given
        Producto producto = new ProductoNormal("Producto", 10, 10);
        Producto producto1 = new ProductoNormal("Aroducto1", 10, 10);
        List<Producto> lista = new ArrayList<>(List.of(producto, producto1));
        when(daoProducto.showAllProductsSortedName()).thenReturn(lista.stream().sorted(Comparator.comparing(Producto::getName)).collect(Collectors.toList()));
        //when
        List<Producto> resultado = servicioProductos.showAllProductsOrdenadosName();
        //then
        assertThat(resultado).asList().containsExactly(producto1, producto);
    }

    @Test
    void showAllProductsConIngredientes() {
        //given
        Producto producto = new ProductoNormal("Producto", 10, 10);
        producto.getIngredientes().add(new Ingrediente("Ingrediente"));
        List<Producto> lista = new ArrayList<>(List.of(producto));
        when(daoProducto.showAllProductsConIngrediente()).thenReturn(lista);
        //when
        List<Producto> resultado = servicioProductos.showAllProductsConIngredientes();
        //then
        assertThat(resultado).asList().containsExactly(producto);
    }

    @Test
    void addIngredienteAlProducto() {
        //given
        String name = "Producto";
        Ingrediente ingrediente = new Ingrediente("Ingrediente");
        when(daoProducto.indexProduct(name)).thenReturn(0);
        when(daoProducto.ingredienteExisteEnProducto(ingrediente, name)).thenReturn(false);
        when(daoProducto.addIngredienteAlProducto(ingrediente, name)).thenReturn(true);
        //when
        boolean resultado = servicioProductos.addIngredienteAlProducto(name,ingrediente);
        //then
        assertThat(resultado).isTrue();
    }

    @Test
    void addIngredienteAlProductoExistenteIngrediente() {
        //given
        String name = "Producto";
        Ingrediente ingrediente = new Ingrediente("Ingrediente");
        when(daoProducto.indexProduct(name)).thenReturn(-1);
        //when
        boolean resultado = servicioProductos.addIngredienteAlProducto(name,ingrediente);
        //then
        assertThat(resultado).isFalse();
    }

    @Test
    void showAllProductsSinAlergiasCliente() {
        //given
        String dni = "Producto";
        Producto producto = new ProductoNormal("Producto", 10, 10);
        List<Producto> productos = new ArrayList<>(List.of(producto));
        when(daoProducto.showAllProductsSinAlergiasCliente(dni)).thenReturn(productos);
        //when
       List<Producto> resultado = servicioProductos.showAllProductsSinAlergiasCliente(dni);
        //then
        assertThat(resultado).asList().containsExactly(producto);
    }

    @Test
    void showAllProductsSortedCantidadComprada() {
        //given
        Producto producto = new ProductoNormal("Producto", 10, 10);
        when(daoProducto.showCantidadProductosOrdenadaPorLaMasComprada()).thenReturn(List.of(producto.getName()));
        //when
        List<String> resultado = servicioProductos.showAllProductsSortedCantidadComprada();
        //then
        assertThat(resultado).asList().containsExactly(producto.getName());

    }
}