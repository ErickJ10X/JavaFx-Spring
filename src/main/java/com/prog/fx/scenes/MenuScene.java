package com.prog.fx.scenes;

import com.prog.fx.FxApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MenuScene {

    public Scene getScene() {
        Button bAgregarProductoEscena = new Button("Agregar Nuevo Producto");
        Button bVerListaProducto = new Button("Ver Lista de Productos");
        Button bActualizarProducto = new Button("Actualizar Producto");
        Button bEliminarProducto = new Button("Eliminar Producto");

        bAgregarProductoEscena.setOnAction(e -> FxApplication.changeScene(new AgregarProductoScene().getScene()));
        bVerListaProducto.setOnAction(e -> FxApplication.changeScene(new VerListaProducto().getScene()));
        bActualizarProducto.setOnAction(e -> FxApplication.changeScene(new ActualizarProductoScene().getScene()));
        bEliminarProducto.setOnAction(e -> FxApplication.changeScene(new EliminarProductoScene().getScene()));

        VBox layout = new VBox(10, bAgregarProductoEscena, bVerListaProducto, bActualizarProducto, bEliminarProducto);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 800, 600);
    }
}
