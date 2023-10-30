package app.solys.Controller;

import app.solys.Lib.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController {
    @FXML
    protected Label welcomeText = new Label("Welcome to Solys!");

    @FXML
    protected void startAction(ActionEvent event) throws IOException {
        SceneManager.switchToMain(event, "Clients", "clients.fxml");
    }
}