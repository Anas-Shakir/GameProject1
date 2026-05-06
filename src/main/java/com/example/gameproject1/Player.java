package com.example.gameproject1;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private ImageView sprite;

    public Player(String imagePath) {
        // Load the image from the resources folder
        Image image = new Image(getClass().getResourceAsStream(imagePath));

        // Create the ImageView
        this.sprite = new ImageView(image);

        // Optional: set initial size if the image is too large
        this.sprite.setFitWidth(50);
        this.sprite.setFitHeight(50);
        this.sprite.setPreserveRatio(true);
    }

    public ImageView getSprite() {
        return sprite;
    }

    // Move the character
    public void setPosition(double x, double y) {
        sprite.setX(x);
        sprite.setY(y);
    }
}