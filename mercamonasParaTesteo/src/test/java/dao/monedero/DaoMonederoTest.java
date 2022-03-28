package dao.monedero;

import dao.DaoCompras;
import dao.DaoMonedero;
import modelo.Cliente;
import modelo.LineaCompra;
import modelo.Monedero;
import modelo.Producto;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DaoMonederoTest {

    @Test
    void monederoExists() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        clientes.put("111", new Cliente("111", "alain"));
        clientes.get("111").getMonederos().add(new Monedero("ale", 200));

        //WHEN
        DaoMonedero daoMonedero = new DaoMonedero(clientes);
        boolean monederoExisteProbar = daoMonedero.monederoExists("ale", "111");
        //THEN
        assertTrue(monederoExisteProbar);
    }

    @Test
    void addMonedero() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        String dniClient = "111";
        Monedero monedero = new Monedero("ale", 5000);
        clientes.put(dniClient, new Cliente(dniClient, "alain"));

        //WHEN
        DaoMonedero daoMonedero = new DaoMonedero(clientes);
        daoMonedero.addMonedero(monedero, "111");
        //THEN
        assertIterableEquals(clientes.get(dniClient).getMonederos(), Set.of(monedero));
    }

    @Test
    void addMoneyMonedero() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        String dniClient = "111";
        String nombreMonedero = "ale";
        clientes.put(dniClient, new Cliente(dniClient, "alain"));
        clientes.get(dniClient).getMonederos().add(new Monedero(nombreMonedero, 5000));

        //WHEN
        DaoMonedero daoMonedero = new DaoMonedero(clientes);
        daoMonedero.addMoneyMonedero(dniClient, nombreMonedero, 500);
        //THEN
        assertIterableEquals(clientes.get(dniClient).getMonederos(), Set.of(new Monedero(nombreMonedero, 5500)));
    }

    @Test
    void removeMonedero() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        String dniClient = "111";
        String nombreMonedero = "ale";
        clientes.put(dniClient, new Cliente(dniClient, "alain"));
        clientes.get(dniClient).getMonederos().add(new Monedero(nombreMonedero, 200));
        clientes.get(dniClient).getMonederos().add(new Monedero("nombreMonedero", 5500));

        //WHEN
        DaoMonedero daoMonedero = new DaoMonedero(clientes);
        daoMonedero.removeMonedero(dniClient, nombreMonedero);
        //THEN
        assertIterableEquals(clientes.get(dniClient).getMonederos(), Set.of(new Monedero("nombreMonedero", 5500)));
    }

    @Test
    void showTarjetasCliente() {
        //GIVEN
        LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
        String dniClient = "111";
        String nombreMonedero = "ale";
        clientes.put(dniClient, new Cliente(dniClient, "alain"));
        clientes.get(dniClient).getMonederos().add(new Monedero(nombreMonedero, 200));
        clientes.get(dniClient).getMonederos().add(new Monedero("nombreMonedero", 5500));

        //WHEN
        DaoMonedero daoMonedero = new DaoMonedero(clientes);
        Set<Monedero> monederosCLientePobar = daoMonedero.showTarjetasCliente(dniClient);
        //THEN
        assertIterableEquals(monederosCLientePobar,
                Set.of(new Monedero(nombreMonedero, 200),
                        new Monedero("nombreMonedero", 5500)));
    }
}