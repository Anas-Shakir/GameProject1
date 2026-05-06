package com.example.gameproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

import java.awt.*;

import static javafx.scene.input.KeyCode.*;

public class Launcher extends Application{

    @Override
    public void start(Stage primaryStage){

        // procedure
        // start from base node
        // add to the upper node (container) by getchildren.addall()
        // In the above the order matters
        // then give the top level one to the scene
        // Give scene to the stage


//        scene 1
        // making scene



        VBox uiLayerMainScreen = new VBox();

        StackPane root = new StackPane();
        root.setBackground(new Background( new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setAlignment(Pos.CENTER);

        Scene s = new Scene(root, 400, 400);


//        scene 2





//        stages

        // Label and buttons
        Label title = new Label("Welcome to the Game Human");
//        Label play = new Label("Play");
        Button playButton = new Button("I love Aether");


        // create the player
//        Rectangle player = new Rectangle(40,40 , Color.DODGERBLUE);

        // adding the player
        javafx.scene.image.Image playerImage = new javafx.scene.image.Image(getClass().getResourceAsStream("/ch1.png"));
        javafx.scene.image.ImageView player = new javafx.scene.image.ImageView(playerImage);

        player.setFitWidth(40);
        player.setFitHeight(40);
        player.setPreserveRatio(true);


        // inner thing properties
        title.setFont(Font.font("Aerial", FontWeight.BOLD, 24));
        title.setTextFill(Color.WHITE);
//        play.setTextFill(Color.WHITE);
        playButton.setStyle(
                "-fx-background-color:  #f5f5dc"
        );

        // events
        playButton.setOnMouseEntered(e -> playButton.setStyle("-fx-background-color: #ff7f50"));
        playButton.setOnMouseExited(e -> playButton.setStyle("-fx-background-color:  #f5f5dc"));

        // root things
        VBox.setMargin(title, new Insets(0,0,50,0));
//        root.setCenter(play);
        root.getChildren().addAll(title, playButton);


        // map screen switching
        // make the button
        Button btdBackToMain = new Button("Go To Main Screen");
        StackPane map1Layout = new StackPane();


        map1Layout.getChildren().addAll(player, btdBackToMain);



        Scene map1 = new Scene(map1Layout, 400, 300);


        playButton.setOnAction(
                e -> {
                    primaryStage.setScene(map1);
                    map1Layout.requestFocus();
                }
        );
        btdBackToMain.setOnAction(e -> primaryStage.setScene(s));
        // input settings
        map1.setOnKeyPressed(event -> {
            // taking contant speed
            double movementSpeed = 10;

            switch (event.getCode()){
                case UP:
                    player.setY(player.getY() - movementSpeed); break;
                case DOWN:
                    player.setY(player.getY() + movementSpeed);break;
                case RIGHT:
                    player.setX(player.getX() + movementSpeed);break;
                case LEFT:
                    player.setX(player.getX() - movementSpeed);break;
                default: break;

            }
        });

        // Stage setting
        primaryStage.setTitle("Game Project");
        primaryStage.setScene(s);
        primaryStage.show();

    }

    public static void main(String[] args) {
//        Application.launch(HelloApplication.class, args);
        launch(args);
    }
}
