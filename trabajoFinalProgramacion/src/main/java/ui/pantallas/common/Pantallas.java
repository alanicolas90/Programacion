package ui.pantallas.common;

public enum Pantallas {

    PANTALLA1 ("/fxml/bienvenida.fxml"),
    LOGIN ("/fxml/login.fxml"),
    LISTADO ("/fxml/funcionesUsuario.fxml"),

    MONEDERO("/fxml/billeteras.fxml"),
    REGISTRO("/fxml/register.fxml");

    private final String ruta;
    Pantallas(String ruta) {
        this.ruta=ruta;
    }
    public String getRuta(){return ruta;}


}
