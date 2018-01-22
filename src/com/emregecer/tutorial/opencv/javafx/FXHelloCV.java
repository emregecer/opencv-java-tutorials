package com.emregecer.tutorial.opencv.javafx;
	
import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXHelloCV extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// load the FXML resource
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FXHelloCV.fxml"));
			
			// store the root element so that the controllers can use it
			BorderPane root = (BorderPane) loader.load();
			
			// create and style a scene
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// create the stage with the given title and the previously created scene
			primaryStage.setTitle("JavaFX meets with OpenCV");
			primaryStage.setScene(scene);
			
			// show the GUI
			primaryStage.show();
			
			// set the proper behavior on closing the application
			FXHelloCVController controller = loader.getController();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					controller.setClosed();
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// load the native OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		launch(args);
	}
}
