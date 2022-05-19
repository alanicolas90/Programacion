module javafx {
    requires javafx.fxml;
    requires javafx.controls;
    requires MaterialFX;
    requires jakarta.inject;
    requires lombok;
    requires jakarta.cdi;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;

    exports ui.main;
    exports servicios;
    exports dao;
    exports ui.pantallas.login;
    exports ui.pantallas.principal;
    exports ui.pantallas.series;
    exports domain.modelo;
    exports di;
    exports ui.pantallas.common;
    exports domain.usecases;
    exports ui.pantallas.funcionesUsuario;
    exports common;

    opens ui.main;
    exports ui;
    exports ui.pantallas.pantalla1;
    opens config;
    opens ui.pantallas.principal;
    opens ui.pantallas.login;
    opens ui.pantallas.pantalla1;
    opens ui.pantallas.series;
    opens domain.modelo;
}