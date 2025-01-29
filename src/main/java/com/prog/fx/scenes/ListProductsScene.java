package com.prog.fx.scenes;

import com.prog.fx.FxApplication;
import com.prog.fx.producto.Producto;
import com.prog.fx.producto.ProductoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class ListProductsScene {

    private Scene scene;

    public ListProductsScene(Stage stage) {
        VBox layout = new VBox();
        ListView<String> listView = new ListView<>();
        Button backButton = new Button("Back to Menu");
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));

        ConfigurableApplicationContext context = FxApplication.context;
        ProductoService productoService = context.getBean(ProductoService.class);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Producto producto : productoService.findAll()) {
            items.add("Id: " + producto.getId() + " - Codigo: " + producto.getCodigo() + " - Nombre: " + producto.getNombre() + " - Cantidad: " + producto.getCantidad() + " - Descripcion: " + producto.getDescripcion());
        }
        listView.setItems(items);

        layout.getChildren().addAll(listView, backButton);
        scene = new Scene(layout, 800, 800);
    }

    public Scene getScene() {
        return scene;
    }
}