package com.prog.fx.scenes;


import com.prog.fx.producto.ProductoController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddProductScene {

    private ProductoController productoController;

    private Scene scene;

    public AddProductScene(Stage stage) {
        VBox layout = new VBox();
        TextField codigoField = new TextField();
        codigoField.setPromptText("Codigo");
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");
        TextField cantidadField = new TextField();
        cantidadField.setPromptText("Cantidad");
        TextField descripcionField = new TextField();
        descripcionField.setPromptText("Descripcion");
        Button saveButton = new Button("Save Product");
        saveButton.setOnAction(e -> saveProduct(codigoField, nombreField, cantidadField, descripcionField));
        Button backButton = new Button("Back to Menu");
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));
        layout.getChildren().addAll(codigoField, nombreField, cantidadField, descripcionField, saveButton, backButton);
        scene = new Scene(layout, 800, 800);
    }

    public Scene getScene() {
        return scene;
    }

    private void saveProduct(TextField codigoField, TextField nombreField, TextField cantidadField, TextField descripcionField) {
        int codigo = Integer.parseInt(codigoField.getText());
        String nombre = nombreField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());
        String descripcion = descripcionField.getText();
        productoController.saveProductOnList(codigo,nombre,cantidad,descripcion);
    }
}