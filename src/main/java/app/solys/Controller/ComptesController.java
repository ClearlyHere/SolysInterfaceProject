package app.solys.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ComptesController extends AbstractController implements Initializable {
    public TabPane windowsTab;
    @FXML
    protected Label comptesTitle = new Label("Comptes");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
