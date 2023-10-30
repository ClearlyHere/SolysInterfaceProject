package app.solys.Controller;

import app.solys.Lib.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController extends AbstractController implements Initializable {
    @FXML
    protected Label clientsTitle = new Label("Clients");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane clientsAnchor = SceneManager.loadAnchor("clients.fxml");
            clientsTab.setContent(clientsAnchor);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}