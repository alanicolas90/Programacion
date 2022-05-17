package ui.pantallas.clientes;

import domain.modelo.cliente.Cliente;
import domain.modelo.cliente.ClienteNormal;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientesController extends BasePantallaController implements Initializable {
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtDni;
    @FXML
    public TableView<Cliente> table;
    @FXML
    public TableColumn<Cliente, String> columnDni;
    @FXML
    public TableColumn<Cliente, String> columnNombre;
    @FXML
    public MFXTextField nombre;
    @FXML
    public MFXTextField dni;

    private final ClientesViewModel viewModel;

    @Inject
    public ClientesController(ClientesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void update() {
        Cliente productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null) {
            nombre.setText(productTabla.getNombre());
            dni.setText(String.valueOf(productTabla.getDni()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        table.getItems().addAll(viewModel.allClients());
    }

    @FXML
    private void add() {
        Cliente nuevoProduct = new ClienteNormal(txtDni.getText(), txtNombre.getText());
        boolean contains = !table.getItems().contains(nuevoProduct);
        if (contains) {
            table.getItems().add(nuevoProduct);
        }
    }

    @FXML
    private void remove() {

        Cliente productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null) {
            table.getItems().remove(productTabla);
        }

    }

    public void updateData() {
        Cliente productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null) {
            table.getItems().remove(productTabla);
            table.getItems().add(new ClienteNormal(dni.getText(), nombre.getText()));
        }
    }
}
