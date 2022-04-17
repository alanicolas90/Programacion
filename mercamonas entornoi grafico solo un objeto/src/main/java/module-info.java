module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires MaterialFX;

    exports ui;
    exports ui.controllers;

    requires lombok;
    requires org.apache.logging.log4j;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.fasterxml.jackson.databind;

    opens modelo to javafx.base;
    exports common to javafx.fxml;
    opens ui.controllers to javafx.fxml;

}
