package com.prog.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FxApplication extends Application {

	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		launch();
		SpringApplication.run(FxApplication.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		context = SpringApplication.run(FxApplication.class);
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/prog/fx/Main.fxml"));
		fxml.setControllerFactory(context::getBean);
		Scene scene = new Scene(fxml.load());
		stage.setTitle("Tarea - Programacion N4");
		stage.setScene(scene);
		stage.show();
	}
}
