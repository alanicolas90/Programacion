package ui.pantallas.clientes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientesController extends BasePantallaController implements Initializable {
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtDni;
    @FXML
    public TableView table;
    @FXML
    public TableColumn columnDni;
    @FXML
    public TableColumn columnNombre;

    private ClientesViewModel viewModel;

    public ClientesController() {
    }

    public void update(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        //table.getItems().addAll(viewModel.allProducts());
    }
}
