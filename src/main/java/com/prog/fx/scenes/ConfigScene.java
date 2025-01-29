package com.prog.fx.scenes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prog.fx.FxApplication;
import com.prog.fx.producto.Producto;
import com.prog.fx.producto.ProductoService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigScene {

    private Scene scene;

    public ConfigScene(Stage stage) {
        VBox layout = new VBox();
        Button saveButton = new Button("Save to Database");
        Button exportButton = new Button("Export to JSON");
        Button backButton = new Button("Back to Menu");

        saveButton.setOnAction(e -> saveToDatabase(stage));
        exportButton.setOnAction(e -> exportToJson(stage));
        backButton.setOnAction(e -> stage.setScene(new MainMenuScene(stage).getScene()));

        layout.getChildren().addAll(saveButton, exportButton, backButton);
        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }

    private void saveToDatabase(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open JSON File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Producto producto = objectMapper.readValue(selectedFile, Producto.class);
                ConfigurableApplicationContext context = FxApplication.context;
                ProductoService productoService = context.getBean(ProductoService.class);
                productoService.save(producto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void exportToJson(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save JSON File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile != null) {
            ConfigurableApplicationContext context = FxApplication.context;
            ProductoService productoService = context.getBean(ProductoService.class);
            List<Producto> productos = productoService.findAll();

            List<Producto> productosToExport = productos.stream()
                    .map(p -> new Producto(p.getCodigo(), p.getNombre(), p.getCantidad(), p.getDescripcion()))
                    .collect(Collectors.toList());

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(selectedFile, productosToExport);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}