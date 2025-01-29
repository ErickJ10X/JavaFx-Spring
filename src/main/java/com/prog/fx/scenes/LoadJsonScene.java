package com.prog.fx.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LoadJsonScene {

    private Scene scene;

    public LoadJsonScene(Stage stage) {
        VBox layout = new VBox();
        Label label = new Label("Load a JSON file:");
        Button button = new Button("Load JSON");
        button.setOnAction(e -> loadJsonFile(stage));
        layout.getChildren().addAll(label, button);
        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }

    private void loadJsonFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            stage.setScene(new MainMenuScene(stage).getScene());
        }
    }
}