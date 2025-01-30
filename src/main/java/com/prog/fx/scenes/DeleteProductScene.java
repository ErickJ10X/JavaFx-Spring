package com.prog.fx.scenes;


import com.prog.fx.producto.ProductoController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteProductScene {

    private ProductoController controller;
    private Scene scene;

    public DeleteProductScene(Stage stage) {
        VBox layout = new VBox();
        TextField idField = new TextField();
        idField.setPromptText("ID");
        Button deleteButton = new Button("Delete Product");
        deleteButton.setOnAction(e -> deleteProduct(idField));
        Button backButton = new Button("Back to Menu");
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));
        layout.getChildren().addAll(idField, deleteButton, backButton);
        scene = new Scene(layout, 800, 800);
    }

    public Scene getScene() {
        return scene;
    }

    private void deleteProduct(TextField idField) {
        controller.deleteFromList(Integer.parseInt(idField.getText()));
    }
}