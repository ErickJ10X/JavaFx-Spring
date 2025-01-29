package com.prog.fx;

import com.prog.fx.scenes.LoadJsonScene;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FxApplication extends Application {

	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(FxApplication.class, args);
		launch();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Product Management");
		stage.setScene(new LoadJsonScene(stage).getScene());
		stage.show();
	}
}