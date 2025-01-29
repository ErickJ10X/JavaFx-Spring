package com.prog.fx.scenes;

import com.prog.fx.producto.ProductoController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ConfigScene {

    private ProductoController productoController;

    private Scene scene;

    public ConfigScene(Stage stage) {
        VBox layout = new VBox();
        Button saveButton = new Button("Save to Database");
        Button exportButton = new Button("Export to JSON");
        Button backButton = new Button("Back to Menu");

        saveButton.setOnAction(e -> saveToDatabase(stage));
        exportButton.setOnAction(e -> exportToJson(stage));
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));

        layout.getChildren().addAll(saveButton, exportButton, backButton);
        scene = new Scene(layout, 800, 800);
    }

    public Scene getScene() {
        return scene;
    }

    private void saveToDatabase(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open JSON File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            productoController.saveToList(selectedFile);
        }
    }

    private void exportToJson(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save JSON File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile != null) {
            productoController.exportToJson(selectedFile);
        }
    }
}