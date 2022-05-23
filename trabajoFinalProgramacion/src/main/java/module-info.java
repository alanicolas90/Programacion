module trabajoFinalProgramacion {
    requires jakarta.jakartaee.web.api;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.gson;
    requires javafx.fxml;
    requires javafx.controls;
    requires MaterialFX;
    requires lombok;
    requires org.apache.logging.log4j;

    exports ui.main;
    exports domain.modelo.usuario;
    exports ui.entered_account.menu_billeteras;
    exports ui.pantallas.login;
    exports dao.impl;
    exports servicios.ficheros;
    exports common;
    exports ui;
    exports domain.modelo.billetera;
    exports ui.entered_account;
    exports domain.usecases;
    exports ui.pantallas.common;
    exports dao;
    exports ui.entered_account.ajustes_usuario;
    exports di;
    exports servicios.impl;
    exports domain.modelo.solicitud;
    exports ui.pantallas.principal;

    opens ui.pantallas.principal;
    opens ui.main;
    opens config;
    opens constantes;
    opens ui.pantallas.login;
    opens domain.modelo.usuario;
    opens domain.modelo.billetera;
    opens domain.modelo.solicitud;
    opens domain.modelo.gasto;
    exports ui.pantallas.pantalla1;
    opens ui.pantallas.pantalla1;
    exports ui.pantallas.funciones_usuario;
    exports ui.pantallas.register;
    exports ui.pantallas.billeteras;
}