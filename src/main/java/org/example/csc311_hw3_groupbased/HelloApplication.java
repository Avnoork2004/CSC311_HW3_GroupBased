package org.example.csc311_hw3_groupbased;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;  // Reference to the primary stage of the application

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;  // Store the primary stage for later use

        // Load the FXML file for Maze 1
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("maze1.fxml"));  // Load the FXML file for Maze 1
        Pane pane = fxmlLoader.load();  // Load the layout from the FXML file
        Scene scene = new Scene(pane, 800, 600);  // Create a new Scene with the loaded layout and set its size
        stage.setScene(scene);  // Set the Scene on the primary stage
        stage.setTitle("Maze 1");  // Set the title of the application window

        // Store a reference to this application instance in the stage
        stage.setUserData(this);

        stage.show();  // Display the primary stage
    }

    // Switches to Maze 2 by loading its FXML file and setting the scene
    public void switchToMaze2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("maze2.fxml"));  // Load the FXML file for Maze 2
        Pane pane = fxmlLoader.load();  // Load the layout from the FXML file
        Scene scene = new Scene(pane, 800, 600);  // Create a new Scene with the loaded layout and set its size
        stage.setScene(scene);  // Set the Scene on the primary stage
        stage.setTitle("Maze 2");  // Set the title of the application window
    }

    // Switches back to Maze 1 by loading its FXML file and setting the scene
    public void switchToMaze1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("maze1.fxml"));  // Load the FXML file for Maze 1
        Pane pane = fxmlLoader.load();  // Load the layout from the FXML file
        Scene scene = new Scene(pane, 800, 600);  // Create a new Scene with the loaded layout and set its size
        stage.setScene(scene);  // Set the Scene on the primary stage
        stage.setTitle("Maze 1");  // Set the title of the application window
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch();  // Launch the JavaFX application
    }
}
