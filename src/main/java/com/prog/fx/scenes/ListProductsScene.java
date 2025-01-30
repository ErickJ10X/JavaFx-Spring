package com.prog.fx.scenes;

import com.prog.fx.producto.ProductoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.stream.Collectors;

public class ListProductsScene {

    private ProductoController productoController;

    private Scene scene;

    public ListProductsScene(Stage stage) {
        VBox layout = new VBox();
        ListView<String> listView = new ListView<>();
        Button backButton = new Button("Back to Menu");
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));

        listView.setItems(getFromList());

        layout.getChildren().addAll(listView, backButton);
        scene = new Scene(layout, 800, 800);
    }

    private ObservableList<String> getFromList(){
        return FXCollections.observableArrayList(productoController.getProductsList().stream()
                .map(p -> "Id: " + p.getId() + " - Codigo: " + p.getCodigo() + " - Nombre: " + p.getNombre() + " - Cantidad: " + p.getCantidad() + " - Descripcion: " + p.getDescripcion())
                .collect(Collectors.toList()));
    }

    public Scene getScene() {
        return scene;
    }
}