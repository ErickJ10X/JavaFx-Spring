package com.prog.fx.scenes;

import com.prog.fx.FxApplication;
import com.prog.fx.producto.ProductoService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class DeleteProductScene {

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
        ConfigurableApplicationContext context = FxApplication.context;
        ProductoService productoService = context.getBean(ProductoService.class);
        Long id = Long.parseLong(idField.getText());
        productoService.deleteById(id);
    }
}