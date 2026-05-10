package com.example.gameproject1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScene {

    Scene scene;
    SceneManager sceneManager;
    private StackPane map1Layout;
    Player player;

    public GameScene(SceneManager sceneManager, Stage primaryStage) {
        this.sceneManager = sceneManager;
        player = new Player(this);



        Button btdBackToMain = new Button("Go To Main Screen");
        btdBackToMain.setFocusTraversable(false);

        // node 2 Layer 1
        VBox uilayer2 = new VBox();
        uilayer2.getChildren().addAll(btdBackToMain);
        uilayer2.setAlignment(Pos.BOTTOM_CENTER);

        // node 1 Layer 0
        Pane gameLayer = new Pane();
        Canvas gameWorld = new Canvas(640, 480);  // the brush
        GraphicsContext gc = gameWorld.getGraphicsContext2D(); // the brush

        gameLayer.getChildren().addAll(gameWorld, player.getSprite());
//        gameWorld.getChildren().addAll(player);

        // root scene 2
        map1Layout = new StackPane();
        map1Layout.setFocusTraversable(true);
        map1Layout.getChildren().addAll(gameLayer, uilayer2);

        scene = new Scene(map1Layout, 400, 300);
        player.inputSetUp();

        btdBackToMain.setOnAction(e -> sceneManager.switchToMain()); // change scene to main menu!
    }

    public void requestGameFocus(){
        map1Layout.requestFocus();
    }

    public Scene getScene() {
        return scene;
    }
}
