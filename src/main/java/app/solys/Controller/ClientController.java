package app.solys.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController extends AbstractController implements Initializable {
    @FXML
    protected Label clientsTitle = new Label("Clients");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}