package com.prog.fx;

import com.prog.fx.scenes.MenuScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FxApplication extends Application {

	public static Stage mainStage;
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(FxApplication.class, args);
		launch();
	}

	@Override
	public void start(Stage stage) {
		mainStage = stage;
		MenuScene menuScene = new MenuScene();
		mainStage.setScene(menuScene.getScene());
		mainStage.setTitle("JavaFX with Spring Boot");
		mainStage.show();
	}

	public static void changeScene(Scene scene) {
		mainStage.setScene(scene);
	}
}
