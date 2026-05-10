package com.example.gameproject1;


import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Player implements Movable{
//    private ImageView sprite;
    GameScene gameScene;
    private ImageView player;
    private Set<KeyCode> inputBuffer;
    private AnimationTimer timer;

    public Player(GameScene gameScene) {
        this.gameScene = gameScene;
        inputBuffer = new HashSet<>();
        //        String imagePath
        createPlayer();
//        inputSetUp();
        setUpAnimation();

        //        // Load the image from the resources folder
//        Image image = new Image(getClass().getResourceAsStream(imagePath));
//
//        // Create the ImageView
//        this.sprite = new ImageView(image);
//
//        // Optional: set initial size if the image is too large
//        this.sprite.setFitWidth(50);
//        this.sprite.setFitHeight(50);
//        this.sprite.setPreserveRatio(true);
//    }
//
//    public ImageView getSprite() {
//        return sprite;
//    }
//
//    // Move the character
//    public void setPosition(double x, double y) {
//        sprite.setX(x);
//        sprite.setY(y);
    }

    private void createPlayer(){
        Image tileset = new Image(getClass().getResourceAsStream("/tilemap_packed.png"));
        player = new ImageView(tileset);

        int TILE_SIZE = 16;
        int col = 1;
        int row = 8;
        Rectangle2D characterRect = new Rectangle2D(col * TILE_SIZE, row * TILE_SIZE + 1, TILE_SIZE, TILE_SIZE);
        player.setViewport(characterRect);


        // properties
        player.setFitWidth(40);
        player.setFitHeight(40);
        player.setX(180);
        player.setY(130);
        player.setPreserveRatio(true);

    }
    public void inputSetUp(){
        // input settings
        // adding a key buffer to smooth the movement
        gameScene.getScene().setOnKeyPressed(event -> inputBuffer.add(event.getCode()));
        gameScene.getScene().setOnKeyReleased(event -> inputBuffer.remove(event.getCode()));

    }

    // now in the animation timer... check for the input buffer
    // checks again and again in the move
    private void setUpAnimation(){
        timer = new AnimationTimer(){
            @Override
            public void handle(long now){
                move();
            }
        };
        timer.start();
    }

    // move and add in the buffer!!
    public void move(){
        double speed = 5.0;
        if (inputBuffer.contains(KeyCode.W) || inputBuffer.contains(KeyCode.UP)) {
            player.setY(player.getY() - speed);
        }
        if (inputBuffer.contains(KeyCode.S) || inputBuffer.contains(KeyCode.DOWN)) {
            player.setY(player.getY() + speed);
        }
        if (inputBuffer.contains(KeyCode.A) || inputBuffer.contains(KeyCode.LEFT)) {
            player.setX(player.getX() - speed);
            player.setScaleX(-1);
        }
        if (inputBuffer.contains(KeyCode.D) || inputBuffer.contains(KeyCode.RIGHT)) {
            player.setX(player.getX() + speed);
            player.setScaleX(1);
        }
    }

    public ImageView getSprite(){
        return player;
    }
}