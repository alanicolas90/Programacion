package servicios.impl;

import dao.DaoProducto;
import dao.DaoProductoCaducable;
import dao.impl.DaoProductoCaducableImpl;
import dao.impl.DaoProductoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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

    }

    @Test
    void removeProduct() {
    }

    @Test
    void updateNameProduct() {
    }

    @Test
    void updatePriceProduct() {
    }

    @Test
    void updateStockProduct() {
    }

    @Test
    void showAllProducts() {
    }

    @Test
    void getProductoLista() {
    }

    @Test
    void existProduct() {
    }

    @Test
    void addProductCaducable() {
    }

    @Test
    void showAllProductsSinCaducados() {
    }

    @Test
    void showAllProductsOrdenadosName() {
    }

    @Test
    void showAllProductsConIngredientes() {
    }

    @Test
    void addIngredienteAlProducto() {
    }

    @Test
    void showAllProductsSinAlergiasCliente() {
    }

    @Test
    void showAllProductsSortedCantidadComprada() {
    }
}