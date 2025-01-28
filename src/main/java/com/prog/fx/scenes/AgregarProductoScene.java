package com.prog.fx.scenes;

import com.prog.fx.FxApplication;
import com.prog.fx.producto.Productos;
import com.prog.fx.producto.productoController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AgregarProductoScene {
    private productoController productorController = new productoController();
    public Scene getScene() {
        Label codigoLabel = new Label("Codigo:");
        TextField codigoField = new TextField();

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label cantidadLabel = new Label("Cantidad:");
        TextField cantidadField = new TextField();

        Label descripcionLabel = new Label("Descripcion:");
        TextArea descripcionField = new TextArea();

        Button submitButton = new Button("Agregar Producto");
        submitButton.setOnAction(e -> {
            String codigoText = codigoField.getText();
            String nombre = nombreField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            String descripcion = descripcionField.getText();

            Productos producto;
            if (codigoText.isEmpty()) {
                producto = new Productos(nombre, cantidad, descripcion);
            } else {
                long codigo = Long.parseLong(codigoText);
                producto = new Productos(codigo, nombre, cantidad, descripcion);
            }

            productorController.guardarProducto(producto);

            FxApplication.changeScene(new MenuScene().getScene());
        });

        Button backButton = new Button("Back to Main Scene");
        backButton.setOnAction(_ -> FxApplication.changeScene(new MenuScene().getScene()));

        VBox layout = new VBox(10, codigoLabel, codigoField, nombreLabel, nombreField, cantidadLabel, cantidadField, descripcionLabel, descripcionField, submitButton, backButton);
        return new Scene(layout, 800, 600);
    }
}
