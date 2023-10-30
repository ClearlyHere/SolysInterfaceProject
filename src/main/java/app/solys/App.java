package app.solys;

import app.solys.Lib.SceneManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene welcomeScene = SceneManager.loadScene("welcome.fxml");

        stage.setTitle("Welcome");
        stage.setResizable(false);
        stage.setScene(welcomeScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}