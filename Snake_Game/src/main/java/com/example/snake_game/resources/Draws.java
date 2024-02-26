package com.example.snake_game.resources;

import com.example.snake_game.models.GetSnakeDisplay;
import com.example.snake_game.models.Point;
import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.StringPathImage;
import javafx.beans.property.IntegerProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class Draws {
    Image snakeImage = new Image(StringPathImage.snakeyellow_gif());
    Image bossImage = new Image(StringPathImage.hero_gif());
    Image foodImage = new Image(StringPathImage.key_gif());
    Image monsterImage = new Image(StringPathImage.hero2_gif());
    Image monsterEatImage = new Image(StringPathImage.monsterEat_gif());
    Image monsterGunImage = new Image(StringPathImage.monsterGun_gif());
    Image bulletImage = new Image(StringPathImage.bullet_jpg());
    Image background = new Image(StringPathImage.hinhnen_jpg());
    Image gateImage = new Image(StringPathImage.gatespace_jpg());
    Image coinImage = new Image(StringPathImage.coin_gif());

    public void draw(Point food, Point boss, Point snake, int width, int height, GraphicsContext gc, int tileSize, IntegerProperty score, Point monsters,Image skin) {
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, width, height);
//        gc.drawImage(background,0,0,width,height);
        if(score.get() == 15){
            gc.drawImage(gateImage,width/2,0,tileSize,tileSize);
        }else {
            gc.drawImage(foodImage, food.getX(), food.getY(), tileSize, tileSize);
        }

        gc.drawImage(skin, snake.getX(), snake.getY(), tileSize, tileSize);

        gc.drawImage(bossImage, boss.getX(), boss.getY(), tileSize, tileSize);

        gc.setFill(Color.RED);
        gc.strokeRect(0, 0, tileSize * 10 - 3, tileSize * 10 - 3);

        gc.setStroke(Color.WHITE);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }

        gc.drawImage(monsterImage, monsters.getX(), monsters.getY(), tileSize, tileSize);

        Font font = new Font("Arial", 24); // Đặt kích thước chữ
        gc.setFont(font);
        gc.fillText("Score : " + score.get(), 0, tileSize);


    }
    public void drawGameRank(Point food, Point boss, Point snake, int width, int height, GraphicsContext gc, int tileSize, IntegerProperty score, Point monsters,Image skin) {
        gc.setFill(Color.CORAL);
        gc.fillRect(0, 0, width, height);
//        gc.drawImage(background,0,0,width,height);
            gc.drawImage(coinImage, food.getX(), food.getY(), tileSize, tileSize);

        gc.drawImage(skin, snake.getX(), snake.getY(), tileSize, tileSize);

        gc.drawImage(bossImage, boss.getX(), boss.getY(), tileSize, tileSize);

        gc.setFill(Color.RED);
        gc.strokeRect(0, 0, tileSize * 10 - 3, tileSize * 10 - 3);

        gc.setStroke(Color.WHITE);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }

        gc.drawImage(monsterImage, monsters.getX(), monsters.getY(), tileSize, tileSize);

        Font font = new Font("Arial", 24); // Đặt kích thước chữ
        gc.setFont(font);
        gc.fillText("Score : " + score.get(), 0, tileSize);


    }

    public void drawGame2(GraphicsContext gc, Point snake, Point monsterEat, Point monsterLeft, Point monsterRight, Point food, int tileSize, int width, int height, IntegerProperty score,Image skin) {
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 0, width, height);
        gc.drawImage(skin, snake.getX(), snake.getY(), tileSize, tileSize);

        gc.drawImage(monsterImage, monsterLeft.getX(), monsterLeft.getY(), tileSize, tileSize);
        gc.drawImage(bossImage, monsterRight.getX(), monsterRight.getY(), tileSize, tileSize);


        if(score.get() >= 15){
            gc.drawImage(gateImage,width/2,0,tileSize,tileSize);
        }else {
            gc.drawImage(foodImage, food.getX(), food.getY(), tileSize, tileSize);
        }

        gc.drawImage(monsterEatImage, monsterEat.getX(), monsterEat.getY(), tileSize, tileSize);

        gc.setStroke(Color.BLACK);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }

        gc.setFill(Color.RED);
        gc.fillRect(0, tileSize*7 + tileSize, width, 2);
        gc.fillRect(width / 2, tileSize*7 + tileSize, 2, height / 2);

        Font font = new Font("Arial", 24); // Đặt kích thước chữ
        gc.setFont(font);
        gc.setFill(Color.RED);
        gc.fillText("Score : " + score.get(), 0, tileSize);
    }

    public void drawGame3(GraphicsContext gc, int width, int height, int tileSize, Point snake, Point monsterEat, Point monsterGun, List<Point> bullets,Point food,IntegerProperty score,Point monster,Image skin) {
        gc.setFill(Color.OLDLACE);
        gc.fillRect(0, 0, width, height);

        gc.setStroke(Color.BLACK);
        for (int x = 0; x < width; x += tileSize) {
            gc.strokeLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += tileSize) {
            gc.strokeLine(0, y, width, y);
        }

        gc.drawImage(skin, snake.getX(), snake.getY(), tileSize, tileSize);

        gc.drawImage(monsterEatImage, monsterEat.getX(), monsterEat.getY(), tileSize, tileSize);

        gc.drawImage(monsterImage, monster.getX(), monster.getY(),tileSize,tileSize);

        gc.drawImage(monsterGunImage, monsterGun.getX(), monsterGun.getY(), tileSize, tileSize);

        if(score.get() >= 15){
            gc.drawImage(gateImage,width/2,0,tileSize,tileSize);
        }else {
            gc.drawImage(foodImage, food.getX(), food.getY(), tileSize, tileSize);
        }

        gc.setFill(Color.RED);
        gc.fillRect(0, tileSize, width, 2);

        Font font = new Font("Arial", 24); // Đặt kích thước chữ
        gc.setFont(font);
        gc.setFill(Color.RED);
        gc.fillText("Score : " + score.get(), 0, tileSize);

    }

    public void drawBullet(GraphicsContext gc,List<Point> bullets,int tileSize){
        for (int i = 0; i < bullets.size(); i++) {
            gc.drawImage(bulletImage, bullets.get(i).getX(), bullets.get(i).getY(), tileSize, tileSize);
        }
    }
    public void drawsnake(GraphicsContext gc ,Point snake,int tileSize){
        gc.drawImage(snakeImage, snake.getX(), snake.getY(), tileSize, tileSize);
    }

    public void drawboss(GraphicsContext gc ,Point boss,int tileSize){
        gc.drawImage(bossImage, boss.getX(), boss.getY(), tileSize, tileSize);
    }

    public void drawmonster(GraphicsContext gc ,Point monster,int tileSize){
        gc.drawImage(monsterImage, monster.getX(), monster.getY(), tileSize, tileSize);
    }

    public void drawfood(GraphicsContext gc ,Point food,int tileSize){
        gc.drawImage(foodImage, food.getX(), food.getY(), tileSize, tileSize);
    }

    public void drawbackground(GraphicsContext gc,int width ,int height){
        gc.drawImage(background, 0, 0, width, height);
    }

    public void demo(GraphicsContext gc , Point snake , int tileSize,int width ,int height){
        gc.drawImage(background, 0, 0,width,height);
        gc.drawImage(snakeImage, snake.getX(), snake.getY(),tileSize,tileSize);

    }

//    public void drawGate(GraphicsContext gc ,int width ,int height,int tileSize){
//        gc.drawImage(gateImage,width/2,height/2,tileSize,tileSize);
//    }

}
