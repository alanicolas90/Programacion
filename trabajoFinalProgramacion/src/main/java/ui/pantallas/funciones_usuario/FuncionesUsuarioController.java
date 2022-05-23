package ui.pantallas.funciones_usuario;


import domain.modelo.billetera.BilleteraFamiliar;
import domain.modelo.solicitud.Solicitud;
import domain.modelo.usuario.Usuario;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class FuncionesUsuarioController extends BasePantallaController implements Initializable {

    private final FuncionesUsuarioViewModel viewModel;


    @FXML
    public MFXTextField valoracion;
    @FXML
    public MFXTextField visto;
    @FXML
    public MFXTextField password;
    @FXML
    public MFXTextField nombre;
    @FXML
    public MFXTextField apellido;
    @FXML
    public MFXTextField correo;
    @FXML
    public TableView tableBilleteras;
    @FXML
    public TableColumn<String, Solicitud> colSolicitante;
    @FXML
    public TableColumn<String, Solicitud> colMensaje;
    @FXML
    public TableColumn<String, Solicitud> colAceptado;
    @FXML
    public TableView<Solicitud> tablaSolicitudes;
    @FXML
    public TableView<BilleteraFamiliar> tablaBilleteras;
    @FXML
    public TableColumn<String, BilleteraFamiliar> colBilleteras;


    @Inject
    public FuncionesUsuarioController(FuncionesUsuarioViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSolicitante.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));
        colAceptado.setCellValueFactory(new PropertyValueFactory<>("aceptado"));
        colBilleteras.setCellValueFactory(new PropertyValueFactory<>("nombreGrupoFamiliar"));
    }

    @Override
    public void principalCargado() {
        Usuario user = getPrincipalController().getActualUser();
        Usuario usuario = viewModel.getUsuario(user);
        nombre.setText(usuario.getNombre());
        apellido.setText(usuario.getApellido());
        correo.setText(usuario.getCorreo());
        password.setText(usuario.getPassword());
        tablaBilleteras.getItems().addAll(viewModel.getBilleteras(user));

    }


    public void update() {
    }

    public void updateDatos() {
        Usuario user = getPrincipalController().getActualUser();
        Usuario usuario = viewModel.getUsuario(user);
        Usuario usuarioActualizado = new Usuario(usuario.getUsername(), password.getText(), nombre.getText(), apellido.getText(), correo.getText(), usuario.getDinero());
        if (!usuario.getPassword().equals(usuarioActualizado.getPassword()) ||
                !usuario.getNombre().equals(usuarioActualizado.getNombre()) ||
                !usuario.getApellido().equals(usuarioActualizado.getApellido()) ||
                !usuario.getCorreo().equals(usuarioActualizado.getCorreo())) {
            if (viewModel.updateUsuario(usuarioActualizado)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Actualizacion exitosa");
                alert.setContentText("Se actualizo correctamente");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Actualizacion fallida");
                alert.setContentText("No se pudo actualizar");
                alert.showAndWait();
            }
        }

    }

    public void updateTableSolicitud() {
        BilleteraFamiliar billetera = tablaBilleteras.getSelectionModel().getSelectedItem();
        Usuario user = getPrincipalController().getActualUser();
        Usuario usuario = viewModel.getUsuario(user);
        if(billetera != null) {
            tablaSolicitudes.getItems().removeAll(tablaSolicitudes.getItems());
            tablaSolicitudes.getItems().addAll(viewModel.getSolicitudes(billetera,usuario));
        }
    }

    public void aceptarSolicitud() {
        Usuario user = getPrincipalController().getActualUser();
        Usuario usuario = viewModel.getUsuario(user);
        Solicitud solicitud = tablaSolicitudes.getSelectionModel().getSelectedItem();
        BilleteraFamiliar billetera = tablaBilleteras.getSelectionModel().getSelectedItem();
        if(solicitud != null && billetera != null) {
            if(viewModel.aceptarSolicitud(solicitud, billetera)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aceptacion exitosa");
                alert.setContentText("Se acepto correctamente");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Aceptacion fallida");
                alert.setContentText("No se pudo aceptar");
                alert.showAndWait();
            }
            tablaBilleteras.getItems().removeAll(tablaBilleteras.getItems());
            tablaBilleteras.getItems().addAll(viewModel.getBilleteras(user));
            tablaSolicitudes.getItems().removeAll(tablaSolicitudes.getItems());
            tablaSolicitudes.getItems().addAll(viewModel.getSolicitudes(billetera,usuario));
        }
    }

    public void rechazarSolicitud() {
        Usuario user = getPrincipalController().getActualUser();
        Usuario usuario = viewModel.getUsuario(user);
        Solicitud solicitud = tablaSolicitudes.getSelectionModel().getSelectedItem();
        BilleteraFamiliar billetera = tablaBilleteras.getSelectionModel().getSelectedItem();
        if(solicitud != null && billetera != null) {
            if(viewModel.rechazarSolicitud(solicitud, billetera)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Rechazo exitoso");
                alert.setContentText("Se rechazo correctamente");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Rechazo fallido");
                alert.setContentText("No se pudo rechazar");
                alert.showAndWait();
            }
            tablaBilleteras.getItems().removeAll(tablaBilleteras.getItems());
            tablaBilleteras.getItems().addAll(viewModel.getBilleteras(user));
            tablaSolicitudes.getItems().removeAll(tablaSolicitudes.getItems());
            tablaSolicitudes.getItems().addAll(viewModel.getSolicitudes(billetera,usuario));
        }
    }
}
