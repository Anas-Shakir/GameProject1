package com.example.gameproject1;

import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;



public class MainScreen {

    private Scene scene;
    private SceneManager sceneManager;

    public MainScreen(SceneManager sceneManager, Stage primaryStage) {
        this.sceneManager = sceneManager;
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
        TranslateTransition slideUp = new TranslateTransition(Duration.seconds(2), playButton);
        slideUp.setToY(0);

        slideUp.play();
        // properties
        playButton.setStyle(
                "-fx-background-color:  #f5f5dc"
        );
        // events
        playButton.setOnMouseEntered(e -> playButton.setStyle("-fx-background-color: #ff7f50"));
        playButton.setOnMouseExited(e -> playButton.setStyle("-fx-background-color:  #f5f5dc"));

        playButton.setOnAction(
                e -> {
                    sceneManager.switchToGame();
                }
        );

        // node 1
        VBox uiLayerMainScreen = new VBox();
        uiLayerMainScreen.getChildren().addAll(title, playButton);
        uiLayerMainScreen.setAlignment(Pos.CENTER);
        VBox.setMargin(title, new Insets(0, 0, 50, 0));

        // root scene 1
        StackPane root = new StackPane();
        root.getChildren().addAll(uiLayerMainScreen);
        // properties
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 400, 400);


        primaryStage.setScene(scene);

    }

    public Scene getScene() {
        return scene;
    }
}
