package org.example.csc311_hw3_groupbased;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        // this is to load the maze and robot  (JS)
        Image maze = new Image(getClass().getResource("/images/maze.png").toString());
        ImageView mazeView = new ImageView(maze);

        Image robot = new Image(getClass().getResource("/images/robot.png").toString());
        ImageView  robotView = new ImageView(robot);

        //initial position of the robot
        robotView.setX(50);
        robotView.setY(50);


        //creating pane to add the images

        Pane pane = new Pane();
        pane.getChildren().addAll(mazeView, robotView);

        Scene scene = new Scene(pane, 800, 600 );
        // set key listenner for horizontal movement;

        scene.setOnKeyPressed( e -> {
            double currentX = robotView.getX();

            if (e.getCode() == KeyCode.RIGHT) {
                robotView.setX(currentX + 10);
            }
            else if (e.getCode() == KeyCode.LEFT){
                robotView.setX(currentX - 10);
            }
        });





    }
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maze1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("maze!");
        stage.setScene(scene);
        stage.show();
    }*/

    public void Maze2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maze2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("maze!");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}