package ui.pantallas.funcionesUsuario;



import domain.modelo.Serie;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FuncionesUsuarioController extends BasePantallaController implements Initializable {

    private final FuncionesUsuarioViewModel viewModel ;

    @FXML
    public TableView<Serie> table;
    @FXML
    public TableColumn columnName;
    @FXML
    public TableColumn columnPrice;
    @FXML
    public TableColumn columnQuantity;
    @FXML
    public TableColumn columnNombre;
    @FXML
    public TableColumn columnValoracion;
    @FXML
    public TableColumn columnVisto;
    @FXML
    public TableColumn columnEpisodios;
    @FXML
    public MFXTextField valoracion;
    @FXML
    public MFXTextField visto;

    @Inject
    public FuncionesUsuarioController(FuncionesUsuarioViewModel viewModel) {
        this.viewModel = viewModel;
    }



    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nameSerie"));
        columnValoracion.setCellValueFactory(new PropertyValueFactory<>("valoracion"));
        columnVisto.setCellValueFactory(new PropertyValueFactory<>("visto"));
        columnEpisodios.setCellValueFactory(new PropertyValueFactory<>("episodios"));

        table.getItems().addAll(viewModel.getSeries());
    }


    public void update() {
        Serie serie = table.getSelectionModel().getSelectedItem();

        valoracion.setText(String.valueOf(serie.getValoracion()));
        visto.setText(String.valueOf(serie.isVisto()));
    }

    public void updateValoracion(MouseEvent mouseEvent) {
        Serie serie = table.getSelectionModel().getSelectedItem();
        String valo = valoracion.getText();
        if(serie != null) {
            if(viewModel.updateValoracion(serie, valo)) {
                table.getItems().removeAll(table.getItems());
                table.getItems().addAll(viewModel.getSeries());
            }
        }
    }

    public void updateVisto(MouseEvent mouseEvent) {
        Serie serie = table.getSelectionModel().getSelectedItem();
        String bool = visto.getText();
        if(serie != null && (bool.equals("true") || bool.equals("false"))) {
            if(viewModel.updatebool(serie, bool)) {
                viewModel.updateListaSeriesVistas(serie);
                table.getItems().removeAll(table.getItems());
                table.getItems().addAll(viewModel.getSeries());
            }
        }
    }
}
