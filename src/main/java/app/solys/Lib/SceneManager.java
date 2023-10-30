package app.solys.Lib;

import app.solys.App;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class SceneManager {
    private static final int width = 800;
    private static final int height = 500;

    public static Scene loadScene(String fxmlFile) throws IOException {
        System.out.println(App.class.getResource(fxmlFile));
        FXMLLoader sceneFXML = new FXMLLoader(App.class.getResource(fxmlFile));
        return new Scene(sceneFXML.load(), width, height);
    }

    public static void switchToMain(ActionEvent event, String title, String fxmlFileName) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene newScene = SceneManager.loadScene(fxmlFileName);
        stage.setTitle(title);
        stage.setScene(newScene);
    }

    public static void switchScenes(Event event, String title, String fxmlFileName) throws IOException {
        Tab sourceTab = (Tab) event.getSource();
        Stage stage = (Stage) sourceTab.getTabPane().getScene().getWindow();
        Scene newScene = SceneManager.loadScene(fxmlFileName);
        stage.setTitle(title);
        stage.setScene(newScene);
    }

    public static AnchorPane loadAnchor(String fxmlFile) throws IOException {
        System.out.println(App.class.getResource(fxmlFile));
        FXMLLoader anchorFXML = new FXMLLoader(App.class.getResource(fxmlFile));
        AnchorPane anchorPane = anchorFXML.load();
        return anchorPane;
    }
}
