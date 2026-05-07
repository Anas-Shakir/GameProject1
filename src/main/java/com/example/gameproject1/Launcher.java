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
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

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

        // node 1.1
            // Label and buttons
        Label title = new Label("Welcome to the Game Human");

        // properties
        title.setFont(Font.font("Aerial", FontWeight.BOLD, 24));
        title.setTextFill(Color.WHITE);

        // node 1.2
        Button playButton = new Button("Enter the World");

        // Animation
        playButton.setTranslateY(500);
        TranslateTransition slideUp = new TranslateTransition(Duration.seconds(3), playButton);
        slideUp.setToY(0);

        slideUp.play();
            // properties
        playButton.setStyle(
                "-fx-background-color:  #f5f5dc"
        );
            // events
        playButton.setOnMouseEntered(e -> playButton.setStyle("-fx-background-color: #ff7f50"));
        playButton.setOnMouseExited(e -> playButton.setStyle("-fx-background-color:  #f5f5dc"));

        // node 1
        VBox uiLayerMainScreen = new VBox();
        uiLayerMainScreen.getChildren().addAll(title, playButton);
        uiLayerMainScreen.setAlignment(Pos.CENTER);
        VBox.setMargin(title, new Insets(0,0,50,0));


        // root scene 1
        StackPane root = new StackPane();
        root.getChildren().addAll(uiLayerMainScreen);
            // properties
        root.setBackground(new Background( new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setAlignment(Pos.CENTER);


        Scene s = new Scene(root, 400, 400);


//        scene 2

        // node 1.1
        // adding the player
        javafx.scene.image.Image playerImage = new javafx.scene.image.Image(getClass().getResourceAsStream("/ch1.png"));
        javafx.scene.image.ImageView player = new javafx.scene.image.ImageView(playerImage);

        // properties
        player.setFitWidth(40);
        player.setFitHeight(40);
        player.setX(0);
        player.setY(0);
        player.setPreserveRatio(true);




        // map screen switching
        // node
        Button btdBackToMain = new Button("Go To Main Screen");

        // node 2 Layer 1
        VBox uilayer2 = new VBox();
        uilayer2.getChildren().addAll(btdBackToMain);
        uilayer2.setAlignment(Pos.BOTTOM_CENTER);

        // node 1 Layer 0
        Pane gameWorld = new Pane();
        gameWorld.getChildren().addAll(player);


        // root scene 2
        StackPane map1Layout = new StackPane();
        map1Layout.getChildren().addAll(gameWorld, uilayer2);

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


//        stages

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
