module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;
    requires org.apache.logging.log4j;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.gson;

    exports ui.main to javafx.graphics;
    exports ui.pantallas.principal;
    exports ui.pantallas.productos;
    exports ui.pantallas.pantalla1;
    exports ui.pantallas.login;
    exports ui.pantallas.detalle;
    exports ui.pantallas.historial_compras;
    exports config;
    exports ui.pantallas.common;
    exports common;
    exports dao.impl;
    exports domain.usecases;


    opens ui.pantallas.pantalla1 to javafx.fxml;
    opens ui.pantallas.productos;
    opens ui.pantallas.historial_compras to javafx.fxml;
    opens ui.pantallas.login to  javafx.fxml;
    opens ui.pantallas.detalle to  javafx.fxml;
    opens ui.pantallas.principal;
    opens ui.main;
    opens config;
    opens fxml;

    exports servicios.impl;
    exports domain.modelo.cliente;
    exports ui.client;
    exports dao;
    opens domain.modelo.constantes;
    exports domain.modelo.producto;
    exports ui.admin;
    exports ui;
    exports servicios.ficheros;
    exports di;
    opens constantes;
    opens domain.modelo.producto;
    exports ui.pantallas.clientes;
    exports ui.pantallas.carrito;
    opens ui.pantallas.clientes;
    exports ui.pantallas.monedero;
    exports ui.pantallas.compra;
    opens domain.modelo.cliente;
}

