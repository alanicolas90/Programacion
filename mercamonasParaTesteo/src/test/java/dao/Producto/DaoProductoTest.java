package dao.Producto;

import dao.DaoMonedero;
import dao.DaoProducto;
import modelo.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoProductoTest {

    @Test
    void addProducto() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p = new Producto("coca", 25, 200);
        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        daoProducto.addProducto(p);

        //THEN
        assertIterableEquals(productos, List.of(p));
    }

    @Test
    void removeProducto() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto("coca", 25, 200);
        productos.add(p1);
        Producto p2 = new Producto("hierbas", 5, 2500);
        productos.add(p2);
        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        daoProducto.removeProducto("coca");

        //THEN
        assertIterableEquals(productos, List.of(p2));
    }

    @Test
    void updateNameProducto() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("coca", 25, 200));

        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        daoProducto.updateNameProducto("coca", "cocaina");

        //THEN
        assertIterableEquals(productos, List.of(new Producto("cocaina", 25, 200)));
    }

    @Test
    void updatePriceProducto() {
//GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("coca", 25, 200));

        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        daoProducto.updatePriceProducto("coca", 50);

        //THEN
        assertIterableEquals(productos, List.of(new Producto("coca", 50, 200)));
    }

    @Test
    void updateStockProducto() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("coca", 25, 200));

        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        daoProducto.updateStockProducto("coca", 5000);

        //THEN
        assertIterableEquals(productos, List.of(new Producto("coca", 25, 5000)));
    }

    @Test
    void getProductoFromLista() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p = new Producto("coca", 25, 200);
        productos.add(p);

        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        Producto productoComporobar = daoProducto.getProductoLista("coca");

        //THEN
        assertEquals(p, productoComporobar);
    }

    @Test
    void getPriceProducto() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p = new Producto("coca", 25, 200);
        productos.add(p);

        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        Double productoComporobar = daoProducto.getPriceProducto("coca");

        //THEN
        assertEquals(p.getPrice(), productoComporobar);
    }

    @Test
    void getStockProduct() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p = new Producto("coca", 25, 200);
        productos.add(p);

        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        Integer productoComporobar = daoProducto.getStockProduct("coca");

        //THEN
        assertEquals(p.getStock(), productoComporobar);
    }

    @Test
    void addIngredienteAlProducto() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("coca", 25, 200));
        Ingrediente ingr = new Ingrediente("lacteo");

        int index = productos.indexOf(new Producto("coca"));
        //WHEN
        DaoProducto daoProducto = new DaoProducto(productos);
        daoProducto.addIngredienteAlProducto(ingr,index);

        //THEN
        Producto pPrueba= new Producto("coca", 25, 200);
        pPrueba.getIngredientes().add(new Ingrediente("lacteo"));
        assertIterableEquals(List.of(pPrueba),productos);
    }

    @Test
    void productExists() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("alioli",2,200));
        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        boolean exists = daoProducto.productExists("alioli");
        //Then
        assertTrue(exists);
    }
    @Test
    void productNoExists() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("cocaina",2,200));
        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        boolean exists = daoProducto.productExists("alioli");
        //Then
        assertFalse(exists);
    }

    @Test
    void ingredienteExisteEnProducto() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p =new Producto("cocaina",2,200);
        Ingrediente ingr = new Ingrediente("lacteo");
        p.getIngredientes().add(ingr);
        productos.add(p);

        int index = productos.indexOf(new Producto("cocaina"));
        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        boolean exists = daoProducto.ingredienteExisteEnProducto(ingr,index);
        //Then
        assertTrue(exists);
    }

    @Test
    void showAllProducts() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("cocaina",2,200));
        productos.add(new Producto("amigdalas",5,600));
        productos.add(new Producto("cocido",10,60));

        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        List<Producto> productosProbar = daoProducto.showAllProducts();
        //Then
        assertIterableEquals(productosProbar, List.of(
                new Producto("cocaina",2,200),
                new Producto("amigdalas",5,600),
                new Producto("cocido",10,60)));
    }

    @Test
    void showAllProductosSinCaducables() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("cocaina",2,200));
        productos.add(new Producto("amigdalas",5,600));
        productos.add(new ProductoCaducable("cocido",10,60, LocalDateTime.now()));

        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        List<Producto> productosProbar = daoProducto.showAllProductosSinCaducables();
        //Then
        assertIterableEquals(productosProbar, List.of(
                new Producto("cocaina",2,200),
                new Producto("amigdalas",5,600)));
    }

    @Test
    void showAllProductsSortedName() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("cocaina",2,200));
        productos.add(new Producto("amigdalas",5,600));
        productos.add(new Producto("cocido",10,60));

        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        List<Producto> productosProbar = daoProducto.showAllProductsSortedName();
        //Then
        assertIterableEquals(productosProbar, List.of(
                new Producto("amigdalas",5,600),
                new Producto("cocaina",2,200),
                new Producto("cocido",10,60)));
    }

    @Test
    void showAllProductsConIngrediente() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("cocaina",2,200));
        productos.add(new Producto("amigdalas",5,600));
        productos.add(new Producto("cocido",10,60));

        productos.get(0).getIngredientes().add(new Ingrediente("algo"));
        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        List<Producto> productosProbar = daoProducto.showAllProductsConIngrediente();
        //Then
        assertIterableEquals(productosProbar, List.of(new Producto("cocaina",2,200)));
    }

    @Test
    void showAllProductsSinAlergiasCliente() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

        Cliente c = new Cliente("111", "Manolo");
        clientes.put("111",c);
        clientes.get("111").getAlergenos().add(new Ingrediente("pipas"));

        productos.add(new Producto("cocaina",2,200));
        productos.add(new Producto("amigdalas",5,600));
        productos.add(new Producto("cocido",10,60));

        productos.get(0).getIngredientes().add(new Ingrediente("pipas"));

        //When
        DaoProducto daoProducto = new DaoProducto(productos, clientes);
        List<Producto> productosProbar = daoProducto.showAllProductsSinAlergiasCliente("111");
        //Then
        assertIterableEquals(productosProbar, List.of(
                new Producto("amigdalas",5,600),
                new Producto("cocido",10,60)));
    }


    @Test
    void indexProduct() {
        //Given
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("cocaina",2,200));
        productos.add(new Producto("amigdalas",5,600));
        productos.add(new Producto("cocido",10,60));

        //When
        DaoProducto daoProducto = new DaoProducto(productos);
        int indexProbar = daoProducto.indexProduct("cocaina");
        //Then
        assertEquals(0, indexProbar);
    }
}