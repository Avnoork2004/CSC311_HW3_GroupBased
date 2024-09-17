package org.example.csc311_hw3_groupbased;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    private ImageView Bot;


   // NOTE: car might not be in the right spot, might change spot if needed
    @FXML
    private ImageView Car;

    @FXML
    private Button SwitchToMaze2Button;

    @FXML
    private Button SwitchToMaze1Button;

    @FXML
    private Button animateButton2;

    @FXML
    private Button animateButton;

    @FXML
    private ImageView maze1;



    //this is to start the Animation(maze 1)

    @FXML
    void AnimationStart(ActionEvent event) {

    }
    //this is to start the Animation(maze 2)

    @FXML
    void AnimationStart2(ActionEvent event) {

    }

    //this is to switch to Maze 2 from Maze 1


    @FXML
    void SwitchToMaze2(ActionEvent event) {

    }
    //this is to switch to Maze 1 from Maze 2

    @FXML
    void SwitchToMaze1(ActionEvent event) {}

}