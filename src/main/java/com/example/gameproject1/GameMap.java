package com.example.gameproject1;


// the canvas should be here !!!
//GameMap gameMap = new GameMap();
//        gameMap.draw(gc);


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameMap {

    private final int TILE_SIZE = 32;

    private int[][] map = {
            {0,0,0,0,0,0,0},
            {0,0,1,1,1,0,0},
            {0,0,1,2,1,0,0},
            {0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0}
    };

    public void draw(GraphicsContext gc) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {

                int tileId = map[row][col];

                if (tileId == 1)
                    gc.setFill(Color.DARKGRAY);
                else if (tileId == 2)
                    gc.setFill(Color.GOLD);
                else
                    gc.setFill(Color.DARKGREEN);

                int x = col * TILE_SIZE;
                int y = row * TILE_SIZE;

                gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}



















//
//import javafx.scene.canvas.GraphicsContext;
//
//public class GameMap {
//
//
//    //      FUNCTION TO PAINT THE CANVAS
//    void drawMap(GraphicsContext gc){
//        for (int row = 0; row < map.length; row++) {
//            for (int col = 0; col < map[row].length; col++) {
//                int tileId = map[row][col];
//
//                if (tileId == 1) gc.setFill(javafx.scene.paint.Color.DARKGRAY);
//                else if (tileId == 2) gc.setFill(javafx.scene.paint.Color.GOLD);
//                else gc.setFill(javafx.scene.paint.Color.DARKGREEN);
//
//                int screenX = col * TILE_SIZE;
//                int screenY = row * TILE_SIZE;
//
//                gc.fillRect(screenX, screenY, TILE_SIZE, TILE_SIZE);
//            }
//        }
//
//
//    }
//}
