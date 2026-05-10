package com.example.gameproject1;

import javafx.application.Platform;
import javafx.stage.Stage;

public class SceneManager {
    MainScreen mainScreen;
    GameScene gameScene;
    Stage primaryStage;

    SceneManager(Stage primaryStage){
//        this.main = main;
//        this. gameScene = gameScene;
        this.primaryStage = primaryStage;

        MainScreen mainScreen = new MainScreen(this, primaryStage);
        GameScene gameScene = new GameScene(this, primaryStage);

        this.mainScreen = mainScreen;
        this.gameScene = gameScene;

    }

    void switchToGame(){
        primaryStage.setScene(gameScene.getScene());
        Platform.runLater(() -> {
            gameScene.requestGameFocus();
        });
//        gameScene.requestGameFocus();
    }
    void switchToMain(){
        primaryStage.setScene(mainScreen.getScene());
    }

    public MainScreen getMainScreen(){
        return mainScreen;
    }

    public GameScene getGameScene() {
        return gameScene;
    }
}
