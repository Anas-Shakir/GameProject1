package com.example.gameproject1;

import com.sun.tools.javac.Main;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.image.Image;
//import javax.swing.text.html.ImageView;
//import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import static javafx.scene.input.KeyCode.*;

public class Launcher extends Application{

    @Override
    public void start(Stage primaryStage) {

        // procedure
        // start from base node
        // add to the upper node (container) by getchildren.addall()
        // In the above the order matters
        // then give the top level one to the scene
        // Give scene to the stage


////        scene 1
//        // making scene
//
//        // node 1.1
//        // Label and buttons
//        Label title = new Label("Welcome to the Game Human");
//
//        // properties
//        title.setFont(Font.font("Aerial", FontWeight.BOLD, 24));
//        title.setTextFill(Color.WHITE);
//
//        // node 1.2
//        Button playButton = new Button("Enter the World");
//
//        // Animation
//        playButton.setTranslateY(500);
//        TranslateTransition slideUp = new TranslateTransition(Duration.seconds(2), playButton);
//        slideUp.setToY(0);
//
//        slideUp.play();
//        // properties
//        playButton.setStyle(
//                "-fx-background-color:  #f5f5dc"
//        );
//        // events
//        playButton.setOnMouseEntered(e -> playButton.setStyle("-fx-background-color: #ff7f50"));
//        playButton.setOnMouseExited(e -> playButton.setStyle("-fx-background-color:  #f5f5dc"));
//
//        // node 1
//        VBox uiLayerMainScreen = new VBox();
//        uiLayerMainScreen.getChildren().addAll(title, playButton);
//        uiLayerMainScreen.setAlignment(Pos.CENTER);
//        VBox.setMargin(title, new Insets(0, 0, 50, 0));

//        MainScreen mainScreen = new MainScreen(primaryStage);
//        GameScene gameScene = new GameScene(primaryStage);

        SceneManager sceneManager = new SceneManager(primaryStage);



//        scene 2

        // node 1.1
        // adding the player
        // javafx.scene.image.Image playerImage = new javafx.scene.image.Image(getClass().getResourceAsStream("/ch1.png"));
        //javafx.scene.image.ImageView player = new javafx.scene.image.ImageView(playerImage);

        // something new from the tile sheet
//        Image tileset = new Image(getClass().getResourceAsStream("/tilemap_packed.png"));
//        ImageView player = new ImageView(tileset);
//
//        int TILE_SIZE = 16;
//        int col = 1;
//        int row = 8;
//        Rectangle2D characterRect = new Rectangle2D(col * TILE_SIZE, row * TILE_SIZE + 1, TILE_SIZE, TILE_SIZE);
//        player.setViewport(characterRect);
//
//
//        // properties
//        player.setFitWidth(40);
//        player.setFitHeight(40);
//        player.setX(0);
//        player.setY(0);
//        player.setPreserveRatio(true);


        // map screen switching
        // node
//        Button btdBackToMain = new Button("Go To Main Screen");
//
//        // node 2 Layer 1
//        VBox uilayer2 = new VBox();
//        uilayer2.getChildren().addAll(btdBackToMain);
//        uilayer2.setAlignment(Pos.BOTTOM_CENTER);
//
//        // node 1 Layer 0
//        Canvas gameWorld = new Canvas(640, 480);  // the brush
//        GraphicsContext gc = gameWorld.getGraphicsContext2D(); // the brush
//
//
////        gameWorld.getChildren().addAll(player);
//
//        // root scene 2
//        StackPane map1Layout = new StackPane();
//        map1Layout.getChildren().addAll(gameWorld, player, uilayer2);
//
//        Scene map1 = new Scene(map1Layout, 400, 300);
//
//        btdBackToMain.setOnAction(e -> primaryStage.setScene(s));








//        // input settings
//        //THE FOLLOWING SHOULD BE ADDED IN TEH ACTUAL PLAYER CLASS! OR TO SOME INTERFACE
//
//        // adding a key buffer to smooth the movement
//        Set<KeyCode> inputBuffer = new HashSet<>();
//
//        map1.setOnKeyPressed(event -> inputBuffer.add(event.getCode()));
//        map1.setOnKeyReleased(event -> inputBuffer.remove(event.getCode()));
//
////        now in the animation timer... check for the input buffer
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                double speed = 5.0;
//                if (inputBuffer.contains(KeyCode.W) || inputBuffer.contains(KeyCode.UP)) {
//                    player.setY(player.getY() - speed);
//                }
//                if (inputBuffer.contains(KeyCode.S) || inputBuffer.contains(KeyCode.DOWN)) {
//                    player.setY(player.getY() + speed);
//                }
//                if (inputBuffer.contains(KeyCode.A) || inputBuffer.contains(KeyCode.LEFT)) {
//                    player.setX(player.getX() - speed);
//                }
//                if (inputBuffer.contains(KeyCode.D) || inputBuffer.contains(KeyCode.RIGHT)) {
//                    player.setX(player.getX() + speed);
//                }
//            }
//        };
//        GameMap gameMap = new GameMap();
//        gameMap.draw(gc);
//        timer.start();


//        stages

        // Stage setting
        primaryStage.setTitle("Game Project");
        primaryStage.show();

    }

    public static void main(String[] args) {
//        Application.launch(HelloApplication.class, args);
        launch(args);
    }
}
