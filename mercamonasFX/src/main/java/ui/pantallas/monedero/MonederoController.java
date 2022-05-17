package ui.pantallas.monedero;

import domain.modelo.cliente.Monedero;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class MonederoController extends BasePantallaController implements Initializable {

    @FXML
    public TableView<Monedero> table;
    @FXML
    public TableColumn<Monedero, String> columnaNombreMonedero;
    @FXML
    public TableColumn<Monedero, Double> columnaDineroMonedero;
    @FXML
    public TextField txtFieldNombreMonedero;
    @FXML
    public TextField txtFiedDineroMonedero;
    @FXML
    public Button bttnAdd;
    @FXML
    public Button bttnRemove;
    @FXML
    public MFXTextField txtFieldAddDinero;
    @FXML
    public Button bttnAddDinero;


    private final MonederoViewModel viewModel;

    @Inject
    public MonederoController(MonederoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnaNombreMonedero.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnaDineroMonedero.setCellValueFactory(new PropertyValueFactory<>("money"));
        //table.getItems().addAll(viewModel.getMonedero());
    }


}
