package com.example.snake_game.resources;

import com.example.snake_game.models.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Draws {
    Image snakeImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\snake.jpg");
    Image bossImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\pacman.png");
    Image foodImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\food.jpg");
    public void draw(Point food,Point boss, Point snake, int width, int height, GraphicsContext gc,int tileSize, int score){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,width,height);
        gc.drawImage(snakeImage,snake.getX(),snake.getY(),tileSize,tileSize);

        gc.drawImage(bossImage, boss.getX(), boss.getY(),tileSize,tileSize);

        gc.drawImage(foodImage, food.getX(), food.getY(), tileSize,tileSize);

        gc.fillText("Score : "+ score,20,20);

        gc.setFill(Color.RED);
        gc.strokeRect(0,0,width/2-99,height/2-99);

        gc.setStroke(Color.BLACK);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }
    }
}
