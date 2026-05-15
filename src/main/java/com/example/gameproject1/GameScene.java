package com.example.gameproject1;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;


public class GameScene {

    Scene scene;
    SceneManager sceneManager;
    private StackPane map1Layout;
    Player player;
    GameMap gameMap;
    final int GAME_WIDTH = 15 * 65;
    final int GAME_HEIGHT = 15 * 45;
    final double zoom = 3.0;

    public GameScene(SceneManager sceneManager, Stage primaryStage) {
        this.sceneManager = sceneManager;
        player = new Player(this);

        Button btdBackToMain = new Button("Go To Main Screen");
        btdBackToMain.setFocusTraversable(false);

        VBox uilayer2 = new VBox();
        uilayer2.getChildren().add(btdBackToMain);
        uilayer2.setAlignment(Pos.BOTTOM_CENTER);

        int MAP_COLS = 65;
        int MAP_ROWS = 44;
        int TILE_SIZE = 15;

        Canvas gameWorld = new Canvas(MAP_COLS * TILE_SIZE, MAP_ROWS * TILE_SIZE);
        GraphicsContext gc = gameWorld.getGraphicsContext2D();
        gameMap = new GameMap();
        gameMap.draw(gc);

        // later to put in the npc class
        Image spriteSheet = new Image("tilemap_packed.png");
        ImageView npc1 = new ImageView(spriteSheet);

        Rectangle2D npcRect = new Rectangle2D(0, 113, 15, 15);
        npc1.setViewport(npcRect);
        npc1.setTranslateX(10);
        npc1.setTranslateY(10);


        // gameLayer: holds map + player, we TRANSLATE this
        Group gameLayer = new Group();
        gameLayer.getChildren().addAll(gameWorld, player.getSprite(), npc1);

        // zoomedWorld: holds gameLayer, we ZOOM this — NO StackPane or Pane in between
        Group zoomedWorld = new Group(gameLayer);

        // spawn point pivot for zoom
        double spawnX = player.getX() + player.getSprite().getFitWidth() / 2;
        double spawnY = player.getY() + player.getSprite().getFitHeight() / 2;

        // apply zoom ONCE, pivoting around player spawn
        zoomedWorld.getTransforms().add(new Scale(zoom, zoom, spawnX, spawnY));

        // set initial offset ONCE so player is centered on first frame
        gameLayer.setTranslateX((GAME_WIDTH / 2.0 / zoom) - spawnX);
        gameLayer.setTranslateY((GAME_HEIGHT / 2.0 / zoom) - spawnY);

















        // root: zoomedWorld + UI on top
        map1Layout = new StackPane();
        map1Layout.setFocusTraversable(true);
        map1Layout.setMinSize(GAME_WIDTH, GAME_HEIGHT);
        map1Layout.setMaxSize(GAME_WIDTH, GAME_HEIGHT);
        map1Layout.getChildren().addAll(zoomedWorld, uilayer2);

        scene = new Scene(map1Layout, GAME_WIDTH, GAME_HEIGHT);
        player.inputSetUp();

        btdBackToMain.setOnAction(e -> sceneManager.switchToMain());

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.move();

                // recalculate center each frame as player moves
                double playerCX = player.getX() + player.getSprite().getFitWidth() / 2;
                double playerCY = player.getY() + player.getSprite().getFitHeight() / 2;

                // translate in world space (pre-zoom), so divide screen center by zoom
                gameLayer.setTranslateX((GAME_WIDTH / 2.0 / zoom) - playerCX);
                gameLayer.setTranslateY((GAME_HEIGHT / 2.0 / zoom) - playerCY);
            }
        };
        timer.start();
    }

    public void requestGameFocus() {
        map1Layout.requestFocus();
    }

    public Scene getScene() {
        return scene;
    }
}













































// ....................................................................................................

