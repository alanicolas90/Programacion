package ui.pantallas.billeteras;

import jakarta.inject.Inject;
import javafx.fxml.Initializable;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class BilleterasController extends BasePantallaController implements Initializable {
    private BilleterasViewModel viewModel;

    @Inject
    public BilleterasController(BilleterasViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
