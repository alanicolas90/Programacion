package dao.Producto;

import dao.DaoProducto;
import dao.DaoProductoCaducable;
import modelo.Producto;
import modelo.ProductoCaducable;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoProductoCaducableTest {

    @Test
    void addProductoCaducable() {
        //GIVEN
        ArrayList<Producto> productos = new ArrayList<>();
        ProductoCaducable p = new ProductoCaducable("alioli",20,200, LocalDateTime.now());
        //WHEN
        DaoProductoCaducable daoProductoCaducable = new DaoProductoCaducable(productos);
        daoProductoCaducable.addProductoCaducable(p);

        //THEN
        assertIterableEquals(productos, List.of(p));
    }
}