package ui.pantallas.principal;


import domain.modelo.Cromo;
import domain.modelo.Usuario;
import domain.modelo.cliente.LineaCompra;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lombok.extern.log4j.Log4j2;
import ui.pantallas.common.BasePantallaController;
import ui.pantallas.common.Pantallas;

import java.io.IOException;
import java.util.Optional;

@Log4j2
public class PrincipalController {
@FXML
    public Menu menuAdmin;
    @FXML
    private Menu menuCliente;
    // objeto especial para DI
    Instance<Object> instance;

    @FXML
    private MenuBar menuPrincipal;
    private Stage primaryStage;

    private Usuario actualUser;
    private Cromo cromoSeleccionado;

    public Usuario getActualUser() {
        return actualUser;
    }

    public String getDni(){
        return "0001";
    }

    public Cromo getActualCromo(){return cromoSeleccionado;}


    @FXML
    private BorderPane root;


    private Alert alert;



    @Inject
    public PrincipalController(Instance<Object> instance) {
       this.instance = instance;
       alert= new Alert(Alert.AlertType.NONE);
    }

    private void cargarPantalla(Pantallas pantalla) {

        switch (pantalla) {
//            case LISTADO:
//                cambioPantalla(cargarPantalla(pantalla.getRuta()));
//                break;
//            case PANTALLA1:
//                if (pantallaBienvenida == null){
//                    pantallaBienvenida = cargarPantalla(pantalla.getRuta());
//                }
//
//                cambioPantalla(pantallaBienvenida);
//                break;
            default:
                cambioPantalla(cargarPantalla(pantalla.getRuta()));
                break;
        }
    }


    public void sacarAlertError(String mensaje)
    {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    private Pane cargarPantalla(String ruta) {
        Pane panePantalla = null;
        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(controller -> instance.select(controller).get());
            panePantalla = fxmlLoader.load(getClass().getResourceAsStream(ruta));
            BasePantallaController pantallaController = fxmlLoader.getController();
            pantallaController.setPrincipalController(this);
            pantallaController.principalCargado();


        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return panePantalla;
    }

    public void logout() {
        actualUser = null;
        menuPrincipal.setVisible(false);
        cargarPantalla(Pantallas.LOGIN);
    }

    private void cambioPantalla(Pane pantallaNueva) {
        root.setCenter(pantallaNueva);
    }


    public void initialize() {
        menuPrincipal.setVisible(false);
        cargarPantalla(Pantallas.LOGIN);
    }

    private void closeWindowEvent(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getButtonTypes().remove(ButtonType.OK);
        alert.getButtonTypes().add(ButtonType.CANCEL);
        alert.getButtonTypes().add(ButtonType.YES);
        alert.setTitle("Quit application");
        alert.setContentText("Close without saving?");
        alert.initOwner(primaryStage.getOwner());
        Optional<ButtonType> res = alert.showAndWait();


        res.ifPresent(buttonType -> {
            if (buttonType == ButtonType.CANCEL) {
                event.consume();
            }
        });
    }

    public void exit(ActionEvent actionEvent) {
//        primaryStage.close();
//        Platform.exit();
        primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void setStage(Stage stage) {
        primaryStage = stage;
        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
    }

    @FXML
    private void cambiarcss(ActionEvent actionEvent) {
        System.out.println(primaryStage.getScene().getRoot().getStylesheets().stream().findFirst().get());

        primaryStage.getScene().getRoot().getStylesheets().clear();

        primaryStage.getScene().getRoot().getStylesheets().add(getClass().getResource("/css/darkmode.css").toExternalForm());

    }

    @FXML
    private void menuClick(ActionEvent actionEvent) {
        switch (((MenuItem)actionEvent.getSource()).getId())
        {
            case "menuItemClientes":
                cargarPantalla(Pantallas.CLIENTES);
                break;
            case "menuItemPantalla1":
                cargarPantalla(Pantallas.PANTALLA1);
                break;
            case "menuItemPantallaNueva":
                cargarPantalla(Pantallas.PRODUCTOS);
                break;
            case "menuItemLogout":
                logout();
                break;
            case "menuItemCarrito":
                cargarPantalla(Pantallas.CARRITO);
                break;
            case "menuItemMonedero":
                cargarPantalla(Pantallas.MONEDERO);
                break;
            case "menuItemTienda":
                cargarPantalla(Pantallas.TIENDA);
                break;
        }

    }

    //evento de otra pantalla
    public void onLoginHecho(Usuario usuario) {
        actualUser = usuario;
        menuPrincipal.setVisible(true);
        if (actualUser.getNombre().equals("admin")) {
            menuCliente.setVisible(false);
            menuAdmin.setVisible(true);
        }else if(actualUser.getNombre().equals("user")){
            menuAdmin.setVisible(false);
            menuCliente.setVisible(true);
        }


        cargarPantalla(Pantallas.PANTALLA1);
    }

}
