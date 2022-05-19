package ui.pantallas.carrito;

import domain.modelo.cliente.LineaCompra;
import domain.modelo.producto.Producto;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
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
    public TableView<LineaCompra> table;
    @FXML
    public Button bttnRemove;
    @FXML
    public Button bttnPagar;
    @FXML
    public TableColumn<String, Producto> columnName;
    @FXML
    public TableColumn<String,LineaCompra> columnQuantity;
    @FXML
    public MFXTextField txtTotalPrice;
    @FXML
    public MFXTextField txtNewQuantity;

    private CarritoViewModel viewModel;
    @Inject
    public CarritoController(CarritoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnName.setCellValueFactory(new PropertyValueFactory<>("producto"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        table.getItems().addAll(viewModel.getCarrito());
    }

    public void getData() {
        LineaCompra lineaCompra = table.getSelectionModel().getSelectedItem();
        if(lineaCompra != null) {
            txtNewQuantity.setText(String.valueOf(lineaCompra.getQuantity()));
        }

    }

    public void removeItemDelCarrito() {
        LineaCompra lineaCompra = table.getSelectionModel().getSelectedItem();
        if(lineaCompra != null) {
            if(viewModel.removeItem(lineaCompra)) {
                table.getItems().removeAll(table.getItems());
                table.getItems().addAll(viewModel.getCarrito());

            }
        }
    }

    public void pagarPorElCarrito() {

    }

    public void changeQuantity() {

    }
}
