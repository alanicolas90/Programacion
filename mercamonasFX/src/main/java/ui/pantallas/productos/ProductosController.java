package ui.pantallas.productos;

import domain.modelo.producto.Producto;
import domain.modelo.producto.ProductoNormal;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductosController extends BasePantallaController  implements Initializable {


    @FXML
    private MFXTextField nombre;
    @FXML
    private MFXTextField precio;
    @FXML
    private MFXTextField stock;
    @FXML
    private Button bttnAdd;
    @FXML
    private Button bttnRemove;
    @FXML
    private Button bttnUpdate;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrice;
    @FXML
    private TableView<Producto> table;
    @FXML
    private TextField txtStock;
    @FXML
    private TableColumn<Producto, String> columnNombre;
    @FXML
    private TableColumn<Producto, Double> columnPrice;
    @FXML
    private TableColumn<Producto, Integer> columnStock;

    private final ProductoViewModel viewModel;


@Inject
    public ProductosController(ProductoViewModel viewModel) {
        this.viewModel = viewModel;
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getItems().addAll(viewModel.getProductos());
    }


//    @Override
//    public void principalCargado() {
//        //el principal cargado
//        String user = getPrincipalController().getActualUser().getNombre();
//    }

    @FXML
    private void add() {
        Producto nuevoProduct = new ProductoNormal(txtNombre.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText()));
        boolean contains = !table.getItems().contains(nuevoProduct);
        if (contains && nuevoProduct.getPrice() > 0 && nuevoProduct.getStock() >= 0) {
//            viewModel.agregarProducto(nuevoProduct);
//            table.getItems().removeAll();
            table.getItems().add(nuevoProduct);
        }
    }

    @FXML
    private void remove() {

        Producto productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null) {
            table.getItems().remove(productTabla);
        }

    }

    @FXML
    private void update() {

        Producto productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null) {
            nombre.setText(productTabla.getName());
            precio.setText(String.valueOf(productTabla.getPrice()));
            stock.setText(String.valueOf(productTabla.getStock()));
        }

    }

    public void updateData() {
        Producto productTabla = table.getSelectionModel().getSelectedItem();
        if (productTabla != null) {
            table.getItems().remove(productTabla);
            table.getItems().add(new ProductoNormal(nombre.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(stock.getText())));
        }


    }
}
