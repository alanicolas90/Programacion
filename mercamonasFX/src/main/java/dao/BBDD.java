package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import config.Configuration;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import domain.modelo.cliente.Cliente;
import domain.modelo.producto.Producto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Log4j2
public class BBDD {

    private final Gson gson;

    private Configuration configuration;


    @Inject
    public BBDD(Gson gson, Configuration configuration) {
        this.gson = gson;
        this.configuration = configuration;
    }


//          CLIENTES          CLIENTES          CLIENTES          CLIENTES          CLIENTES

    public Map<String,Cliente> loadClientes() {
        Type userListType = new TypeToken<LinkedHashMap<String, Cliente>>() {
        }.getType();
        LinkedHashMap<String, Cliente> clientes = null;
        try( FileReader r = new FileReader(Configuration.getInstance().getClientsSource())) {
            clientes = gson.fromJson(
                    r,
                    userListType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return clientes;
    }

    public boolean saveClientes(Map<String,Cliente> clientes) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getClientsSource())) {
            gson.toJson(clientes, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

//          PRODUCTOS          PRODUCTOS          PRODUCTOS          PRODUCTOS          PRODUCTOS

    public List<Producto> loadProducto() {
        Type userListType = new TypeToken<ArrayList<Producto>>() {
        }.getType();
        List<Producto> productos = null;
        try {
            productos = gson.fromJson(
                    new FileReader(Configuration.getInstance().getProductsSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return productos;
    }

    public boolean saveProducto(List<Producto> productos) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getProductsSource())) {
            gson.toJson(productos, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

}
