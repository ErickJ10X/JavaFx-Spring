package com.prog.fx.scenes;

import com.prog.fx.producto.ProductoController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class UpdateProductScene {

    private ProductoController productoController;

    private Scene scene;

    public UpdateProductScene(Stage stage) {
        VBox layout = new VBox();
        TextField idField = new TextField();
        idField.setPromptText("ID");
        TextField codigoField = new TextField();
        codigoField.setPromptText("Codigo");
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");
        TextField cantidadField = new TextField();
        cantidadField.setPromptText("Cantidad");
        TextField descripcionField = new TextField();
        descripcionField.setPromptText("Descripcion");
        Button updateButton = new Button("Update Product");
        updateButton.setOnAction(e -> updateProduct(idField, codigoField, nombreField, cantidadField, descripcionField));
        Button backButton = new Button("Back to Menu");
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));
        layout.getChildren().addAll(idField, codigoField, nombreField, cantidadField, descripcionField, updateButton, backButton);
        scene = new Scene(layout, 800, 800);
    }

    private void updateProduct(TextField idField, TextField codigoField, TextField nombreField, TextField cantidadField, TextField descripcionField) {
        long id = Long.parseLong(idField.getText());
        int codigo = Integer.parseInt(codigoField.getText());
        String nombre = nombreField.getText();
        String cantidad = cantidadField.getText();
        String descripcion = descripcionField.getText();
        productoController.updateFromList(id, codigo, nombre, cantidad, descripcion);
    }
}