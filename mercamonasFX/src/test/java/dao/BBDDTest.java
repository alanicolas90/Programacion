package dao;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(WeldJunit5Extension.class)
@Log4j2
class BBDDTest {

//    @Inject
//    private DataBase database;


    private static SeContainer container;

    @BeforeAll
    static void beforeAll() {
//        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
//        container = initializer.initialize();
    }

    @BeforeEach
    void setUp() {
        try {
            Files.delete(Paths.get("test/data/cliente.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //database = container.select(DataBase.class).get();
    }

    @AfterAll
    static void afterAll() {
        //container.close();
    }


    @Test
    void loadClientes() {
    }

    @Test
    void saveClientes() {
    }

    @Test
    void loadProducto() {
    }

    @Test
    void saveProducto() {
    }
}