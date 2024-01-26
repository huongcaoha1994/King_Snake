package com.example.snakegame.resources;

import com.example.snakegame.models.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Draws {
    public void draw(Point food,Point boss, Point snake, int width, int height, GraphicsContext gc,int tileSize, int score){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,width,height);

        gc.setFill(Color.RED);
        gc.fillRect(snake.getX(), snake.getY(),tileSize,tileSize );

        gc.setFill(Color.BLACK);
        gc.fillRect(boss.getX(), boss.getY(), tileSize,tileSize);

        gc.setFill(Color.GREEN);
        gc.fillRect(food.getX(), food.getY(), tileSize,tileSize);

        gc.fillText("Score : "+ score,20,20);
    }
}
