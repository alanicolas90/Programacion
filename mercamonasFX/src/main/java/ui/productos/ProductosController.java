package ui.productos;

import config.Configuration;
import dao.BBDD;
import di.GsonProducer;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.producto.Producto;
import modelo.producto.ProductoNormal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductosController implements Initializable {
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

    private ProductoViewModel viewModel;

    public ProductosController() {

    }

    private BBDD db;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnStock.setCellValueFactory(new PropertyValueFactory<>("stock"));


        table.getItems().addAll(db.loadProducto());
    }

    @FXML
    private void add() {

        ProductoNormal nuevoProduct = new ProductoNormal(txtNombre.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText()));
        boolean contains = !table.getItems().contains(nuevoProduct);
        if (contains && nuevoProduct.getPrice() > 0 && nuevoProduct.getStock() >= 0) {
            viewModel.agregarProducto(nuevoProduct);
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


    // String nombre = txtNombre.getText().isEmpty() ? "usuario" : txtNombre.getText();
    // String price = txtPrice.getText().isEmpty() ? "0" : txtPrice.getText();
    // String stock = txtStock.getText().isEmpty() ? "0" : txtStock.getText();
    // Producto p = new Producto(nombre, Double.parseDouble(price), Integer.parseInt(stock));
    // table.getItems().add(p);
}


