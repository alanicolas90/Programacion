package ui.pantallas.compra;

import domain.modelo.producto.Producto;
import jakarta.inject.Inject;
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

public class CompraController extends BasePantallaController implements Initializable {

    @FXML
    public TableView<Producto> table;
    @FXML
    public TableColumn<String, Producto> columnNombre;
    @FXML
    public TableColumn<String, Producto> columnPrice;
    @FXML
    public TableColumn<String, Producto> columnStock;
    @FXML
    public TextField cantProducto;
    private final CompraViewModel viewModel;

    @Inject
    public CompraController(CompraViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getItems().addAll(viewModel.getProductos());


    }

    public void meterAlCarrito() {
        Producto productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null && cantProducto.getText() != null) {
            if(viewModel.meterAlCarrito(productTabla, Integer.parseInt(cantProducto.getText()))) {
                table.getItems().removeAll(table.getItems());
                table.getItems().addAll(viewModel.getProductos());
            }
        }
    }
}
