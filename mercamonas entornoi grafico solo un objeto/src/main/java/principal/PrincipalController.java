package principal;

import common.Common;
import dao.DaoClientes;
import servicios.ServicioClients;
import modelo.Cliente;
import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Cliente;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {


    @FXML
    private MFXTableView<Cliente> mfxTable;
    @FXML
    private Common common;

    private final String nombreDefecto = "Alejandro";
    @FXML
    private MFXTextField nombre;
    @FXML
    private MFXTextField edad;
    @FXML
    private MFXButton borrar;
    @FXML
    private MFXComboBox combo2;
    @FXML
    private MFXDatePicker fecha;
    @FXML
    private MFXListView<Cliente> listado;
    @FXML
    private MFXComboBox<String> combo;

    private PrincipalViewModel viewModel;

    @FXML
    private TableColumn<Cliente, String> columnNombre;
    @FXML
    private TableColumn<Cliente, Integer> columnEdad;

    @FXML
    private TableView<Cliente> table;

    @FXML
    private TextField txtNombre;


    @FXML
    private void saludar() {
        viewModel.addPersona(new Cliente(nombreDefecto, "10"));
        viewModel.getState().get().getPersonas().add(new Cliente(nombreDefecto, "1220"));

        String nombre = !txtNombre.getText().isBlank()
                ? txtNombre.getText() : nombreDefecto;
        String text = "hola " + nombre;
        fecha.setValue(LocalDate.of(2019, 1, 1));

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(text);
        a.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        table.setItems(viewModel.getState().get().getPersonas());
        combo.getItems().addAll("Alejandro", "Pedro", "Juan");
        List<Cliente> personas = new ArrayList<>();

        personas.add(new Cliente("10", "Pedro"));
        personas.add(new Cliente("20","Jose"));
        personas.add(new Cliente("30","Juan"));

        listado.getItems().addAll(personas);

        listado.getSelectionModel().setAllowsMultipleSelection(false);

        fecha.setValue(LocalDate.of(2019, 1, 1));

        viewModel.getState().addListener((observable, oldValue, newValue) -> {
            if (newValue.getError() != null) {
                //sacar un alert
            }
        });


        listado.getSelectionModel().selectionProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.values().stream().findFirst().ifPresent(p -> {
                    nombre.setText(p.getNombre());
                    edad.setText(p.getDni());
                });
            }
        });

        // tabla materialFX
        MFXTableColumn<Cliente> nameColumn = new MFXTableColumn<>("nombre", true, Comparator.comparing(Cliente::getNombre));
        nameColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cliente::getNombre));

        mfxTable.getTableColumns().addAll(nameColumn);
        mfxTable.getFilters().addAll(
                new StringFilter<>("Name", Cliente::getNombre)
        );
        mfxTable.setItems(viewModel.getState().get().getPersonas());
        mfxTable.getSelectionModel().selectionProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.values().stream().findFirst().ifPresent(p -> {
                    nombre.setText(p.getNombre());
                    edad.setText(p.getDni());
                });
            }
        });

    }

    @FXML
    private void verSeleccionTabla(ActionEvent actionEvent) {

        Cliente p = table.getSelectionModel().getSelectedItem();
        if (p != null) {
            viewModel.updatePersona(new Cliente(p.getDni(), p.getNombre()));
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(p.getNombre());
            a.showAndWait();
        }
    }

    @FXML
    private void selection(ActionEvent actionEvent) {
        String nombre = combo.getSelectionModel().getSelectedItem();
        if (nombre != null) {

            combo2.getItems().clear();
            switch (nombre) {
                case "Alejandro":
                    combo2.getItems().addAll("Moreno", "malote", "guappo");
                    break;
                case "Pedro":
                    combo2.getItems().addAll("pollavieja", "marichulo", "gordo");
                    break;
                case "Juan":
                    combo2.getItems().addAll("papagayo", "papagayo", "papagayo");
                    break;
            }
        }
    }


    @FXML
    private void borrarElemento(ActionEvent actionEvent) {
        Cliente p = listado.getSelectionModel().getSelection().values().stream().findFirst().orElse(null);
        if (p != null) {
            listado.getItems().remove(p);
        }
    }


    @FXML
    private void update(MouseEvent mouseEvent) {
        Cliente p = listado.getSelectionModel().getSelection().values().stream().findFirst().orElse(null);
        if (p != null) {
//            nombre.setText(p.getNombre());
//            edad.setText(p.getEdad().toString());
        }
    }
}
