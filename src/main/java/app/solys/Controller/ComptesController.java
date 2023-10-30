package app.solys.Controller;

import app.solys.Lib.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ComptesController extends AbstractController implements Initializable {
    @FXML
    protected Label comptesTitle = new Label("Comptes");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane comptesAnchor = SceneManager.loadAnchor("comptes.fxml");
            comptesTab.setContent(comptesAnchor);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
