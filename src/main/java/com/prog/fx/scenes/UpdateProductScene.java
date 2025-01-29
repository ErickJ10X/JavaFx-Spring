package com.prog.fx.scenes;

import com.prog.fx.FxApplication;
import com.prog.fx.producto.Producto;
import com.prog.fx.producto.ProductoService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class UpdateProductScene {

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
        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }

    private void updateProduct(TextField idField, TextField codigoField, TextField nombreField, TextField cantidadField, TextField descripcionField) {
        ConfigurableApplicationContext context = FxApplication.context;
        ProductoService productoService = context.getBean(ProductoService.class);
        Long id = Long.parseLong(idField.getText());
        productoService.findById(id).ifPresent(producto -> {
            producto.setCodigo(Long.parseLong(codigoField.getText()));
            producto.setNombre(nombreField.getText());
            producto.setCantidad(Integer.parseInt(cantidadField.getText()));
            producto.setDescripcion(descripcionField.getText());
            productoService.save(producto);
        });
    }
}