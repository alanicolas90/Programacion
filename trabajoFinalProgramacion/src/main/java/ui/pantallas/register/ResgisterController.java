package ui.pantallas.register;

import domain.modelo.usuario.Usuario;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ui.pantallas.common.BasePantallaController;

public class ResgisterController extends BasePantallaController {
    @FXML
    public TextField txtUsername;
    @FXML
    public TextField txtPassword;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtSurname;
    @FXML
    public TextField txtCorreo;
    @FXML
    public TextField txtDinero;
    @FXML
    public Button bttnRegister;

    RegisterViewModel viewModel;

    @Inject
    public ResgisterController(RegisterViewModel viewModel) {
        this.viewModel = viewModel;
    }


    public void registerUser() {
        boolean ok= true;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (txtUsername.getText().replace(" ", "").equals("")) {
            alert.setContentText("El usuario no valido");
            alert.showAndWait();
            ok = false;
        } else if (viewModel.usernameExist(txtUsername.getText())) {
            alert.setContentText("El usuario ya existe");
            alert.showAndWait();
            ok = false;
        } else if (txtPassword.getText().length() < 8) {
            alert.setContentText("La contraseña debe tener al menos 8 caracteres");
            alert.showAndWait();
            ok = false;
        } else if (txtName.getText().replace(" ", "").equals("")) {
            alert.setContentText("Debe rellenar el nombre");
            alert.showAndWait();
            ok = false;
        } else if (txtSurname.getText().replace(" ", "").equals("")) {
            alert.setContentText("Debe rellenar el apellido");
            alert.showAndWait();
            ok = false;
        } else if (txtCorreo.getText().replace(" ", "").equals("") || !txtCorreo.getText().contains("@gmail.com")) {
            alert.setContentText("Correo no valido");
            alert.showAndWait();
            ok = false;
        } else if (viewModel.emailExist(txtCorreo.getText())) {
            alert.setContentText("Correo ya existe");
            alert.showAndWait();
            ok = false;
        }

        try {
            Double.parseDouble(txtDinero.getText());
        } catch (NumberFormatException e) {
            alert.setContentText("Dinero formato no valido");
            alert.showAndWait();
            ok = false;
        }

        if(ok){
            Usuario user = new Usuario(txtUsername.getText(), txtPassword.getText(), txtName.getText(), txtSurname.getText(), txtCorreo.getText(), Double.parseDouble(txtDinero.getText()));
            viewModel.registerUser(user);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Usuario creado con exito");
            alerta.showAndWait();
            this.getPrincipalController().onRegisterFinish();
        }



    }

    public void backToLogin() {
        this.getPrincipalController().onRegisterFinish();
    }
}
