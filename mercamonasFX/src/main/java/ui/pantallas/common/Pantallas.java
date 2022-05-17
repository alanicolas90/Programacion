package ui.pantallas.common;

public enum Pantallas {

    PANTALLA1 ("/fxml/bienvenida.fxml"),
    LOGIN ("/fxml/login.fxml"),
    LISTADO ("/fxml/historialCompras.fxml"),
    DETALLE ("/fxml/detalle.fxml"),
    PRODUCTOS("/fxml/productos.fxml"),
    CLIENTES("/fxml/clientes.fxml"),
    CARRITO("/fxml/carrito.fxml"),
    MONEDERO("/fxml/monedero.fxml"),
    TIENDA("/fxml/compra.fxml");

    private final String ruta;
    Pantallas(String ruta) {
        this.ruta=ruta;
    }
    public String getRuta(){return ruta;}


}
