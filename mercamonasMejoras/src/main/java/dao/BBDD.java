package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuration;
import lombok.extern.log4j.Log4j2;
import modelo.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;

@Log4j2
public class BBDD {

    private Gson gson;

    private BBDD() {
    }
//          CLIENTES          CLIENTES          CLIENTES          CLIENTES          CLIENTES

    public List<Cliente> loadClientes() {
        Type userListType = new TypeToken<ArrayList<Cliente>>() {
        }.getType();
        List<Cliente> clientes = null;
        try {
            clientes = gson.fromJson(
                    new FileReader(Configuration.getInstance().getClientsSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return clientes;
    }

    public boolean saveClientes(List<Cliente> clientes) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getClientsSource())) {
            gson.toJson(clientes, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }






//    static LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
//    static ArrayList<Producto> productos = new ArrayList<>();
//
//
//
//    static {
//        clientes.put("123", new ClienteNormal("123", "alan"));
//        clientes.put("111", new ClienteNormal("111", "alain"));
//        clientes.put("233", new ClienteNormal("233", "alean"));
//        clientes.put("333", new ClienteNormal("333", "alaan"));
//        clientes.put("223", new ClienteNormal("223", "allan"));
//
//        productos.add(new Producto("acheyese", 2.5, 200));
//        productos.add(new Producto("peperoni", 0.5, 200));
//        productos.add(new Producto("tangadetuabuela", 150, 200));
//        productos.add(new Producto("pimienta", 1.25, 200));
//        productos.add(new Producto("sal", 0.7, 200));
//
//        productos.get(productos.indexOf(new Producto("sal"))).getIngredientes()
//                .add(new Ingrediente("cocaina"));
//
//        productos.add(new ProductoCaducable("pescado", 0.7, 200, LocalDateTime.now().plusSeconds(20)));
//
//        clientes.get("111").getMonederos().add(new Monedero("ale", 1000));
//
//
//        clientes.put("000", new ClienteDescuento("000", "pepe", 25));
//        clientes.get("000").getMonederos().add(new Monedero("ale", 1000));
//
//
//    }
}
