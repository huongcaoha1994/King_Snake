package com.example.snake_game.resources;

import com.example.snake_game.models.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class Draws {
    Image snakeImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\snake.jpg");
    Image bossImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\pacman.png");
    Image foodImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\food.jpg");
    Image monsterImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\monster.jpg");
    Image monsterEatImage = new Image("file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\monsterEat.jpg") ;

    public void draw(Point food, Point boss, Point snake, int width, int height, GraphicsContext gc, int tileSize, int score, Point monsters){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,width,height);
        gc.drawImage(snakeImage,snake.getX(),snake.getY(),tileSize,tileSize);

        gc.drawImage(bossImage, boss.getX(), boss.getY(),tileSize,tileSize);

        gc.drawImage(foodImage, food.getX(), food.getY(), tileSize,tileSize);


        gc.setFill(Color.RED);
        gc.strokeRect(0,0,tileSize*10-2,tileSize*10-2);

        gc.setStroke(Color.BLACK);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }

            gc.drawImage(monsterImage, monsters.getX(), monsters.getY(),tileSize,tileSize);

        Font font = new Font("Arial", 24); // Đặt kích thước chữ
        gc.setFont(font);
        gc.fillText("Score : "+ score,width/2,tileSize);
    }

    public void drawGame2(GraphicsContext gc ,Point snake , Point monsterEat , Point monsterLeft, Point monsterRight,Point food ,int tileSize,int width,int height,int score){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,width,height);
        gc.drawImage(snakeImage,snake.getX(),snake.getY(),tileSize,tileSize);

        gc.drawImage(monsterImage, monsterLeft.getX(), monsterLeft.getY(),tileSize,tileSize);
        gc.drawImage(monsterImage, monsterRight.getX(), monsterRight.getY(),tileSize,tileSize);


        gc.drawImage(foodImage, food.getX(), food.getY(), tileSize,tileSize);

        gc.drawImage(monsterEatImage,monsterEat.getX(),monsterEat.getY(),tileSize,tileSize);

        gc.setStroke(Color.BLACK);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }


        Font font = new Font("Arial", 24); // Đặt kích thước chữ
        gc.setFont(font);
        gc.fillText("Score : "+ score,width/2,tileSize);
    }
}
