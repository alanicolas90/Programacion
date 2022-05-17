package ui.pantallas.carrito;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class CarritoController extends BasePantallaController implements Initializable {
    @FXML
    public TableView table;
    @FXML
    public Button bttnRemove;
    @FXML
    public MFXTextField txtField;
    @FXML
    public Button bttnPagar;
    @FXML
    public TableColumn columnName;
    @FXML
    public TableColumn columnPrice;
    @FXML
    public TableColumn columnQuantity;

    public CarritoController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        //table.getItems().addAll(viewModel.allProducts());
    }
}
