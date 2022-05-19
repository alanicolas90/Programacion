package ui.pantallas.series;


import domain.modelo.Episodio;
import domain.modelo.Serie;
import jakarta.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class SeriesController extends BasePantallaController  implements Initializable {

@FXML
    public Button bttnAdd;
    public TextField txtNombreSerie;
    public TableView<Serie> tableSeries;
    public TableColumn<Object, Object> columnNombre;
    public TableColumn<Object, Object> columnValoracion;
    public TableColumn<Object, Object> columnVisto;
    public TableColumn<Object, Object> columnEpisodios;
    public TableView<domain.modelo.Episodio> tableEpisodios;
    public TableColumn<Object, Object> columnIdEpisodio;
    public TableColumn<Object, Object> columnActores;
    public TextField txtNombreEpisodio;
    public Button bttnAddEpisodio;
    public TableView tableActores;
    public TextField txtNombreActor;
    public Button bttnAddActor;
    public TableColumn columnActoresTableActores;


    private SeriesViewModel viewModel;

    @Inject
    public SeriesController(SeriesViewModel viewModel) {
        this.viewModel = viewModel;
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nameSerie"));
        columnValoracion.setCellValueFactory(new PropertyValueFactory<>("valoracion"));
        columnVisto.setCellValueFactory(new PropertyValueFactory<>("visto"));
        columnEpisodios.setCellValueFactory(new PropertyValueFactory<>("episodios"));

        //--------
        columnIdEpisodio.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnActores.setCellValueFactory(new PropertyValueFactory<>("actores"));

        //--------
        columnActoresTableActores.setCellValueFactory(new PropertyValueFactory<>("name"));


        tableSeries.getItems().addAll(viewModel.getSeries());
    }

    public void addSerie() {
        Serie serie = new Serie(txtNombreSerie.getText());
        if(viewModel.addSerie(serie)){
            tableSeries.getItems().removeAll(viewModel.getSeries());
            tableSeries.getItems().addAll(viewModel.getSeries());
        }

    }

    public void remove(ActionEvent actionEvent) {

    }


    public void addEpisodio(ActionEvent actionEvent) {
        Episodio episodio = new Episodio( txtNombreEpisodio.getText());
        Serie serie = tableSeries.getSelectionModel().getSelectedItem();
        if(episodio!= null){
            if(viewModel.addEpisodio(episodio, serie)){
                tableEpisodios.getItems().removeAll(tableEpisodios.getItems());
                tableEpisodios.getItems().addAll(viewModel.getEpisodios(serie));
            }
        }

    }

    public void addActor(ActionEvent actionEvent) {

    }

    public void updateTableEpisodios(MouseEvent mouseEvent) {
        Serie serie = tableSeries.getSelectionModel().getSelectedItem();
        if(serie != null){
            tableSeries.getItems().removeAll(tableSeries.getItems());
            tableSeries.getItems().addAll(viewModel.getSeries());

            tableEpisodios.getItems().removeAll(tableEpisodios.getItems());
            tableEpisodios.getItems().addAll(viewModel.getEpisodios(serie));
        }
    }

    public void updateTableActores(MouseEvent mouseEvent) {
        Serie serie = tableSeries.getSelectionModel().getSelectedItem();
        Episodio episodio = tableEpisodios.getSelectionModel().getSelectedItem();
        if(episodio != null){
            tableSeries.getItems().removeAll(tableSeries.getItems());
            tableSeries.getItems().addAll(viewModel.getSeries());

            tableEpisodios.getItems().removeAll(tableEpisodios.getItems());
            tableEpisodios.getItems().addAll(viewModel.getEpisodios(serie));

            tableActores.getItems().removeAll(tableActores.getItems());
            tableActores.getItems().addAll(viewModel.getActores(serie,episodio));
        }
    }
}
