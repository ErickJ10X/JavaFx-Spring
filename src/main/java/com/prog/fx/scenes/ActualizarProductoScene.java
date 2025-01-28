package com.prog.fx.scenes;

import com.prog.fx.FxApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ActualizarProductoScene {
    public Scene getScene() {
        Button backButton = new Button("Back to Main Scene");
        backButton.setOnAction(_ -> FxApplication.changeScene(new MenuScene().getScene()));

        VBox layout = new VBox(10, backButton);
        return new Scene(layout, 800, 600);
    }
}
