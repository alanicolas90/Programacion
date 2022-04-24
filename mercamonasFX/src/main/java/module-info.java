module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires MaterialFX;

    exports ui;
    exports ui.productos;

    requires lombok;
    requires org.apache.logging.log4j;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;
    requires jakarta.jakartaee.web.api;

    exports modelo.cliente;
    exports common;
    opens ui to javafx.fxml;
    opens modelo.producto to javafx.base, com.google.gson;
    opens ui.productos to javafx.fxml;

    exports dao.impl;
    exports modelo.producto;
    exports di;
    exports ui.admin;
    opens constantes;
    exports ui.client;
    exports servicios.impl;
    exports dao;
    opens config;
    exports servicios.ficheros;
    opens modelo.constantes;
    opens modelo.cliente;
}
