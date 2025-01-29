package com.prog.fx.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene {

    private Scene scene;

    public MainMenuScene(Stage stage) {
        VBox layout = new VBox();
        Button addProductButton = new Button("Add Product");
        Button updateProductButton = new Button("Update Product");
        Button deleteProductButton = new Button("Delete Product");
        Button listProductsButton = new Button("List Products");
        Button configButton = new Button("Configuration");

        addProductButton.setOnAction(e -> stage.setScene(new AddProductScene(stage).getScene()));
        updateProductButton.setOnAction(e -> stage.setScene(new UpdateProductScene(stage).getScene()));
        deleteProductButton.setOnAction(e -> stage.setScene(new DeleteProductScene(stage).getScene()));
        listProductsButton.setOnAction(e -> stage.setScene(new ListProductsScene(stage).getScene()));
        configButton.setOnAction(e -> stage.setScene(new ConfigScene(stage).getScene()));

        layout.getChildren().addAll(addProductButton, updateProductButton, listProductsButton, deleteProductButton, configButton);
        scene = new Scene(layout, 800, 800);
    }

    public Scene getScene() {
        return scene;
    }
}