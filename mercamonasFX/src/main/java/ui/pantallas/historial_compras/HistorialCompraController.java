package ui.pantallas.historial_compras;


import domain.modelo.producto.Producto;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class HistorialCompraController extends BasePantallaController implements Initializable {

    private final HistorialCompraViewModel viewModel ;

    @FXML
    public TableView<Producto> table;
    @FXML
    public TableColumn<Producto,String> columnName;
    @FXML
    public TableColumn<Producto,String> columnPrice;
    @FXML
    public TableColumn<Producto,String> columnQuantity;

    @Inject
    public HistorialCompraController(HistorialCompraViewModel viewModel) {
        this.viewModel = viewModel;
    }



    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("stock"));

        //table.setItems(viewModel.getProductos());


//        MFXTableColumn<Cromo> collecionColumn = new MFXTableColumn<>("collecion", true, Comparator.comparing(Cromo::getCollecion));
//        MFXTableColumn<Cromo> descriptionColumn = new MFXTableColumn<>("descripcion", true, Comparator.comparing(Cromo::getDescripcion));
//        MFXTableColumn<Cromo> numberColumn = new MFXTableColumn<>("numero", true, Comparator.comparing(Cromo::getNumero));
//        collecionColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cromo::getCollecion));
//        descriptionColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cromo::getDescripcion));
//        numberColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cromo::getNumero));
//
//
//        tabla.getTableColumns().addAll(collecionColumn, descriptionColumn, numberColumn);


    }
}
