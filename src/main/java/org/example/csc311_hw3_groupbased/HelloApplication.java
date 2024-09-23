package org.example.csc311_hw3_groupbased;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;

    public void start(Stage primarystage) throws IOException {
        Pane root = new Pane();


        // Load the maze and robot images
        Image maze = new Image(getClass().getResourceAsStream("/org/example/csc311_hw3_groupbased/images/maze.png"));
        ImageView mazeView = new ImageView(maze);
        root.getChildren().add(mazeView);

        Image robot = new Image(getClass().getResourceAsStream("/org/example/csc311_hw3_groupbased/images/robot.png"));
        ImageView robotView = new ImageView(robot);
        root.getChildren().add(robotView);

        //Get Pixel reader for maze image

        PixelReader pixelReader = maze.getPixelReader();

        Scene scene =new Scene(root, 800, 600);

        // Initial position of the robot
        robotView.setX(50);
        robotView.setY(50);

        // Create pane to add the images

        // Set key listener for horizontal movement
        scene.setOnKeyPressed(e -> {
            double step = 5.0;
            double newX = robotView.getX();
            double newY = robotView.getY();

            switch (e.getCode()){
                case UP:
                    newY -= step;
                    break;
                case DOWN:
                    newY += step;
                    break;
                case LEFT:
                    newX -= step;
                    break;
                case RIGHT:
                    newX += step;
                    break;
                default:
                    break;
            }
            if (!isWall(newX, newY, robotView.getFitWidth(), robotView.getFitHeight(), pixelReader)) {
                robotView.setX(newX);
                robotView.setY(newY);
            }
        });

        // Set the scene and show the stage
        primarystage.setScene(scene);
        primarystage.setTitle("Maze Image with Collision Detection");
        primarystage.show();
        root.requestFocus();
    }

    // Function to check if the player hits a wall (based on pixel color)
    private boolean isWall(double x, double y, double width, double height, PixelReader pixelReader) {
        // Check a few pixels of the player's rectangle area to detect collision
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Get the color of the pixel at (x + i, y + j)
                Color color = pixelReader.getColor((int) (x + i), (int) (y + j));

                // Assuming walls are black (or any dark color), adjust as per your image
                if (color.equals(Color.BLUE)) {
                    return true; // Collision detected
                }
            }
        }
        return false;
    }



    public void Maze2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maze2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Maze!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
