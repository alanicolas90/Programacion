package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuration;
import di.GsonProducer;
import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.ClienteNormal;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@Log4j2
class BBDDTest {


    //clase a probar
    @InjectMocks
    private BBDD db;


    private static SeContainer container;

    @BeforeAll
    static void beforeAll() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        container = initializer.initialize();
    }

    @BeforeEach
    void setUp() {
        try {
            Files.delete(Paths.get("test/data/client.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        db = container.select(BBDD.class).get();
    }

    @AfterAll
    static void afterAll() {
        container.close();
    }


    @Test
    void loadClientes() {
        //given
        Map<String, Cliente> resultado;
        try {
            Files.copy(Paths.get("test/data/clienteLoadTest.json"), Paths.get("test/data/client.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //when
        resultado = db.loadClientes();
        //then
        assertThat(resultado).hasSize(1);
    }

    @Test
    void saveClientes() {
        Cliente c = new ClienteNormal("Pepe", "Pérez");
        Map<String, Cliente> clientes = Map.of(c.getDni(), c);
        Map<String, Cliente> resultado = new LinkedHashMap<>();

        //when
        boolean retorno = db.saveClientes(clientes);
        //then

        GsonProducer dp = new GsonProducer();

        Gson gson = dp.getGson();

        Type userListType = new TypeToken<LinkedHashMap<String, Cliente>>() {
        }.getType();

        try (FileReader r = new FileReader("test/data/client.json")) {
            resultado = gson.fromJson(
                    r,
                    userListType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        assertThat(new File("test/data/client.json"))
                .hasContent("{\"Pepe\":{\"dni\":\"Pepe\",\"nombre\":\"Pérez\",\"monederos\":[],\"type\":\"ClienteNormal\",\"alergenos\":[],\"carrito\":[],\"buyHistory\":[]}}");
        assertThat(resultado).hasSize(1);

        assertThat(resultado.get("Pepe")).isEqualTo(c);
        assertThat(retorno).isTrue();
        //EN ESTOS ASSERTS PRUEBA DISTINTOS DATOS Y DISTINTOS CASOS COMO CLIUENTE CON DECUENTO Y ETC
        //IMPORTANTE ESTO ESTA HECHO MODO LISTA NO MAPA
//        assertThat(resultado.get(0).getNombre()).isEqualTo("Pérez");
//        assertThat(resultado.get(0)).isEqualTo(new ClienteNormal("01", "alan"));


    }

    @Test
    void loadProducto() {
    }

    @Test
    void saveProducto() {
    }
}