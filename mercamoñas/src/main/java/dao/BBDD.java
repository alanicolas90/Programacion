package dao;

import modelo.Cliente;
import modelo.Monedero;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.*;

public class BBDD {

    private BBDD() {
    }

    static LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
    static ArrayList<Producto> productos = new ArrayList<>();


    static {
        clientes.put("123", new Cliente("123", "alan", "mikolajczyk"));
        clientes.put("1", new Cliente("1", "alain", "mikolajczyk"));
        clientes.put("23", new Cliente("23", "alean", "mikolajczyk"));
        clientes.put("3", new Cliente("3", "alaan", "mikolajczyk"));
        clientes.put("2", new Cliente("2", "allan", "mikolajczyk"));

        productos.add(new Producto("acheyese", 2.5, 200));
        productos.add(new Producto("peperoni", 0.5, 200));
        productos.add(new Producto("tangadetuabuela", 150, 200));
        productos.add(new Producto("pimienta", 1.25, 200));
        productos.add(new Producto("sal", 0.7, 200));

        productos.add(new ProductoCaducable("pescado", 0.7, 200, LocalDateTime.now().plusMinutes(5)));

        clientes.get("1").getMonederos().add(new Monedero("ale", 1000));

    }
}
