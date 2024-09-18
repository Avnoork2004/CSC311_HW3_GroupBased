package org.example.csc311_hw3_groupbased;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HelloController {

 @FXML
 private ImageView Bot;  // ImageView for the robot in Maze 1

 @FXML
 private Button SwitchToMaze2Button;  // Button to switch from Maze 1 to Maze 2

 @FXML
 private Button animateButton;  // Button to start the robot animation in Maze 1

 @FXML
 private ImageView maze1;  // ImageView displaying Maze 1

 @FXML
 private ImageView Car;  // ImageView for the car in Maze 2

 @FXML
 private Button SwitchToMaze1Button;  // Button to switch from Maze 2 to Maze 1

 @FXML
 private Button animateButton2;  // Button to start the car animation in Maze 2

 @FXML
 private Pane carPane;  // Pane for placing the car in Maze 2

 private Timeline robotTimeline;  // Timeline for animating the robot in Maze 1
 private Timeline carTimeline;    // Timeline for animating the car in Maze 2

 // Starts animation for moving the robot in Maze 1
 @FXML
 void AnimationStart(ActionEvent event) {
  if (robotTimeline != null && robotTimeline.getStatus() == Timeline.Status.RUNNING) {
   robotTimeline.stop();  // Stop any existing animation before starting a new one
  }

  // Create a new timeline to move the robot horizontally
  robotTimeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
   Bot.setX(Bot.getX() + 5);  // Move the robot to the right by 5 pixels
   if (Bot.getX() >= maze1.getFitWidth()) {  // Stop animation if robot reaches the end of the maze
    robotTimeline.stop();
   }
  }));
  robotTimeline.setCycleCount(Timeline.INDEFINITE);  // Loop the animation indefinitely
  robotTimeline.play();  // Start the animation
 }

 // Starts animation for moving the car in Maze 2
 @FXML
 void AnimationStart2(ActionEvent event) {
  if (carTimeline != null && carTimeline.getStatus() == Timeline.Status.RUNNING) {
   carTimeline.stop();  // Stop any existing animation before starting a new one
  }

  // Create a new timeline to move the car horizontally
  carTimeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
   Car.setX(Car.getX() + 5);  // Move the car to the right by 5 pixels
   if (Car.getX() >= carPane.getWidth()) {  // Stop animation if car reaches the end of the pane
    carTimeline.stop();
   }
  }));
  carTimeline.setCycleCount(Timeline.INDEFINITE);  // Loop the animation indefinitely
  carTimeline.play();  // Start the animation
 }

 // Switches from Maze 1 to Maze 2
 @FXML
 void SwitchToMaze2(ActionEvent event) {
  Stage stage = (Stage) SwitchToMaze2Button.getScene().getWindow();  // Get the current stage
  HelloApplication app = (HelloApplication) stage.getUserData();  // Retrieve the application instance from the stage
  try {
   app.switchToMaze2();  // Call method to switch to Maze 2
  } catch (IOException e) {
   e.printStackTrace();  // Handle exception if there's an issue loading Maze 2
  }
 }

 // Switches from Maze 2 to Maze 1
 @FXML
 void SwitchToMaze1(ActionEvent event) {
  Stage stage = (Stage) SwitchToMaze1Button.getScene().getWindow();  // Get the current stage
  HelloApplication app = (HelloApplication) stage.getUserData();  // Retrieve the application instance from the stage
  try {
   app.switchToMaze1();  // Call method to switch to Maze 1
  } catch (IOException e) {
   e.printStackTrace();  // Handle exception if there's an issue loading Maze 1
  }
 }
}