//public class GameScene {
//
//    Scene scene;
//    SceneManager sceneManager;
//    private StackPane map1Layout;
//    Player player;
//    GameMap gameMap;
//    final int GAME_WIDTH = 15 * 65;
//    final int GAME_HEIGHT = 15 * 45;
//
//    public GameScene(SceneManager sceneManager, Stage primaryStage) {
//        this.sceneManager = sceneManager;
//        player = new Player(this);
//
//
//        Button btdBackToMain = new Button("Go To Main Screen");
//        btdBackToMain.setFocusTraversable(false);
//
//        // node 2 Layer 1
//        VBox uilayer2 = new VBox();
//        uilayer2.getChildren().addAll(btdBackToMain);
//        uilayer2.setAlignment(Pos.BOTTOM_CENTER);
//
//        // node 1 Layer 0
//        int MAP_COLS = 65;
//        int MAP_ROWS = 44;
//        int TILE_SIZE = 15;
//
//        Group gameLayer = new Group();
//        Canvas gameWorld = new Canvas(MAP_COLS * TILE_SIZE, MAP_ROWS * TILE_SIZE);  // the brush
//        GraphicsContext gc = gameWorld.getGraphicsContext2D(); // the brush
////        gameLayer.
//        gameLayer.getChildren().addAll(gameWorld, player.getSprite());
////        gameWorld.getChildren().addAll(player);
//        gameMap = new GameMap();
//        gameMap.draw(gc);
//
//
//        // root scene 2
//        map1Layout = new StackPane();
//        map1Layout.setFocusTraversable(true);
//        map1Layout.setMinSize(GAME_WIDTH, GAME_HEIGHT);
//        map1Layout.setMaxSize(GAME_WIDTH, GAME_HEIGHT);
//        map1Layout.getChildren().addAll(gameLayer, uilayer2);
//
////        zoomed world
//        Pane zoomedWorld = new Pane();
//        double zoom = 3;
//
//
//        zoomedWorld.setScaleX(zoom);
//        zoomedWorld.setScaleY(zoom);
////
////        Scale zoomTransform = new Scale();
////        zoomTransform.setX(zoom);
////        zoomTransform.setY(zoom);
////
////        zoomTransform.setPivotX(200);
////        zoomTransform.setPivotY(150);
////        zoomedWorld.setScaleY().;
//        zoomedWorld.getChildren().add(map1Layout);
////        zoomedWorld.se
//
//        // wrapper
//        StackPane wrapper = new StackPane();
//        wrapper.setStyle("-fx-background-color: black;");
//        wrapper.getChildren().add(zoomedWorld);
////        wrapper.setAlignment(Pos.CENTER);
//
//        scene = new Scene(wrapper, GAME_WIDTH, GAME_HEIGHT);
//        // 640 to 480
//        player.inputSetUp();
//
//        btdBackToMain.setOnAction(e -> sceneManager.switchToMain()); // change scene to main menu!
//
//
//        double spawnX = player.getX() + player.getSprite().getFitWidth() / 2;
//        double spawnY = player.getY() + player.getSprite().getFitHeight() / 2;
//
//        // checks again and again in the move
//            AnimationTimer timer = new AnimationTimer() {
//                @Override
//                public void handle(long now) {
//                    player.move();
//
//                    double playerCenterX = player.getX() + player.getSprite().getFitWidth() / 2;
//                    double playerCenterY = player.getY() + player.getSprite().getFitHeight() / 2;
//
//                    double offsetX = (GAME_WIDTH / 2.0 / zoom) - (playerCenterX);
//                    double offsetY = (GAME_HEIGHT / 2.0 / zoom) - (playerCenterY);
//
//
//                    Scale zoomTransform = new Scale(zoom, zoom, spawnX, spawnY);
//                    zoomedWorld.getTransforms().add(zoomTransform);
//
//                    gameLayer.setTranslateX(offsetX);
//                    gameLayer.setTranslateY(offsetY);
//
//
//
//
//
//
////                    double offsetX = GAME_WIDTH / 2 - player.getX();
////                    double offsetY = GAME_HEIGHT / 2 - player.getY();
////                    gameLayer.setTranslateX(offsetX -2);
////                    gameLayer.setTranslateY(offsetY- 2);
//
////                    double offsetX = (GAME_WIDTH / 2) - (player.getX() * zoom) - (player.getSprite().getBoundsInLocal().getWidth() * zoom / 2);
////                    double offsetY = (GAME_HEIGHT / 2) - (player.getY() * zoom) - (player.getSprite().getBoundsInLocal().getHeight() * zoom / 2);
//
//
//
//                }
//            };
//            timer.start();
//        }
//
//
//
//
//    public void requestGameFocus(){
//        map1Layout.requestFocus();
//    }
//
//    public Scene getScene() {
//        return scene;
//    }
//}
